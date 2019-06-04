package com.example.richakapuskari.mydictionary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;


public class WordData extends SQLiteOpenHelper {

    public WordData(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table wordtable(worddata text,meaningdata text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void update1(String word, String meaning) {
        String m = "";


        SQLiteDatabase db = getWritableDatabase();

        Cursor c = db.rawQuery("select meaningdata from wordtable where worddata='" + word + "' ", null);

        while(c.moveToNext()){
            m = c.getString(0);
        }

        String me = m + "," + meaning;
        System.out.println(me + "---------------------");

        db.execSQL("update wordtable set meaningdata='" + me + "' where worddata='" + word + "' ");
    }


    public int insertData(String word, String message) {

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("insert into wordtable values('" + word + "','" + message + "')");
        return 1;
    }




    public ArrayList showData() {
        ArrayList al = new ArrayList();
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("select * from wordtable order by worddata asc", null);

        while (c.moveToNext()) {
            al.add(c.getString(0) + " :" + c.getString(1));
        }

        return al;
    }

    public String searchMethod(String word) {
        String m = "";
        ArrayList al = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select meaningdata from wordtable where worddata='" + word + "'", null);
        while (c.moveToNext()) m = c.getString(0);

        return m;



        /*SQLiteDatabase db =getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT meaningdata FROM wordtable where worddata='"+word+"' ", null);

        if(cursor.moveToFirst()) {
            do {
                values.add(cursor.getString(cursor.getColumnIndex("value")));
            }while(cursor.moveToNext());
        }

        }*/
    }
}
