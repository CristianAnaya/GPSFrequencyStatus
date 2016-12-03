package ca.stefanm.gpsfrequencystatus.logging;

import android.content.Context;

/**
 * Created by Stefan on 12/3/2016.
 */
public class FileLogger {
    private static FileLogger ourInstance = new FileLogger();

    public static FileLogger getInstance(Context c) {
        ourInstance.context = c;
        return ourInstance;
    }

    private FileLogger() {
    }


    private Context context;

    private int fileNumber = 0;

    public void incrementFileNumver() {
        fileNumber++;
    }

    public static String filenameBase = "GPSFrequencyStatus_";

}
