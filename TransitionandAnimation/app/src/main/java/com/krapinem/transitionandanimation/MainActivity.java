package com.krapinem.transitionandanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ViewGroup mViewGroupLayout; //This is used for layout purpose
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewGroupLayout = (ViewGroup) findViewById(R.id.activity_main);

        mViewGroupLayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener(){
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        moveButton();
                        return true;
                    }
                }
        );

    }

    private void moveButton() {
        View krapinemButton = findViewById(R.id.button);

        TransitionManager.beginDelayedTransition(mViewGroupLayout); //Transition is done by TransitionManager

        //Change the position of the button
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
        /*positionRules.width=600;
        positionRules.height=400;*/
        krapinemButton.setLayoutParams(positionRules);

        //Change the size of the button
        ViewGroup.LayoutParams sizeRules = krapinemButton.getLayoutParams();
        sizeRules.width=350;
        sizeRules.height=250;
        krapinemButton.setLayoutParams(sizeRules);
    }
}
