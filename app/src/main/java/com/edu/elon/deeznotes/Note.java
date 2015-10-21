package com.edu.elon.deeznotes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by scottarmstrong on 10/20/15.
 */
public class Note {

    private Bitmap bitmap;
    protected float width, height;
    protected float x, y;

    private int screenWidth, screenHeight;

    public Note (Context context) {
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.note);

        width = bitmap.getWidth();
        height = bitmap.getHeight();

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        x = screenWidth / 2;
        y = screenHeight / 2;
    }
}
