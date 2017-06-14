package com.krapinem.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class KrapinemIntentService extends IntentService {

    private final static String TAG = "com.krapinem";

    public KrapinemIntentService() {
        super("KrapinemIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //This part of code runs for service
        Log.i(TAG,"The Service has now Started!!!");        //Need to modify AndroidManifest so to aware about using Service
    }
}
