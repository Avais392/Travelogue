package com.example.apple.tabssample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    Button login,forgot_password,signup;
    EditText email,password;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=findViewById(R.id.LoginButton);
        forgot_password=findViewById(R.id.forgot_passwordButton);
        signup=findViewById(R.id.redirectSignup);
        email=findViewById(R.id.emailET);
        password=findViewById(R.id.usernameET);

    }

    public void login(View v){
        if(TextUtils.isEmpty(email.getText())){
            Toast.makeText(getApplicationContext(),"Please enter email or username to log in",Toast.LENGTH_LONG).show();
        }
        else if(TextUtils.isEmpty(password.getText())){
            Toast.makeText(getApplicationContext(),"Please enter valid password to log in",Toast.LENGTH_LONG).show();
        }
        else{
            //check valid password and email
            //else
           //take to main screen

            firebaseRef.getInstance().myRef.child("TestUser"+Integer.toString(firebaseRef.getInstance().count) ).child(email.getText().toString()).setValue(password.getText().toString());
           // firebaseRef.getInstance().myRef.push().setValue(message);
            firebaseRef.getInstance().count++;
            Intent i=new Intent(this,PostActivity.class);
            startActivity(i);
        }
    }

    public void forgotPassword(View v){
        Intent i=new Intent(this,forgotPassword.class);
        startActivity(i);
    }

    public void createAccount(View v){
        Intent i=new Intent(this,signup.class);
        startActivity(i);
    }

}
