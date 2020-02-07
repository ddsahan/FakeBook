package lk.ruh.facebookapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "student_db";
    private static final String TABLE_NAME = "student";
    //private static final String KEY_ID = "id";
    private static final String STU_NAME = "name";
    private static final String STU_AGE = "age";
    private static final String STU_MARK = "mark";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENT_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + STU_NAME + " TEXT," + STU_AGE + " INTEGER,"
                + STU_MARK + " INTEGER" + ")";
        db.execSQL(CREATE_STUDENT_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }


    void addContact(Student stu) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(STU_NAME, stu.getName());
        values.put(STU_AGE, stu.getAge());
        values.put(STU_MARK,stu.getMark());

        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    // code to get the single contact
    Student getStudent(String Name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] { STU_NAME,
                        STU_AGE, STU_MARK }, STU_NAME + "=?",
                new String[] { STU_NAME }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Student st = new Student(cursor.getString(0),
                Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)));
        return st;
    }

}
