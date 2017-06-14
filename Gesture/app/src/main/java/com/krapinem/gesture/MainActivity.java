package com.krapinem.gesture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.support.v4.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnDoubleTapListener,GestureDetector.OnGestureListener {

    private TextView mTextView;
    private TextView mtv;
    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);
        mtv = (TextView) findViewById(R.id.textView2);
        this.gestureDetector = new GestureDetectorCompat(this,this);
        gestureDetector.setOnDoubleTapListener(this);   //Action Listner
    }

    @Override   //This Is Added to get the TouchEvent to Integrate with the Gesture to find out what the user is doing on Screen
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);   //Each time is Detect the user gesture activity and find what was the gesture
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        mTextView.setText("onSingleTapConfirmed");
        mtv.setText(mtv.getText()+" onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {

        mtv.setText("onDoubleTap");
        mtv.setText(mtv.getText()+" onDoubleTap");
        return true;
    }



    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        mTextView.setText("onDoubleTapEvent");
        mtv.setText(mtv.getText()+" onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        mTextView.setText("onDown");
        mtv.setText(mtv.getText()+" onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        mTextView.setText("onShowPress");
        mtv.setText(mtv.getText()+" onShowPress");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        mTextView.setText("onSingleTapUp");
        mtv.setText(mtv.getText()+" onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        mTextView.setText("onScroll");
        mtv.setText(mtv.getText()+" onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        mTextView.setText("onLongPress");
        mtv.setText(mtv.getText()+" onLongPress");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        mTextView.setText("onFling");
        mtv.setText(mtv.getText()+" onFling");
        return true;
    }


}
