package com.mad.hovansu.soccersocialnetwork.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mad.hovansu.soccersocialnetwork.R;

public class LoginActivity extends AppCompatActivity{
    private EditText email_login;
    private EditText pass_login;
    private Button button_login;
    private TextView register_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email_login = (EditText) findViewById(R.id.signin_email_text);
        pass_login = (EditText) findViewById(R.id.signin_pass_text);
        button_login = (Button) findViewById(R.id.login_button);
        register_text = (TextView) findViewById(R.id.text_register);

        button_login.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email_login.getText().toString().equals("myloho") && pass_login.getText().toString().equals("123456")){
                    Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                    LoginActivity.this.startActivity(mainIntent);
                }
            }
        });

        register_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });
    }
}

