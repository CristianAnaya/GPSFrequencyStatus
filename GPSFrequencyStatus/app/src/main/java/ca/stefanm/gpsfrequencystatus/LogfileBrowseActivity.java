package ca.stefanm.gpsfrequencystatus;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import ca.stefanm.gpsfrequencystatus.logging.FileLogger;

public class LogfileBrowseActivity extends AppCompatActivity {

    @BindView(R.id.logfileList) ListView logfileList;

    LogfileListAdapter logfileListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logfile_browse);

        ButterKnife.bind(this);

        logfileListAdapter = new LogfileListAdapter(this, R.id.logfileList);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onResume(){
        super.onResume();
        if (logfileListAdapter != null) {
            updateFileList(this.logfileListAdapter);
        }
    }

    private void updateFileList(LogfileListAdapter listAdapter) {

        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.contains(FileLogger.filenameBase);
            }
        };

        String[] matchingFilenameArray = getFilesDir().list(filenameFilter);

        if (matchingFilenameArray.length == 0) {
            Toast.makeText(this, "No matching logfiles found.", Toast.LENGTH_SHORT).show();
        }

        List<File> fileList = new ArrayList<>();

        for (String filename : matchingFilenameArray){
            fileList.add(new File(filename));
        }

        listAdapter.clear();
        listAdapter.addAll(fileList);

        listAdapter.notifyDataSetChanged();
    }

    private class LogfileListAdapter extends ArrayAdapter<File> {

        public LogfileListAdapter(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            File file = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.logfile_list_item, parent, false);
            }
            // Lookup view for data population
            TextView tvName = (TextView) convertView.findViewById(R.id.tvLiFileName);
            // Populate the data into the template view using the data object
            tvName.setText(file.getAbsolutePath());

            // Return the completed view to render on screen
            return convertView;
        }
    }

    @OnItemClick(R.id.logfileList)
    void onItemSelected(int position) {

        File fileSelected = null;

        if (logfileListAdapter != null){
            fileSelected = logfileListAdapter.getItem(position);
        }
        showLogFile(fileSelected);
    }

    private void showLogFile(File logfile) {
        //Send an intent to show the log file in an html viewer

        if (logfile == null){
            Toast.makeText(this, "File object is null.", Toast.LENGTH_SHORT).show();
        }

        if (!logfile.exists()){
            Toast.makeText(this, "Log file " + logfile.getAbsolutePath() +" does not exist.", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.fromFile(logfile));
            i.addCategory(Intent.CATEGORY_BROWSABLE);
            startActivity(i);
        }
    }
}
