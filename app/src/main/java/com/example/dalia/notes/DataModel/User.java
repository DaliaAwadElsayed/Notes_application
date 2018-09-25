package com.example.dalia.notes.DataModel;

import android.provider.ContactsContract;

import java.util.ArrayList;

public class User {
    public User() {
        notes= new ArrayList<>();
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    ArrayList<Note> notes;
    String name;
    String password;
}