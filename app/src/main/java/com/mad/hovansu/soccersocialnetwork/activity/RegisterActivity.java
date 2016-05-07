package com.mad.hovansu.soccersocialnetwork.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mad.hovansu.soccersocialnetwork.R;
import com.mad.hovansu.soccersocialnetwork.dao.RegisterManagerDao;

import java.util.Date;

public class RegisterActivity extends AppCompatActivity {
    TextView txtUsername;
    TextView txtPassword;
    TextView txtEmail;
    TextView txtPhoneNumber;
    Button btnRegister;
    RegisterManagerDao registerManagerDao;

    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtUsername = (TextView) findViewById(R.id.username_register);
        txtPassword = (TextView) findViewById(R.id.password_register);
        txtEmail  = (TextView) findViewById(R.id.email_register);
        txtPhoneNumber = (TextView) findViewById(R.id.phone_register);
        btnRegister = (Button) findViewById(R.id.btn_register);
        registerManagerDao = new RegisterManagerDao(this);
        registerHandle(btnRegister);
    }

    private void registerHandle(Button btnRegister) {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = txtUsername.getText().toString();
                String passWord = txtPassword.getText().toString();
                String phone_number=txtPhoneNumber.getText().toString();
                String email = txtEmail.getText().toString();
                if ("".equals(userName) || "".equals(passWord) || "".equals(email) || "".equals(phone_number)) {
                    Toast.makeText(getApplicationContext(), "Missing Input", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isRegister = registerManagerDao.registerAccount(email, userName, passWord, phone_number, 1, new Date());
                    if (isRegister) {
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        finish();
                    }
                }
            }

        });
    }
}

