package ca.stefanm.gpsfrequencystatus.services;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Runs in the same process, different non-UI thread, as the main applicaiton.
 * Created by Stefan on 12/3/2016.
 */

public class ForegroundLocationRecieverService extends AbstractLocationReceiverService {




    //The service specifies the location provider and passes a reference to itself?




    //Needs to be in a separate process with a notification to be a foreground process.

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
