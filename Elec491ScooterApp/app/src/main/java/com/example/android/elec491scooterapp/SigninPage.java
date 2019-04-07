package com.example.android.elec491scooterapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.*;
import org.json.JSONObject;

import org.json.JSONObject;

import cz.msebera.android.httpclient.entity.mime.Header;

public class SigninPage extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextUsername;
    private EditText editTextPassword;

    private Button buttonSignin;
    private TextView textViewSignUp;

    public static AsyncHttpClient client = new AsyncHttpClient();
    public static Customer user;

    public static String url = "mongodb+srv://admin:admin@scooterappdb-xm4vy.mongodb.net/test?retryWrites=true";
    private int minUsernameLength = 3, maxUsernameLength = 14;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_page);

        editTextUsername = findViewById(R.id.Username);
        editTextPassword = findViewById(R.id.Password);

        buttonSignin = findViewById(R.id.butSignin);
        textViewSignUp = findViewById(R.id.SignUp);

        buttonSignin.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);
    }







    @Override
    public void onClick(View view) {

        if (view == buttonSignin){
            Intent intent = new Intent(SigninPage.this, MapPage.class);
            startActivity(intent);


        }else if(view == textViewSignUp ){
            Intent intent = new Intent(SigninPage.this, SignupPage.class);
            startActivity(intent);
        }

    }
}
