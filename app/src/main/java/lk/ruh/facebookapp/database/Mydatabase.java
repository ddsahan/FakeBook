package lk.ruh.facebookapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class Mydatabase extends SQLiteOpenHelper {

    // Database Name and Version
    public static final String DB_NAME = "student.db";
    public static final int DB_VERSION=1;
    private static final String TABLE_NAME="student_table";
    private static final String COL_1="name";
    private static final String COL_2="age";
    private static final String COL_3="marks";

    SQLiteDatabase database;

    public Mydatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG ,"onCreate: " + " Database Create Successfully ");
        db.execSQL("CREATE TABLE "+TABLE_NAME+"(id integer PRIMARY KEY AUTOINCREMENT,name TEXT,age INTEGER,marks INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG ,"onCreate: " + " Database Update Successfully ");
        db.execSQL("DROP TABLE IF EXISTS "+DB_NAME);
        onCreate(db);
    }

    public boolean insertData(String name,String age,String mark){
       SQLiteDatabase db= this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1,name);
        contentValues.put(COL_2,age);
        contentValues.put(COL_3,mark);

        long rs = db.insert(TABLE_NAME,null,contentValues);

        if (rs==-1)
            return false;
        else
            return true;
    }

    public Cursor getAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor rs = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return  rs;
    }

}
