package com.mad.hovansu.soccersocialnetwork.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mad.hovansu.soccersocialnetwork.R;
import com.mad.hovansu.soccersocialnetwork.bean.District;
import com.mad.hovansu.soccersocialnetwork.bean.Field;
import com.mad.hovansu.soccersocialnetwork.dao.DistrictManagerDao;
import com.mad.hovansu.soccersocialnetwork.dao.FieldsManagerDao;

import java.util.ArrayList;

public class CreateFieldActivity extends AppCompatActivity {
    private EditText field_name;
    private EditText address;
    private EditText phone_number;
    private Spinner spinner_district;
    private Button btn_create;
    private ArrayList<String> listNameDistricts;
    private ArrayList<District> listDistricts;
    private DistrictManagerDao districtManagerDao;
    private FieldsManagerDao fieldsManagerDao;
    private int id_district;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_field);
        field_name = (EditText) findViewById(R.id.name_field_create);
        address = (EditText) findViewById(R.id.address_field_create);
        phone_number = (EditText) findViewById(R.id.phone_field_create);
        spinner_district = (Spinner) findViewById(R.id.spinner_district);
        btn_create = (Button) findViewById(R.id.btn_create_field);

        districtManagerDao = new DistrictManagerDao(this);
        fieldsManagerDao = new FieldsManagerDao(this);
        listDistricts = districtManagerDao.getListDistricts();
        listNameDistricts = districtManagerDao.getListNameDistricts();
        setViewSpinnerDistricts(spinner_district, listNameDistricts);
        
        handlerCreateFieldButton(btn_create);

    }

    private void handlerCreateFieldButton(Button btn_create) {
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameField=field_name.getText().toString();
                String addressField=address.getText().toString();
                String phoneNumber=phone_number.getText().toString();
                if ("".equals(nameField) || "".equals(addressField) || "".equals(phoneNumber)){
                    Toast.makeText(getApplicationContext(), "Fail Input", Toast.LENGTH_SHORT).show();
                }else {
                    Field fields = new Field();
                    fields.setField_name(nameField);
                    fields.setAddress(addressField);
                    fields.setDistrict_id(id_district);
                    fields.setPhone_number(phoneNumber);
                    boolean isUpdate=fieldsManagerDao.insertField(fields);
                    if (isUpdate) {
                        Toast.makeText(getApplicationContext(),"Successfully", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(),"Fail", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


    private void setViewSpinnerDistricts(Spinner spinner, ArrayList<String> listNameDistricts) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listNameDistricts);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                id_district = listDistricts.get(position).getDistrict_id();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
