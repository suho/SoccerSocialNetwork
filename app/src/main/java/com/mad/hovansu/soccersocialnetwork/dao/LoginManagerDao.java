package com.mad.hovansu.soccersocialnetwork.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class LoginManagerDao extends DataBaseHelper {
    private SQLiteDatabase myDatabase;
    private  Context myConText;
    public LoginManagerDao(Context context) {
        super(context);
        myDatabase=getMyDataBase();
       this. myConText=context;
    }
    public boolean checkLogin(String username, String password) {
        String sql = "SELECT * FROM user_profiles where username='" + username + "' and password='" + password +"'";
        Cursor cursor = myDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            return true;
        }
        return false;
    }
    public int getYourId(String username) {
        String sql = "SELECT * FROM user_profiles where username='" + username + "'";
        Cursor cursor = myDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            return cursor.getInt(cursor.getColumnIndex("user_id"));
        }
        return -1;
    }
    public int getYourType(String username) {
        String sql = "SELECT * FROM user_profiles where username='" + username + "'";
        Cursor cursor = myDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            return cursor.getInt(cursor.getColumnIndex("type_id"));

        }
        return -1;
    }

}
