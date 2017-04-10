package com.example.suwadith.dentacare_firebase;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Registration extends AppCompatActivity implements View.OnClickListener{

    private EditText editEmail;
    private EditText editPassword;
    private EditText editConfirmPassword;
    private Button registerButton;
    private TextView loginRedirect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassword = (EditText) findViewById(R.id.editPassword);
        editConfirmPassword = (EditText) findViewById(R.id.editConfirmPassword);

        registerButton = (Button) findViewById(R.id.registerButton);

        loginRedirect = (TextView) findViewById(R.id.loginRedirect);

        registerButton.setOnClickListener(this);
        loginRedirect.setOnClickListener(this);

    }

    private void registerNewUser(){

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
