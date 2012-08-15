package com.example.opengl01;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

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
		gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		// smooth shading
		gl.glShadeModel(GL10.GL_SMOOTH);
		// depth buffer setup
		gl.glClearDepthf(1.0f);
		// type of dept test
		gl.glDepthFunc(GL10.GL_EQUAL);
		// perspective calculations
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
    }

	// --------------------------------------------------------
    public void onDrawFrame(GL10 gl) {
        // Redraw background color
    	gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
    	
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
    	gl.glViewport(0, 0, width, height);
    	// select the projection matrix
    	gl.glMatrixMode(GL10.GL_PROJECTION);
    	// reset the projection matrix
    	gl.glLoadIdentity();
    	// calc the aspect roatio of the window
    	GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.1f, 100.0f);
    	// select the modelvire matrix
    	gl.glMatrixMode(GL10.GL_MODELVIEW);
    	// reset this matrix as well
    	gl.glLoadIdentity();
    	
    }
    
}
