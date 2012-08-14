package com.example.opengl01;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;

public class OGLActivity extends Activity {
	
	private GLSurfaceView mGLSurfaceView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	// call the super method
        super.onCreate(savedInstanceState);

        // Create a GLSurfaceView instance and set it
        // as the ContentView for this Activity.
        mGLSurfaceView = new MyGLSurfaceView(this);
        setContentView(mGLSurfaceView);
        
        
        //setContentView(R.layout.activity_ogl);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_ogl, menu);
        return true;
    }
}
