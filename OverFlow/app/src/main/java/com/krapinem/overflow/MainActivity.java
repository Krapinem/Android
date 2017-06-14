package com.krapinem.overflow;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.view.GestureDetector;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener  {

    RelativeLayout mRelativeLayout;
    private GestureDetectorCompat gestureDetector;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.gestureDetector = new GestureDetectorCompat(this,this);
           //Action Listner

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.content_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRelativeLayout.setBackgroundColor(Color.WHITE);
                Snackbar.make(view, "Reset color to white.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }

    @Override   //This Is Added to get the TouchEvent to Integrate with the Gesture to find out what the user is doing on Screen
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);   //Each time is Detect the user gesture activity and find what was the gesture
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.red : if(item.isChecked())
                                item.setChecked(false);
                            else
                                item.setChecked(true);
                            mRelativeLayout.setBackgroundColor(Color.RED);
                            return true;
            case R.id.green : if(item.isChecked())
                                    item.setChecked(false);
                                else
                                    item.setChecked(true);
                                mRelativeLayout.setBackgroundColor(Color.GREEN);
                                return true;
            case R.id.blue : if(item.isChecked())
                                item.setChecked(false);
                             else
                                item.setChecked(true);
                            mRelativeLayout.setBackgroundColor(Color.BLUE);
                            return true;
            default:        return super.onOptionsItemSelected(item);

        }
    }



    @Override
    public boolean onSingleTapUp(MotionEvent e) {

        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
       // mRelativeLayout.setBackgroundColor((int)(distanceX*distanceY)*13215);
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        mRelativeLayout.setBackgroundColor((int)(velocityX*velocityY));

        return false;
    }
}

