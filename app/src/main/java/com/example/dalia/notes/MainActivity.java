package com.example.dalia.notes;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dalia.notes.DataModel.User;


public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    User currentUser;

 Button signupp,login;
    EditText usernamee,passwordd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.login);
        signupp = (Button) findViewById(R.id.singup);
        usernamee = (EditText) findViewById(R.id.username);
        passwordd = (EditText) findViewById(R.id.password);

login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        currentUser=Shared.getCurrentUser(MainActivity.this);
        if (currentUser!=null){
            if(currentUser.getName().equals(usernamee.getText().toString()) &&currentUser.getPassword().equals(passwordd.getText().toString()))
            {

                startActivity(new Intent(MainActivity.this,listview.class));
                finish();
            }else{
                Toast.makeText(MainActivity.this, "\"No valid UserName Or Password\"", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(MainActivity.this, " \"plz Sign Up first\"", Toast.LENGTH_SHORT).show();
        }


    }
});


        signupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent ii=new Intent(MainActivity.this,signup.class);
                startActivity(ii);
            }
        });
    }


















}