package com.krapinem.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "students.db";
    private static final String TABLE_STUDENT = "students ";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_STUDENTNAME = "studentname";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " +TABLE_STUDENT+  "(" +
                COLUMN_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_STUDENTNAME+ " TEXT" +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+TABLE_STUDENT);
        onCreate(db);
    }

    //Adding data to database
    public void addStudent(Students students){
        ContentValues values = new ContentValues();
        values.put(COLUMN_STUDENTNAME,students.get_name());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_STUDENT,null,values);
        db.close();
    }

    //Delete data from database
    public void deleteStudent(String studentname){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_STUDENT+" WHERE "+COLUMN_STUDENTNAME+"=\""+studentname+ "\";");
        db.close();
    }

    //Print out the database as String
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_STUDENT+";";
        //Cursor point to a location in your results
        Cursor mCursor = db.rawQuery(query,null);
        //Move to first row in your  results
        mCursor.moveToFirst();

        while (!mCursor.isAfterLast()){
            if(mCursor.getString(mCursor.getColumnIndex("studentname"))!=null){
                dbString += mCursor.getString(mCursor.getColumnIndex("studentname"));
                dbString +="\n";
                mCursor.moveToNext();
            }
        }
        db.close();
        return dbString;
    }

}
