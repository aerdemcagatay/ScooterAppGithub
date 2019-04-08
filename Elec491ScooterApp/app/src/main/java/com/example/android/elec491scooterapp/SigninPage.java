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

    private Button shortcut;

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

        shortcut = findViewById(R.id.shortcut);

        buttonSignin.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);
        shortcut.setOnClickListener(this);
    }



    boolean checkValidEntry(String username, String password)
    {
        System.out.println("Main Screen: Validating Username/Password Entries");
        /** checks: null, username, password */
        if (username == null || password == null)
        {
            loginFailedAlert(400, "Username/password is blank");
            return false;
        }
        if (username.length() < minUsernameLength || username.length() > maxUsernameLength)
        {
            loginFailedAlert(400, "Username must be between " + minUsernameLength + " and " + maxUsernameLength + " characters.");
            return false;
        }
        if (password.length() < minUsernameLength || password.length() > maxUsernameLength)
        {
            loginFailedAlert(400, "Password must be between " + minUsernameLength + " and " + maxUsernameLength + " characters.");
            return false;
        }
        return true;
    }


    void login(RequestParams params)
    {

        System.out.println("Main Screen: Sending Login Request to Server");
        client.post(url + "Customers", params, new AsyncHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] response) {
                try
                {
                    System.out.println("Main Screen: Successful Login");
                    /** set global user and move on to the menu screen */
                    JSONObject res = new JSONObject(new String(response));
                    System.out.println(res);
                    user = new Customer(res);
                    Intent intent = new Intent(SigninPage.this, MapPage.class);
                    startActivity(intent);
                }
                catch (Throwable t)
                {
                    System.out.println(t);
                }
            }
            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] errorResponse, Throwable e) {
                loginFailedAlert(statusCode, "");
            }
        });
    }
    void loginFailedAlert(int statusCode, String errMsg)
    {


        String errTitle = "Login Failed: Error " + statusCode;
        if (statusCode == 404 || statusCode == 0)
        {
            errMsg = "Cannot connect to server. Please try again.";
        }
        else if (statusCode == 401)
        {
            errMsg = "Incorrect username/password combination.";
        }

        /** Show a pop up dialog telling the username/password is wrong */
        AlertDialog.Builder builder = new AlertDialog.Builder(SigninPage.this);
        builder.setMessage(errMsg)
                .setTitle(errTitle);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    @Override
    public void onClick(View view) {

        if (view == buttonSignin){



            if (checkValidEntry(editTextUsername.getText().toString(), editTextPassword.getText().toString()))
            {
                RequestParams params = new RequestParams();
                params.put("username", editTextUsername.getText());
                params.put("password", editTextPassword.getText());
                /** Send the login request to the server */
                login(params);
            }

        }else if(view == textViewSignUp ){
            Intent intent = new Intent(SigninPage.this, SignupPage.class);
            startActivity(intent);
        }else if (view == shortcut){
            Intent intent = new Intent(SigninPage.this, MapPage.class);
            startActivity(intent);
        }

    }
}
