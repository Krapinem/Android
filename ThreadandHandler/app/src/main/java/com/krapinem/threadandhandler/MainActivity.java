package com.krapinem.threadandhandler;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            TextView mTextView = (TextView) findViewById(R.id.textView);
            mTextView.setText("Hey Ross Whats Up!!!");
        }
    };

    private TextView counttxt;
    private int countint;
    private int seamopher=0;

    Handler handler2 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            counttxt = (TextView) findViewById(R.id.count);
            counttxt.setText(countint+"");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                long futureTime = System.currentTimeMillis()+10000;
                while(System.currentTimeMillis()<futureTime) {
                    synchronized (this) {       //thread use synchronized to lock the object before going in wait
                        try {
                            wait(futureTime - System.currentTimeMillis());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                handler.sendEmptyMessage(0);
            }
        };
        Runnable r1 = new Runnable() {
            int i =1;
            @Override
            public void run() {
                if(seamopher==0){
                    seamopher=1;
                    while (i <= 10) {
                        synchronized (this) {
                            try {
                                wait(1000);
                            }   catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        countint=i++;
                        handler2.sendEmptyMessage(0);
                    }
                    seamopher=0;
                }

            }
        };


        Thread changeThread = new Thread(r);
        changeThread.start();
        Thread count = new Thread(r1);
        count.start();
    }
}
