package ca.stefanm.gpsfrequencystatus;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ca.stefanm.gpsfrequencystatus.providers.AbstractLocationProvider;
import ca.stefanm.gpsfrequencystatus.providers.FusedListenerProvider;
import ca.stefanm.gpsfrequencystatus.providers.FusedPendingIntentProvider;
import ca.stefanm.gpsfrequencystatus.providers.MockFusedProvider;
import ca.stefanm.gpsfrequencystatus.providers.MockNaiveProvider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @BindView(R.id.bOpenLogFile) Button bOpenLogFile;

    @BindView(R.id.buttonStartProvider)Button bStartProvider;
    @BindView(R.id.buttonStopProvider) Button bStopProvider;

    @BindView(R.id.cbBackgroundLog) CheckBox cbBackgroundLog;
    @BindView(R.id.cbLogPublicFile) CheckBox cbLogPublicFile;

    @BindView(R.id.rbFusedListener) RadioButton rbFusedListener;
    @BindView(R.id.rbFusedPendingIntent) RadioButton rbFusedPendingIntent;
    @BindView(R.id.rbMockFused) RadioButton rbMockFused;
    @BindView(R.id.rbMockNaive) RadioButton rbMockNaive;

    @BindView(R.id.tvStatusFlag) TextView fusedLocationProviderStatus;
    public static final String FUSED_RUNNING = "RUNNING";
    public static final String FUSED_STOPPED = "STOPPED";


    Class selectedAbstractLocationProvider;


    @OnClick({  R.id.rbFusedListener,
                R.id.rbFusedPendingIntent,
                R.id.rbMockFused,
                R.id.rbMockNaive })
    public void  onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton)view).isChecked();

        RadioButton radioButton = (RadioButton) view;

        switch(radioButton.getId()){
            case R.id.rbFusedListener:
                if (checked)
                    selectedAbstractLocationProvider = FusedListenerProvider.class;
                break;
            case R.id.rbFusedPendingIntent:
                if (checked)
                    selectedAbstractLocationProvider = FusedPendingIntentProvider.class;
                break;
            case R.id.rbMockFused:
                if (checked)
                    selectedAbstractLocationProvider = MockFusedProvider.class;
                break;
            case R.id.rbMockNaive:
                if (checked)
                    selectedAbstractLocationProvider = MockNaiveProvider.class;
                break;
            default:
                break;
        }
    }



    @OnClick(R.id.bOpenLogFile)
    private void ShowLogFiles(){
        Intent i = new Intent(this, LogfileBrowseActivity.class);
        startActivity(i);
    }


}
