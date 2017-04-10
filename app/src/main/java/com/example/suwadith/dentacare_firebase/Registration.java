package com.example.suwadith.dentacare_firebase;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity implements View.OnClickListener{

    private EditText editEmail;
    private EditText editPassword;
    private Button registerButton;
    private TextView loginRedirect;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassword = (EditText) findViewById(R.id.editPassword);

        registerButton = (Button) findViewById(R.id.registerButton);

        loginRedirect = (TextView) findViewById(R.id.loginRedirect);

        registerButton.setOnClickListener(this);
        loginRedirect.setOnClickListener(this);

    }

    private void registerNewUser() {

        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();


        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter a preferred password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("In Progress...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Registration.this, "User Registered", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Registration.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });

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
