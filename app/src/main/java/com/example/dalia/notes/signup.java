package com.example.dalia.notes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dalia.notes.DataModel.User;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        final EditText usernamemodel=(EditText)findViewById(R.id.usernamesign);
        final EditText passwordmodel=(EditText)findViewById(R.id.passsign);
        Button signupdone=(Button) findViewById(R.id.signupp2a);

  signupdone.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          User currentUser = new User();
          currentUser.setName(usernamemodel.getText().toString());
          currentUser.setPassword(passwordmodel.getText().toString());
          //currentUser.setPassword(passwordmodel.getText().toString());

          Shared.putUser(signup.this,currentUser);
          Toast.makeText(signup.this, "you can now log in", Toast.LENGTH_SHORT).show();
          Intent i=new Intent(signup.this,MainActivity.class) ;
          startActivity(i);

      }
  }); }}

