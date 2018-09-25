package com.example.dalia.notes;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import com.example.dalia.notes.DataModel.User;
import com.google.gson.Gson;

/**
 * Created by dalia on 7/31/2017.
 */

public class Shared {

    public  static  final
    String CURRENT_USER_KEY="Current User";
    public  static  final
    String CURRENT_SETTING_KEY="Current SETTING";

    public static SharedPreferences getSharedprefence(Context x, String name){

        return x.getSharedPreferences(name,Context.MODE_PRIVATE);
    }
//save
    public static User getCurrentUser(Context x){
        Gson gson=new Gson();

        String jsonUser=  getSharedprefence(x,CURRENT_SETTING_KEY).getString(CURRENT_USER_KEY,null);
        if(jsonUser!=null){
            return gson.fromJson(jsonUser,User.class);
        }else{
            return null;
        }
    }

    //retreve
    public static void putUser(Context x,
                               User u
    ){
        Gson gson=new Gson();

        SharedPreferences.Editor editor=getSharedprefence(x,CURRENT_SETTING_KEY).edit();
        editor.putString(CURRENT_USER_KEY,gson.toJson(u));
        editor.apply();

    }





}
