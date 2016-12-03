package ca.stefanm.gpsfrequencystatus.services;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Stefan on 12/3/2016.
 */

public abstract class AbstractLocationReceiverService extends Service implements ILocationListener {

    @Override
    public void OnLocationChanged(Location location) {


        //Here we call the file logger.

        //Analogous to the fence handler service.

    }
    

    public void setLocationListener(ILocationListener locationListener){

    }



}
