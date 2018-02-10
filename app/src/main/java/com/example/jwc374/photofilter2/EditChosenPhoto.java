package com.example.jwc374.photofilter2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class EditChosenPhoto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_chosen_photo);

        ImageView IMG;
        IMG = (ImageView) findViewById(R.id.img);

        Context context = getApplicationContext();
        CharSequence text = "Edit your photo!!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        /*
        Intent intent = getIntent();

        String i = intent.getStringExtra("index"); //the index counter to identify the current photo

        File imageFile = new File("storage/emulated/0/Pictures/image" + i + ".jpg");
        if (imageFile.exists()) {
            Bitmap myBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath()); //retrieving file
            IMG.setImageBitmap(ImageFix.fixOrientationMirror(myBitmap));
        }
    */
        Intent intent = getIntent();
        String path = intent.getStringExtra("path");
        File imageFile = new File(path);
        if (imageFile.exists()) {
            Bitmap myBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath()); //retrieving file
            IMG.setImageBitmap(ImageFix.fixOrientation(myBitmap));
        }
        /*
        bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
        IMG.setImageBitmap(ImageFix.fixOrientation(bitmap));
    */
    }


}
