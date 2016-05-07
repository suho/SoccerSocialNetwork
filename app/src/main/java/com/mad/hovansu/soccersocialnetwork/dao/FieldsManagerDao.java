package com.mad.hovansu.soccersocialnetwork.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import com.mad.hovansu.soccersocialnetwork.bean.Field;
import com.mad.hovansu.soccersocialnetwork.support.TimeConvert;


import java.util.Date;

public class FieldsManagerDao extends DataBaseHelper {
    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     *
     * @param context
     */
    private SQLiteDatabase myDatabase;

    public FieldsManagerDao(Context context) {
        super(context);
        this.myDatabase = getMyDataBase();
    }

    public boolean insertField(Field field) {
        ContentValues values = new ContentValues();
        values.put("field_name", field.getField_name());
        values.put("address", field.getAddress());
        values.put("district_id", field.getDistrict_id());
        values.put("phone_number", field.getPhone_number());
        values.put("user_id", field.getUser_id());
        values.put("created", TimeConvert.getStringDatetime(new Date()));
        long index = myDatabase.insert("fields", null, values);
        if (index == -1) return false;
        return true;
    }
}
