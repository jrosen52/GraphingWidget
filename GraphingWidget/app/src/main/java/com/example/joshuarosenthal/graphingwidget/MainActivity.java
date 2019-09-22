package com.example.joshuarosenthal.graphingwidget;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private LinearLayout canvasLayout = null;

    AppSurface customSurfaceView = null;

    private TextView coors;

    String[] shapes ={"Circle","Square"};
    int images[] = {R.drawable.circle, R.drawable.square};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("SurfaceView");

        initControls();

        // Hide the app title bar.
        getSupportActionBar().hide();

        // Make app full screen to hide top status bar.
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Create custom surfaceview object.
        customSurfaceView = new AppSurface(getApplicationContext());

        // Set this as the onTouchListener to process custom surfaceview ontouch event.
        customSurfaceView.setOnTouchListener(this);

        // Add the custom surfaceview object to the layout.
        canvasLayout.addView(customSurfaceView);

        coors = (TextView) findViewById(R.id.coor);

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You Select Position: "+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinnerAdapter customAdapter1 = new SpinnerAdapter(getApplicationContext(),images,shapes);
        spin.setAdapter(customAdapter1);

    }

    /* Initialise ui controls. */
    private void initControls()
    {
        // This layout is used to contain custom surfaceview object.
        if(canvasLayout == null)
        {
            canvasLayout = (LinearLayout)findViewById(R.id.customViewLayout);
        }
    }

    /* If user finger touch the surfaceview object. */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        // If user touch the custom SurfaceView object.
        if(view instanceof SurfaceView) {
            view.invalidate();

            float x = motionEvent.getX();

            float y = motionEvent.getY();

            String coorNums = (int)x + ", " + (int)y;
            coors.setText(coorNums);
            customSurfaceView.setCircleX(x);

            customSurfaceView.setCircleY(y);

            // Create and set a red paint to custom surfaceview.
            Paint paint = new Paint();
            paint.setColor(Color.GREEN);
            customSurfaceView.setPaint(paint);

            customSurfaceView.drawBall();
            //Toast.makeText(MainActivity.this, " X: " + x +" Y: "+y, Toast.LENGTH_SHORT).show();


            // Tell android os the onTouch event has been processed.
            return true;
        }else
        {
            // Tell android os the onTouch event has not been processed.
            return false;
        }
    }
}
