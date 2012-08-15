package com.example.opengl01;

import android.content.Context;
import android.opengl.GLSurfaceView;

//--------------------------------------------------------
public class MyGLSurfaceView extends GLSurfaceView {
	
	
	// --------------------------------------------------------
	public MyGLSurfaceView(Context context){
        super(context);

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(new MyGL20Renderer());
        
        // Create an OpenGL ES 2.0 context
        //setEGLContextClientVersion(2);
        
        // Render the view only when there is a change in the drawing data
        //setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}
        
        
}

	