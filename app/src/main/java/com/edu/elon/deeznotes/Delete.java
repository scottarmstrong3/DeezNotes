package com.edu.elon.deeznotes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.provider.ContactsContract;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;

/**
 * Delete Note class
 *
 * @author Betsey McCarthy
 */

public class Delete {

    protected float x, y;
    private float width, height;
    private Bitmap bitmap;

    private int screenWidth, screenHeight;

    private final float SCALE = 0.1f;

    public Delete(Context context) {

        // get the image
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.delete);

        // scale the size
        width = bitmap.getWidth() * SCALE;
        height = bitmap.getHeight() * SCALE;

        // figure out the screen width
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;


        x = screenWidth;
        y = screenHeight;
    }

    public void doDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap , x - width , y - height , null);
    }
    //get the x value of the location of the trash icon
public float getTrashX(){
    return x-width;
}
    //gets the y value of the location of the trash icon
  public float getTrashY(){
      return y-height;
  }
   //remove note from the array
    public void removeNoteFromArray(Note note, Note [] notes){ //@FIXME ArrayList instead?
for(int i = 0; i < notes.length; i++){
    if (notes[i].equals(note)){
        notes[i]= null;
    }
}
    }
    //@FIXME put touch events in view
    view.setOnTouchListener(new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            float x = event.getX();
            float y = event.getY();
            //@FIXME Down touch event will get note
            if(event.getAction()== MotionEvent.ACTION_UP){
                if(x>= getTrashX() && y<= getTrashY()){
                    removeNoteFromArray(//@FIXME put the current note here);
                }
            }
            return true;
        }
    });

}