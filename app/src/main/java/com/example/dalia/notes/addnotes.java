package com.example.dalia.notes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dalia.notes.Adapter.Adapternote;
import com.example.dalia.notes.DataModel.Note;
import com.example.dalia.notes.DataModel.User;

import java.io.ByteArrayOutputStream;

public class addnotes extends AppCompatActivity {
EditText notesname,descrption;
    Button save;
    User user;
    Uri imageuri;
ImageView image;
    private static final int pick_image=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnotes);
        notesname = (EditText) findViewById(R.id.notename);
        descrption = (EditText) findViewById(R.id.descrption);
        save = (Button) findViewById(R.id.save);
        image = (ImageView) findViewById(R.id.myimage);
        user = Shared.getCurrentUser(addnotes.this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note x = new Note(notesname.getText().toString(), descrption.getText().toString(),image.getImageMatrix().toString());
                user.getNotes().add(x);
                Shared.putUser(addnotes.this, user);
                 ///////////////////////////////////////
               /* Intent intent=new Intent(addnotes.this, Adapternote.class);
                Bundle bundle=new Bundle();
                bundle.putInt("image",R.drawable.gallery);
                intent.putExtras(bundle);
                startActivity(intent);*/

                ///////////////////////////////////////
                Toast.makeText(addnotes.this, "SAVED", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(addnotes.this, listview.class));
                finish();

            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


   Opengallery();



            }
        });}

   private  void Opengallery(){
        Intent gallery=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery,pick_image);
    }
   @Override
    protected  void  onActivityResult(int requestcode,int resultcode,Intent data){

        super.onActivityResult(requestcode,resultcode,data);
       if(resultcode==RESULT_OK && requestcode==pick_image){
           imageuri=data.getData();
       image.setImageURI(imageuri);
       }


    }
}
