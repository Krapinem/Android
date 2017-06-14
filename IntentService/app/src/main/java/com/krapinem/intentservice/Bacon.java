package com.krapinem.intentservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class Bacon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacon);

        Bundle appleData = getIntent().getExtras();
        if(appleData==null)
        {
            return;
        }
        String appleMessage = appleData.getString("appleMessage");
        TextView mTextView = (TextView) findViewById(R.id.baconText);
        mTextView.setText(appleMessage);
    }

    public void onClick(View view) {
        Intent mBacon = new Intent(this,Apple.class);
        startActivity(mBacon);
    }
}
