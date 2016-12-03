package ca.stefanm.gpsfrequencystatus.services;

import android.location.Location;

/**
 * Created by Stefan on 12/3/2016.
 */

public interface ILocationListener {

    public void OnLocationChanged(Location location);

}
