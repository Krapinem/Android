package com.krapinem.intentservice;

import android.app.Service;
import android.content.Intent;
import android.nfc.Tag;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "com.krapinem.intentser";

    public MyService() {
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy method called.");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand method is called");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++){
                    long futureTime = System.currentTimeMillis()+5000;
                    while (System.currentTimeMillis() < futureTime){
                        synchronized (this){
                            try {
                                wait(futureTime-System.currentTimeMillis());
                                Log.i(TAG,"Service is doing Something...");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };

        Thread thread = new Thread(r);
        thread.start();


        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
    return null;
   }
}
