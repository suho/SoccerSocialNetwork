package com.mad.hovansu.soccersocialnetwork.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import com.mad.hovansu.soccersocialnetwork.support.TimeConvert;

import java.util.Date;


public class RegisterManagerDao extends DataBaseHelper {
    private SQLiteDatabase myDatabase;
    private Context context;

    public RegisterManagerDao(Context context) {
        super(context);
        myDatabase = getMyDataBase();
        this.context = context;
    }

    public boolean registerAccount(String email, String username, String password, String phone_number, int city_id, Date created) {
        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("username", username);
        values.put("password", password);
        values.put("phone_number", phone_number);
        values.put("city_id", city_id);
        values.put("created", TimeConvert.getStringDatetime(created));
        if (isValidUser(username)) {
            Toast.makeText(context, "User Đã Tồn Tại", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            long index = myDatabase.insert("user_profiles", null, values);
            if (index == -1) {
                return false;
            }
            Toast.makeText(context, "Successfully", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    private boolean isValidUser(String userName) {
        String sql = "SELECT * FROM user_profiles where username='" + userName + "'";
        Cursor cursor = myDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            return true;
        }
        return false;
    }
}
