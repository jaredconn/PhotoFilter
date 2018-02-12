package com.example.jwc374.photofilter2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;


/**
 * Created by J on 2/8/2018.
 */

public class ImageFix extends MainActivity {


    public static Bitmap makeBlue(Bitmap image) {
        Matrix matrix = new Matrix();
        matrix.postRotate(270); //fixes the rotate
        Bitmap rotatedBitmap;
        rotatedBitmap = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
        Paint p = new Paint(Color.BLUE);
        ColorFilter filter = new LightingColorFilter(Color.BLUE, 1);
        p.setColorFilter(filter);
        Canvas canvas = new Canvas(rotatedBitmap);
        canvas.drawBitmap(rotatedBitmap, 0, 0, p);
        return rotatedBitmap;

    }

   public static Bitmap makeGreen(Bitmap image) {
       Matrix matrix = new Matrix();
       matrix.postRotate(270); //fixes the rotate
       Bitmap rotatedBitmap;
       rotatedBitmap = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
       Paint p = new Paint(Color.GREEN);
       ColorFilter filter = new LightingColorFilter(Color.GREEN, 1);
       p.setColorFilter(filter);
       Canvas canvas = new Canvas(rotatedBitmap);
       canvas.drawBitmap(rotatedBitmap, 0, 0, p);
       return rotatedBitmap;

}
}
