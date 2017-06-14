package com.krapinem.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    EditText mEditText;
    MyDBHandler myDBHandler;

    public void onAddButtonClicked(View view){
        Students students = new Students(mEditText.getText().toString());
        myDBHandler.addStudent(students);
        printDB();
    }

    public void onDeleteButtonClicked(View view){
        String studentname = mEditText.getText().toString();
        myDBHandler.deleteStudent(studentname);
        printDB();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.inputText);
        mTextView = (TextView) findViewById(R.id.viewContent);
        myDBHandler = new MyDBHandler(this,null,null,1);
        printDB();
    }

    private void printDB() {
        mTextView.setText("");
        mTextView.setText(myDBHandler.databaseToString());
        mEditText.setText("");
    }
}
