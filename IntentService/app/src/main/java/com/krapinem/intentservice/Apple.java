package com.krapinem.intentservice;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Apple extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple);

        // for KrapinemIntentService
        /*Intent intent = new Intent(this,KrapinemIntentService.class);
        startService(intent);*/

        //for MySevice
        Intent intent = new Intent(this,MyService.class);
        startService(intent);
    }

    public void onClick(View view){
        Intent mIntent = new Intent(this,Bacon.class);

        final EditText appleEditText = (EditText)  findViewById(R.id.appleEditText);
        String appleMessage = appleEditText.getText().toString();
        mIntent.putExtra("appleMessage",appleMessage);

        startActivity(mIntent);
    }
}
