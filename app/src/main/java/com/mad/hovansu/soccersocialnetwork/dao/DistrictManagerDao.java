package com.mad.hovansu.soccersocialnetwork.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.mad.hovansu.soccersocialnetwork.bean.District;

import java.util.ArrayList;

/**
 * Created by HoVanLy on 4/28/2016.
 */
public class DistrictManagerDao extends DataBaseHelper {
    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     *
     * @param context
     */
    private SQLiteDatabase myDatabase;

    public DistrictManagerDao(Context context) {
        super(context);
        this.myDatabase = getMyDataBase();
    }

    public ArrayList<District> getListDistricts() {
        ArrayList<District> arrayList = new ArrayList<>();
        String selectQuery = "SELECT * FROM districts";
        Cursor cursor = myDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                District districts = new District();
                districts.setDistrict_id(cursor.getInt(cursor.getColumnIndex("district_id")));
                districts.setCity_id(cursor.getInt(cursor.getColumnIndex("city_id")));
                districts.setDistrict_name(cursor.getString(cursor.getColumnIndex("district_name")));
                arrayList.add(districts);
            } while (cursor.moveToNext());

        }
        return arrayList;
    }


    public ArrayList<String> getListNameDistricts() {
        ArrayList<String> arrayList = new ArrayList<>();
        String selectQuery = "SELECT * FROM districts";
        Cursor cursor = myDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                arrayList.add(cursor.getString(cursor.getColumnIndex("district_name")));
            } while (cursor.moveToNext());

        }
        return arrayList;
    }
}
