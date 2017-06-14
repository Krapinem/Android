package com.krapinem.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MyService extends Service {

    final private IBinder binder = new MyLocalBinder();     //2 called to return the object which is the instance of MyLocalBinder class

    public MyService() {
    }
    public String showCurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss",Locale.getDefault());
        return (df.format(new Date()));
    }

    //Called first
    @Override
    public IBinder onBind(Intent intent) {                  //1 onBind is called first
        return binder;
    }

    public class MyLocalBinder extends Binder{
        MyService getService(){                             //3This Class bind the MyService so that everything is accessible here
            return MyService.this;
        }
    }

}
