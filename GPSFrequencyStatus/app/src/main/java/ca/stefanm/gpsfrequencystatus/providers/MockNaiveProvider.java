package ca.stefanm.gpsfrequencystatus.providers;

import android.content.Context;

import ca.stefanm.gpsfrequencystatus.services.ILocationListener;

/**
 * Created by Stefan on 12/3/2016.
 */

public class MockNaiveProvider extends AbstractLocationProvider {

    public MockNaiveProvider(Context c) {
        super(c);
    }

    @Override
    public void stopProvider() {

    }

    @Override
    public void startProvider() {

    }

    @Override
    public void setLocationListener(ILocationListener listener) {

    }
}
