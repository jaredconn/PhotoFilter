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
    public static Bitmap makeRed(Bitmap image) {
        Matrix matrix = new Matrix();
        matrix.postRotate(270); //fixes the rotate
        Bitmap rotatedBitmap;
        rotatedBitmap = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
        Paint p = new Paint(Color.RED);
        ColorFilter filter = new LightingColorFilter(Color.RED, 1);
        p.setColorFilter(filter);
        Canvas canvas = new Canvas(rotatedBitmap);
        canvas.drawBitmap(rotatedBitmap, 0, 0, p);
        return rotatedBitmap;
    }
    public static Bitmap makeGray(Bitmap image) {
        Matrix matrix = new Matrix();
        matrix.postRotate(270); //fixes the rotate
        Bitmap rotatedBitmap;
        rotatedBitmap = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
        Paint p = new Paint(Color.GRAY);
        ColorFilter filter = new LightingColorFilter(Color.GRAY, 1);
        p.setColorFilter(filter);
        Canvas canvas = new Canvas(rotatedBitmap);
        canvas.drawBitmap(rotatedBitmap, 0, 0, p);
        return rotatedBitmap;
    }
    public static Bitmap makeYellow(Bitmap image) {
        Matrix matrix = new Matrix();
        matrix.postRotate(270); //fixes the rotate
        Bitmap rotatedBitmap;
        rotatedBitmap = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
        Paint p = new Paint(Color.YELLOW);
        ColorFilter filter = new LightingColorFilter(Color.YELLOW, 1);
        p.setColorFilter(filter);
        Canvas canvas = new Canvas(rotatedBitmap);
        canvas.drawBitmap(rotatedBitmap, 0, 0, p);
        return rotatedBitmap;
    }
    public static Bitmap makeMagenta(Bitmap image) {
        Matrix matrix = new Matrix();
        matrix.postRotate(270); //fixes the rotate
        Bitmap rotatedBitmap;
        rotatedBitmap = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
        Paint p = new Paint(Color.MAGENTA);
        ColorFilter filter = new LightingColorFilter(Color.MAGENTA, 1);
        p.setColorFilter(filter);
        Canvas canvas = new Canvas(rotatedBitmap);
        canvas.drawBitmap(rotatedBitmap, 0, 0, p);
        return rotatedBitmap;
    }
    public static Bitmap makeWhite(Bitmap image) {
        Matrix matrix = new Matrix();
        matrix.postRotate(270); //fixes the rotate
        Bitmap rotatedBitmap;
        rotatedBitmap = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
        Paint p = new Paint(Color.WHITE);
        ColorFilter filter = new LightingColorFilter(Color.WHITE, 1);
        p.setColorFilter(filter);
        Canvas canvas = new Canvas(rotatedBitmap);
        canvas.drawBitmap(rotatedBitmap, 0, 0, p);
        return rotatedBitmap;
    }
    public static Bitmap makeCyan(Bitmap image) {
        Matrix matrix = new Matrix();
        matrix.postRotate(270); //fixes the rotate
        Bitmap rotatedBitmap;
        rotatedBitmap = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
        Paint p = new Paint(Color.CYAN);
        ColorFilter filter = new LightingColorFilter(Color.CYAN, 1);
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
