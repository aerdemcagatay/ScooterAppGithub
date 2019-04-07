package com.example.android.elec491scooterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignupPage extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextUsername;
    private EditText editTextPassword;

    private Button buttonSignUp;
    private TextView textViewSignin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        editTextUsername = findViewById(R.id.Username);
        editTextPassword = findViewById(R.id.Password);

        buttonSignUp = findViewById(R.id.butSignup);
        textViewSignin = findViewById(R.id.SignIn);

        buttonSignUp.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);

    }





    @Override
    public void onClick(View view) {
        if(view == buttonSignUp){

        }else if (view == textViewSignin){
            Intent intent = new Intent(SignupPage.this, SigninPage.class);
            startActivity(intent);
        }


    }
}
