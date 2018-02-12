package com.example.jwc374.photofilter2;


import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import java.io.File;


public class MainActivity extends AppCompatActivity {


    Button button;
    Button button2;

    int i = 0;
    int REQUEST_CODE = 1;
    ImageView IMG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        IMG = findViewById(R.id.img);


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
                File imageDirectory = new File( Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + "/Camera/" ); //gallery directory
                String fileName = getFileName();
                File imageFile = new File(imageDirectory, fileName);
                Uri imageUri = Uri.fromFile(imageFile);
                galleryAddPic("storage/emulated/0/DCIM/Camera/image" + i + ".jpg");
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);

                if (cameraIntent.resolveActivity(getPackageManager()) != null) //check if camera application is available on device
                {
                    startActivityForResult(cameraIntent, REQUEST_CODE);
                }
            }
        });
    }

    /**
     * Saves the taken photo to the gallery
     * @param mCurrentPhotoPath
     */
    protected void galleryAddPic(String mCurrentPhotoPath) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(mCurrentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }



    private String getFileName() {
        i++;
        return "image" + i + ".jpg";
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE || requestCode == 0) {
            if (resultCode == RESULT_OK) //operation was successful
            {
                if (requestCode == 0) //then we're choosing from gallery
                {
                    Uri targetUri = data.getData();
                    String path = PathFinder.getPath(this, targetUri); //finds the path of the chosen file
                    Intent intent = new Intent(this, EditChosenPhoto.class); //defining which activity to start next
                    intent.putExtra("path", path); //passing the file name so we know which file to open in the next activity
                    startActivity(intent); // starting next activity
                }
                if (requestCode == 1) //then we're taking a new photo
                {
                    File imageFile = new File("storage/emulated/0/DCIM/Camera/image" + i + ".jpg");

                    if(imageFile.exists()){
                        Intent intent = new Intent(this, EditChosenPhoto.class);
                        String path = "storage/emulated/0/DCIM/Camera/image" + i + ".jpg";
                        intent.putExtra("path",path);
                        startActivity(intent); // starting next activity
                    }
                }
            }
        }
    }
}