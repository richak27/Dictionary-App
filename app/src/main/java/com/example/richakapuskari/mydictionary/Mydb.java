package com.example.richakapuskari.mydictionary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import java.util.ArrayList;

public class Mydb extends SQLiteOpenHelper {
    public Mydb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table user(name text,phone text,username text,passward text,conpassward text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertdata(String name,String phone,String username, String passward,String conpassward){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("insert into user values('" + name + "','" + phone + "','" + username+"', '" + passward+"','" +conpassward+"')");

    }
    public int updatepass(String username,String conpass){
        int k=0;
        String passt="";
        String passc="";
        SQLiteDatabase db=getWritableDatabase();
        Cursor c=db.rawQuery("update user set passward=conpassward='"+  conpass +"' where username = '"+ username +"' ",null);
        while (c.moveToNext()) {
            passt = c.getString(3);
            passc =c.getString(4);
        }
        if(passt.equals(passc) && !passc.isEmpty()){
            k=1;
        }
        return k;

    }
    public int checklogin(String un,String passt){

        int n=0;
        String pass="";
        SQLiteDatabase db=getWritableDatabase();
        Cursor c=db.rawQuery("Select * from user where username = '"+ un +"' ",null);
        while (c.moveToNext()) {
            pass = c.getString(3);
        }
        if(pass.equals(passt))
            n=1;

        return  n;

    }
    public int existuser(String un){

        int flag = 0;
        String pass="";
        SQLiteDatabase db=getWritableDatabase();
        Cursor c=db.rawQuery("Select * from user where username = '"+ un +"' ",null);
        while (c.moveToNext()) {
            pass = c.getString(0);
        }
        if(!pass.isEmpty())
            flag=1;
        else
            flag=0;
        return flag;

    }


}

