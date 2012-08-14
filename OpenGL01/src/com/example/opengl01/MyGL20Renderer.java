package com.example.opengl01;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView;


public class MyGL20Renderer implements  GLSurfaceView.Renderer {
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // Set the background frame color
        //GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
		gl.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
    }

    public void onDrawFrame(GL10 gl) {
        // Redraw background color
    	gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    }

    public void onSurfaceChanged(GL10 gl, int width, int height) {
    	gl.glViewport(0, 0, width, height);
    }
}
