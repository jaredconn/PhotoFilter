package com.example.jwc374.photofilter2;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * Created by J on 2/8/2018.
 */

public class ImageFix extends MainActivity {


    public static Bitmap fixOrientation(Bitmap image) {
        Matrix matrix = new Matrix();
        matrix.postRotate(90); //fixes the rotate
        Bitmap rotatedBitmap;
        rotatedBitmap = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
        return rotatedBitmap;
    }

    public static Bitmap fixOrientationMirror(Bitmap image) {
        Matrix matrix = new Matrix();
        matrix.setScale(-1,1); //fixes the mirrored effect
        matrix.postTranslate(image.getWidth(), 0);
        matrix.postRotate(90); //fixes the rotate
        Bitmap rotatedBitmap;
        rotatedBitmap = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
        return rotatedBitmap;
    }
}
