package com.krapinem.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String fruits[]  = {"Mango","Apple","Guava","Banana","Grapes","Watermelon","Cherry","Lemon","Orange","Honeyberry","Tomato","Peach"};
        ListAdapter mListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,fruits);
        ListView mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(mListAdapter);

        mListView.setOnItemClickListener(
            new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String fruit = String.valueOf(parent.getItemAtPosition(position));
                    Toast.makeText( MainActivity.this , fruit , Toast.LENGTH_SHORT).show();
                }
            }
        );
    }
}
















