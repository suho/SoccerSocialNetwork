package com.mad.hovansu.soccersocialnetwork.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mad.hovansu.soccersocialnetwork.R;
import com.mad.hovansu.soccersocialnetwork.dao.LoginManagerDao;
import com.mad.hovansu.soccersocialnetwork.fragment.ProfileFragment;

public class LoginActivity extends AppCompatActivity{
    private EditText user_login;
    private EditText pass_login;
    private Button button_login;
    private TextView register_text;
    private LoginManagerDao loginManagerDao;
    private int id_user = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user_login = (EditText) findViewById(R.id.signin_email_text);
        pass_login = (EditText) findViewById(R.id.signin_pass_text);
        button_login = (Button) findViewById(R.id.login_button);
        register_text = (TextView) findViewById(R.id.text_register);
        loginManagerDao = new LoginManagerDao(this);
        registerAccount(register_text);
        loginHandler(button_login);


    }

    private void loginHandler(Button button_login) {
        button_login.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = user_login.getText().toString();
                String passWord = pass_login.getText().toString();
                Boolean checkLogin = loginManagerDao.checkLogin(userName, passWord);
                if(checkLogin) {
                    id_user = loginManagerDao.getYourId(userName);
                    ProfileFragment obj = new ProfileFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("id_user", id_user);
                    obj.setArguments(bundle);
                    Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                    LoginActivity.this.startActivity(mainIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "Login Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void registerAccount(TextView register_text) {
        register_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });
    }
}

