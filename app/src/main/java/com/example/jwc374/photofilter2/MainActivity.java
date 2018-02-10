package com.example.jwc374.photofilter2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;

    Button button;
    Button button2;

    int i = 0;
    int REQUEST_CODE = 1;
    ImageView IMG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        IMG = (ImageView) findViewById(R.id.img);


//choose existing from gallery
        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }
        });


//take a new photo
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //saving the image to a file
                File imageDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String fileName = getFileName();
                File imageFile = new File(imageDirectory, fileName);
                Uri imageUri = Uri.fromFile(imageFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);

                if (cameraIntent.resolveActivity(getPackageManager()) != null) //check if camera application is available on device
                {
                    startActivityForResult(cameraIntent, REQUEST_CODE);
                }
            }
        });
    }

    private String getFileName() {
        return "image" + i + ".jpg";
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE || requestCode == 0) {
            if (resultCode == RESULT_OK) //operation was successful
            {
                if (requestCode == 0) //then we're choosing from gallery
                {
                    Uri targetUri = data.getData();
                    String path = PathFinder.getPath(this, targetUri);
                    Bitmap bitmap;
                    try {
                        Intent intent = new Intent(this, EditChosenPhoto.class); //defining which activity to start next
                        intent.putExtra("path", path); //passing the file name so we know which file to open in the next activity
                        startActivity(intent); // starting next activity

                        bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                        IMG.setImageBitmap(ImageFix.fixOrientation(bitmap));

                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                if (requestCode == 1) //then we're taking a new photo
                {
                    File imageFile = new File("storage/emulated/0/Pictures/image" + i + ".jpg");
                    if(imageFile.exists()){
                        Intent intent = new Intent(this, EditChosenPhoto.class); //defining which activity to start next
                        intent.putExtra("index", Integer.toString(i)); //passing the index so we know which file to open in the next activity
                        startActivity(intent); // starting next activity
                        i++;
                    }
                }
            }
        }
    }
}