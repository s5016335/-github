package com.example.jiancheng.sql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiancheng on 2018/4/6.
 */

public class Database extends SQLiteOpenHelper {
    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void CreatTable(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public  void add(String name,String phone){
/*
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        database.insert("UserDB.db",null,values);
*/


        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("INSERT INTO User(name,phone)VALUES('%s','%s');",
                name,
                phone)
               ;
        db.execSQL(query);

    }

    public List<User> getData(){


       final List<User>users = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();


       Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM User ",null);


            while (c.moveToNext()){
                String name = c.getString(0);
                String phone = c.getString(1);
                users.add(new User(name,phone));
            }

        return users;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
