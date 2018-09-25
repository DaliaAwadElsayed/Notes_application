package com.example.dalia.notes.Adapter;

import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dalia.notes.DataModel.Note;
import com.example.dalia.notes.R;
import com.example.dalia.notes.listview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dina on 7/31/2017.
 */

public class Adapternote extends ArrayAdapter<Note> {


    private Intent intent;

    public Adapternote(@NonNull Context context, @NonNull List<Note> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Note note = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);

        }
        TextView textViewName = (TextView) convertView.findViewById(R.id.textViewname);
        TextView textViewDisc = (TextView) convertView.findViewById(R.id.textView2des);
        ImageView imagerow = (ImageView) convertView.findViewById(R.id.imageViewrow);
        textViewName.setText(note.getName());
        textViewDisc.setText(note.getDescription());
        //  imagerow.setImageIcon(note.getImageroww());
        /////////////////////////////////////
        /*Bundle bundle=this.getIntent().getExtras();
        int pic=bundle.getInt("image");
        imagerow.setImageResource(pic);*/
        ////////////////////////////////////////
        return convertView;
    }


}

