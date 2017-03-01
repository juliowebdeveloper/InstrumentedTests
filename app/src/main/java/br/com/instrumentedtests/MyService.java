package br.com.instrumentedtests;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.e("MYSERVICE", "Creating My Service");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.e("MYSERVICE", "executing some work");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {

        Log.e("MYSERVICE", "destroying my service");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       return new LocalBinder();
    }


    public class LocalBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }

}
