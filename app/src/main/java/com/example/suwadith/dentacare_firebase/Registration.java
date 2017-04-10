package com.example.suwadith.dentacare_firebase;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Registration extends AppCompatActivity implements View.OnClickListener{

    private EditText editEmail;
    private EditText editPassword;
    private Button registerButton;
    private TextView loginRedirect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassword = (EditText) findViewById(R.id.editPassword);

        registerButton = (Button) findViewById(R.id.registerButton);

        loginRedirect = (TextView) findViewById(R.id.loginRedirect);

        registerButton.setOnClickListener(this);
        loginRedirect.setOnClickListener(this);

    }

    private void registerNewUser(){

        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();


            if(TextUtils.isEmpty(email)){

            }

            if(TextUtils.isEmpty(password)){

            }

    }

    private void redirectToLogin(){

    }

    @Override
    public void onClick(View view) {

        if(view == registerButton){
            registerNewUser();
        }

        if(view == loginRedirect){
            redirectToLogin();
        }

    }
}
