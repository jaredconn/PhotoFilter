package com.example.jwc374.photofilter2;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import pub.devrel.easypermissions.EasyPermissions;


public class EditChosenPhoto extends AppCompatActivity {

    ImageView IMG;
    Canvas canvas;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_chosen_photo);

        getSupportActionBar().hide();
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


       // ImageView IMG;
        IMG = (ImageView) findViewById(R.id.img);
        Intent intent = getIntent();
        String path = intent.getStringExtra("path");


        File imageFile = new File(path);

        //this is required for android 6.0+ to access the gallery
        String[] galleryPermissions = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, galleryPermissions)) {
            //pickImageFromGallery();
        } else {
            EasyPermissions.requestPermissions(this, "Access for storage",
                    101, galleryPermissions);
        }

        final Bitmap myBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath()); //retrieving file

        Bitmap workingBitmap = Bitmap.createBitmap(myBitmap);
        final Bitmap trueCopy = workingBitmap.copy(Bitmap.Config.ARGB_8888, true);
        final Bitmap mutableBitmap = workingBitmap.copy(Bitmap.Config.ARGB_8888, true);

        canvas = new Canvas(mutableBitmap);

        IMG.setImageBitmap(mutableBitmap);

        Button green;
        green = (Button) findViewById(R.id.green);
        Button reset;
        reset = (Button) findViewById(R.id.reset);
        Button save;
        save = (Button) findViewById(R.id.save);
        Button blue;
        blue = (Button) findViewById(R.id.blue);
        Button red;
        red = (Button) findViewById(R.id.red);
        Button cyan;
        cyan = (Button) findViewById(R.id.cyan);
        Button yellow;
        yellow = (Button) findViewById(R.id.yellow);
        Button magenta;
        magenta = (Button) findViewById(R.id.magenta);
        Button gray;
        gray = (Button) findViewById(R.id.gray);



        final Context context = getApplicationContext();
        CharSequence text = "Edit your photo!!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


        reset.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                IMG.setImageBitmap(trueCopy);
            }
        });

        blue.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {

                canvas.drawBitmap(trueCopy, 0, 0, null);
                Paint p = new Paint(Color.BLUE);
                ColorFilter filter = new LightingColorFilter(Color.BLUE, 1);
                p.setColorFilter(filter);
                canvas.drawBitmap(mutableBitmap, 0, 0, p);
                IMG.setImageBitmap(mutableBitmap);

            }
        });
        green.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {

                canvas.drawBitmap(trueCopy, 0, 0, null);
                Paint p = new Paint(Color.GREEN);
                ColorFilter filter = new LightingColorFilter(Color.GREEN, 1);
                p.setColorFilter(filter);
                canvas.drawBitmap(mutableBitmap, 0, 0, p);
                IMG.setImageBitmap(mutableBitmap);

            }
        });
        red.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {

                canvas.drawBitmap(trueCopy, 0, 0, null);
                Paint p = new Paint(Color.RED);
                ColorFilter filter = new LightingColorFilter(Color.RED, 1);
                p.setColorFilter(filter);
                canvas.drawBitmap(mutableBitmap, 0, 0, p);
                IMG.setImageBitmap(mutableBitmap);

            }
        });
        cyan.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {

                canvas.drawBitmap(trueCopy, 0, 0, null);
                Paint p = new Paint(Color.CYAN);
                ColorFilter filter = new LightingColorFilter(Color.CYAN, 1);
                p.setColorFilter(filter);
                canvas.drawBitmap(mutableBitmap, 0, 0, p);
                IMG.setImageBitmap(mutableBitmap);

            }
        });
        yellow.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {

                canvas.drawBitmap(trueCopy, 0, 0, null);
                Paint p = new Paint(Color.YELLOW);
                ColorFilter filter = new LightingColorFilter(Color.YELLOW, 1);
                p.setColorFilter(filter);
                canvas.drawBitmap(mutableBitmap, 0, 0, p);
                IMG.setImageBitmap(mutableBitmap);

            }
        });
        magenta.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {

                canvas.drawBitmap(trueCopy, 0, 0, null);
                Paint p = new Paint(Color.MAGENTA);
                ColorFilter filter = new LightingColorFilter(Color.MAGENTA, 1);
                p.setColorFilter(filter);
                canvas.drawBitmap(mutableBitmap, 0, 0, p);
                IMG.setImageBitmap(mutableBitmap);

            }
        });

        gray.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {

                canvas.drawBitmap(trueCopy, 0, 0, null);
                Paint p = new Paint(Color.GRAY);
                ColorFilter filter = new LightingColorFilter(Color.GRAY, 1);
                p.setColorFilter(filter);
                canvas.drawBitmap(mutableBitmap, 0, 0, p);
                IMG.setImageBitmap(mutableBitmap);

            }
        });

        save.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {

                Intent intent = getIntent();
               //get the path of the image
                String path = intent.getStringExtra("path");
               // File imageFile = new File(path);

                //the current image
                IMG.buildDrawingCache();
                Bitmap myBitmap =  IMG.getDrawingCache();

                //save the image there
                File newFile = new File(path);
                try {
                    FileOutputStream fos = new FileOutputStream(newFile);
                    myBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                    fos.close();
                    scanFile(context, Uri.fromFile(newFile));

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void scanFile(Context context, Uri uri) {
        Intent scanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        scanIntent.setData(uri);
        context.sendBroadcast(scanIntent);

    }
}

