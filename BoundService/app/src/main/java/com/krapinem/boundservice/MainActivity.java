package com.krapinem.boundservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.os.IBinder;
import android.content.Intent;
import android.content.Context;
import android.content.ComponentName;
import android.content.ServiceConnection;
import com.krapinem.boundservice.MyService.MyLocalBinder;

public class MainActivity extends AppCompatActivity {

    MyService myService;
    boolean isBound = false;

    public void showTime(View view){
        String currentTime = myService.showCurrentTime();
        TextView mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setText(currentTime);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this,MyService.class);
        bindService(i,mServiceConnection,Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyLocalBinder myLocalBinder = (MyLocalBinder) service;
            myService = myLocalBinder.getService();
            isBound=true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound=false;
        }
    };

}
