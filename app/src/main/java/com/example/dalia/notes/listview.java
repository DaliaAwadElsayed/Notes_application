package com.example.dalia.notes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.dalia.notes.Adapter.Adapternote;
import com.example.dalia.notes.DataModel.User;

import static com.example.dalia.notes.R.id.listView;
import static com.example.dalia.notes.Shared.CURRENT_SETTING_KEY;
import static com.example.dalia.notes.Shared.getSharedprefence;

public class listview extends AppCompatActivity {
    User user;
    ListView listview;
    Button addnew, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        user = Shared.getCurrentUser(listview.this);
        // textView.setText("Welcome "+user.getName());

        listview = (ListView) findViewById(R.id.listView);

        addnew = (Button) findViewById(R.id.addnew);

        logout = (Button) findViewById(R.id.logout);

        final Adapternote notesAdapter = new Adapternote(listview.this, user.getNotes());
listview.setAdapter( notesAdapter);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent i=new Intent(listview.this,MainActivity.class);
                startActivity(i);
            }
        });

        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(listview.this, addnotes.class));
                finish();

            }
        });


    }

}