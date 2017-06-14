package com.krapinem.handler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View view){
                        TextView mTextView = (TextView) findViewById(R.id.textView);
                        if(flag==0) {
                            mTextView.setText("Here You Goes!!!");
                            flag = 1;
                        }
                        else{
                            mTextView.setText("Again Clicked!!!");
                            flag = 0;
                        }
                    }
                }
        );

        mButton.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View view){
                        TextView mTextView = (TextView) findViewById(R.id.textView);
                        mTextView.setText("Its A Long Press On Button.Remove Your Fingure");
                        return false; //false will remove or roll back the setText to keep it return true
                    }
                }
        );
    }
}
