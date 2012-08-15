package com.example.opengl01;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES10;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import com.example.opengl01.shapes.Quad;

//--------------------------------------------------------
public class MyGL20Renderer implements  GLSurfaceView.Renderer {
	
	Quad myQuad = new Quad();
	float z = -4.0f;
	float direction = -0.01f;
	
	// --------------------------------------------------------
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // Set the background frame color
		GLES10.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		// smooth shading
		GLES10.glShadeModel(GLES10.GL_SMOOTH);
		// depth buffer setup
		GLES10.glClearDepthf(1.0f);
		// type of dept test
		GLES10.glDepthFunc(GLES10.GL_EQUAL);
		// perspective calculations
		GLES10.glHint(GLES10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
    }

	// --------------------------------------------------------
    public void onDrawFrame(GL10 gl) {
        // Redraw background color
    	GLES10.glClear(GLES10.GL_COLOR_BUFFER_BIT | GLES10.GL_DEPTH_BUFFER_BIT);
    	
    	// primitive animation
    	// we've passed the bounds, we change direction
    	if ((direction < 0.0f && z < -8.0f) || (direction > 0.0f && z > -4.0f)) {
    		direction *= -1.0f;
    	} 
    	
    	// animate z towards the direction
    	z += direction;
    	
    	myQuad.setPos(0.0f, 0.0f, z);
    	
    	// draw our quad
    	myQuad.draw(gl);
    	
    	
    }

    // --------------------------------------------------------
    public void onSurfaceChanged(GL10 gl, int width, int height) {
    	// sets our viewport size
    	GLES10.glViewport(0, 0, width, height);
    	// select the projection matrix
    	GLES10.glMatrixMode(GLES10.GL_PROJECTION);
    	// reset the projection matrix
    	GLES10.glLoadIdentity();
    	// calc the aspect roatio of the window
    	GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.1f, 100.0f);
    	// select the modelvire matrix
    	GLES10.glMatrixMode(GLES10.GL_MODELVIEW);
    	// reset this matrix as well
    	GLES10.glLoadIdentity();
    	
    }
    
}
