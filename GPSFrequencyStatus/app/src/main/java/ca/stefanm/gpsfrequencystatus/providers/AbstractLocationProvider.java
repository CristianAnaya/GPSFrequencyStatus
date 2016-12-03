package ca.stefanm.gpsfrequencystatus.providers;

import android.content.Context;

import ca.stefanm.gpsfrequencystatus.services.ILocationListener;

/**
 * Created by Stefan on 12/3/2016.
 */

public abstract class AbstractLocationProvider {

    public ILocationListener locationListener;

    public abstract void stopProvider();
    public abstract void startProvider();

    public abstract void setLocationListener(ILocationListener listener);

    public AbstractLocationProvider(Context c){
        context = c;
    }

    private Context context;

}
