package br.com.instrumentedtests;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.test.rule.ServiceTestRule;
import android.util.Log;

import java.util.concurrent.TimeoutException;

/**
 * Created by Shido on 01/03/2017.
 */

public class MyServiceTestRule extends ServiceTestRule{

    @Override
    public void startService(@NonNull Intent intent) throws TimeoutException {
        Log.e("SERVICE TEST RULE", "Starting service");
        super.startService(intent);
    }

    @Override
    public IBinder bindService(@NonNull Intent intent) throws TimeoutException {
        Log.e("SERVICE TEST RULE", "Binding the service");

        return super.bindService(intent);
    }

    @Override
    protected void beforeService() {
        Log.e("SERVICE TEST RULE", "Work Before Service Starts");

        super.beforeService();
    }

    @Override
    protected void afterService() {
        Log.e("SERVICE TEST RULE", "Work after Service Starts");
        super.afterService();
    }
}
