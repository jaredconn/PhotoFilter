package com.example.jwc374.photofilter2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.io.File;
import java.lang.reflect.Method;


public class MainActivity extends AppCompatActivity {


    Button button;
    Button button2;

    int i = 0;
    ImageView IMG;


    private static final SparseIntArray ORIENTATIONS = new SparseIntArray();

    static {
        ORIENTATIONS.append(Surface.ROTATION_0, 90);
        ORIENTATIONS.append(Surface.ROTATION_90, 0);
        ORIENTATIONS.append(Surface.ROTATION_180, 270);
        ORIENTATIONS.append(Surface.ROTATION_270, 180);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        IMG = findViewById(R.id.img);

        getSupportActionBar().hide();
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());


        if(Build.VERSION.SDK_INT>=24){
            try{
                Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
                m.invoke(null);
            }catch(Exception e){
                e.printStackTrace();
            }
        }


//choose existing from gallery
        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }
        });


//take a new photo
        button.setOnClickListener(new Button.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View arg0) {

                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File imageDirectory = new File( Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + "/Camera/" ); //gallery directory
                String fileName = getFileName();
                File imageFile = new File(imageDirectory, fileName);
                Uri imageUri = Uri.fromFile(imageFile);
                galleryAddPic("storage/emulated/0/DCIM/Camera/image" + 0 + ".jpg");
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(takePictureIntent, 1313);
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
        return "image" + 0 + ".jpg";
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
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
                if (requestCode == 1313) //then we're taking a new photo
                {
                    Intent intent = new Intent(this, EditChosenPhoto.class); //defining which activity to start next
                    String path = "storage/emulated/0/DCIM/Camera/image" + 0 + ".jpg";
                    intent.putExtra("path", path); //passing the file name so we know which file to open in the next activity
                    startActivity(intent); // starting next activity
            }
        }
    }
}