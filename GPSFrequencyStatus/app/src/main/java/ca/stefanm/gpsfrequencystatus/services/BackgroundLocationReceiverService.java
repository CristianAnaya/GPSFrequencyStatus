package ca.stefanm.gpsfrequencystatus.services;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Should run in a separate process, have a notification visible.
 * Created by Stefan on 12/3/2016.
 */

public class BackgroundLocationReceiverService extends AbstractLocationReceiverService {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
