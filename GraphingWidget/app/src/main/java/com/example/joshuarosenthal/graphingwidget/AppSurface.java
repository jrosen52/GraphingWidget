package com.example.joshuarosenthal.graphingwidget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.widget.Toast;
import android.os.Bundle;
import java.util.Random;
import java.lang.*;
import android.app.Activity;

public class AppSurface extends SurfaceView implements SurfaceHolder.Callback
{
    private SurfaceHolder surfaceHolder = null;
    private Paint paint = null;
    private float circleX = 0;
    private float circleY = 0;
    Random r = new Random();
    public int xCoor = r.nextInt((1000 - 30) + 1) + 30;
    public int yCoor = r.nextInt((1500 - 30) + 1) + 30;

    public AppSurface(Context context) {
        super(context);

        surfaceHolder = getHolder();

        paint = new Paint();
        paint.setColor(Color.RED);

        // this.getHolder().setFormat(PixelFormat.TRANSLUCENT);
        // paint.setStyle(Style.FILL);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        drawBall();
    }
    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        paint = null;

    }

    /* This method will be invoked to draw a circle in canvas. */
    public void drawBall()
    {
        //Toast.makeText(getApplicationContext(), "X: " +xCoor + "Y: " + yCoor, Toast.LENGTH_SHORT).show();
        surfaceHolder = getHolder();

        // Get and lock canvas object from surfaceHolder.
        Canvas canvas = surfaceHolder.lockCanvas();

        Paint surfaceBackground = new Paint();
        // Set the surfaceview background color.
        surfaceBackground.setColor(Color.WHITE);
        // Draw the surfaceview background color.
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);

        // Draw the circle.
        //Random r1 = new Random();
        //int color = r1.nextInt((255 - 0) + 1) + 0;
        int rValue, bValue;
        if(circleX < xCoor+5 && circleX > xCoor-5 && circleY < yCoor+5 && circleY > yCoor-5)
        {
            paint.setARGB(255,0,255,0);
        }
        else if(circleX < xCoor+255 && circleX > xCoor-255 && circleY < yCoor+255 && circleY > yCoor-255)
        {
            int compX = (int)xCoor-(int)circleX;
            if(compX < 0)
            {
                compX = compX*-1;
            }
            int compY = (int)yCoor-(int)circleY;
            if(compY < 0)
            {
                compY = compY*-1;
            }
            int compXY = Math.max(compX, compY);
            rValue = 255-compXY;
            bValue = 255-rValue;

            paint.setARGB(255,rValue,0,bValue);
        }
        else
        {
            paint.setARGB(255,0,0,255);
        }
        canvas.drawCircle(circleX, circleY, 80, paint);

        // Unlock the canvas object and post the new draw.
        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    public void drawTri()
    {
        surfaceHolder = getHolder();

        // Get and lock canvas object from surfaceHolder.
        Canvas canvas = surfaceHolder.lockCanvas();

        Paint surfaceBackground = new Paint();
        // Set the surfaceview background color.
        surfaceBackground.setColor(Color.WHITE);
        // Draw the surfaceview background color.
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);
        int rValue, bValue;
        if(circleX < xCoor+5 && circleX > xCoor-5 && circleY < yCoor+5 && circleY > yCoor-5)
        {
            paint.setARGB(255,0,255,0);
        }
        else if(circleX < xCoor+255 && circleX > xCoor-255 && circleY < yCoor+255 && circleY > yCoor-255)
        {
            int compX = (int)xCoor-(int)circleX;
            if(compX < 0)
            {
                compX = compX*-1;
            }
            int compY = (int)yCoor-(int)circleY;
            if(compY < 0)
            {
                compY = compY*-1;
            }
            int compXY = Math.max(compX, compY);
            rValue = 255-compXY;
            bValue = 255-rValue;

            paint.setARGB(255,rValue,0,bValue);
        }
        else
        {
            paint.setARGB(255,0,0,255);
        }

        //paint.setColor(android.graphics.Color.BLACK);
        canvas.drawPaint(paint);

        paint.setStrokeWidth(4);
        //paint.setColor(android.graphics.Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);

        Point a = new Point((int)circleX, (int)circleY);
        Point b = new Point((int)circleX, (int)circleY + 100);
        Point c = new Point((int)circleX+200, (int)circleY+50);
        //System.out.print(circleX);
        //System.out.print(circleY);
        //Toast.makeText(AppSurface.this, "Two Select Position: ", Toast.LENGTH_SHORT).show();

        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(a.x, a.y);
        path.close();

        canvas.drawPath(path, paint);
        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    /* This method will be invoked to draw a circle in canvas. */
    public void drawRect()
    {
        Canvas canvas = surfaceHolder.lockCanvas();

        Paint surfaceBackground = new Paint();
        // Set the surfaceview background color.
        surfaceBackground.setColor(Color.WHITE);
        // Draw the surfaceview background color.

        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);

        int rValue, bValue;
        if(circleX < xCoor+5 && circleX > xCoor-5 && circleY < yCoor+5 && circleY > yCoor-5)
        {
            paint.setARGB(255,0,255,0);
        }
        else if(circleX < xCoor+255 && circleX > xCoor-255 && circleY < yCoor+255 && circleY > yCoor-255)
        {
            int compX = (int)xCoor-(int)circleX;
            if(compX < 0)
            {
                compX = compX*-1;
            }
            int compY = (int)yCoor-(int)circleY;
            if(compY < 0)
            {
                compY = compY*-1;
            }
            int compXY = Math.max(compX, compY);
            rValue = 255-compXY;
            bValue = 255-rValue;

            paint.setARGB(255,rValue,0,bValue);
        }
        else
        {
            paint.setARGB(255,0,0,255);
        }

        // Draw the rectangle.
        canvas.drawRect(circleX, circleY, circleX + 100, circleY + 100, paint);

        surfaceHolder.unlockCanvasAndPost(canvas);
    }

/**
    public void drawHeart()
    {
        surfaceHolder = getHolder();

        Canvas canvas = surfaceHolder.lockCanvas();
        Paint paint = new Paint();

        Paint surfaceBackground = new Paint();
        // Set the surfaceview background color.
        surfaceBackground.setColor(Color.BLUE);
        // Draw the surfaceview background color.
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);

        Path path = new Path();
        canvas.drawColor(Color.RED);
        paint.setShader(null);

        float width = 100;
        float height = 200;

        // Starting point
        path.moveTo(width / 2, height / 5);

        // Upper left path
        path.cubicTo(5 * width / 14, 0,
                0, height / 15,
                width / 28, 2 * height / 5);

        // Lower left path
        path.cubicTo(width / 14, 2 * height / 3,
                3 * width / 7, 5 * height / 6,
                width / 2, height);

        // Lower right path
        path.cubicTo(4 * width / 7, 5 * height / 6,
                13 * width / 14, 2 * height / 3,
                27 * width / 28, 2 * height / 5);

        // Upper right path
        path.cubicTo(width, height / 15,
                9 * width / 14, 0,
                width / 2, height / 5);

        paint.setColor(Color.RED);
        paint.setStyle(Style.FILL);
        canvas.drawPath(path, paint);

    }
**/
    public float getCircleX() {
        return circleX;
    }

    public void setCircleX(float circleX) {
        this.circleX = circleX;
    }

    public float getCircleY() {
        return circleY;
    }

    public void setCircleY(float circleY) {
        this.circleY = circleY;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}
