package com.example.opengl01.shapes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Quad {
	// vertices
	private float[] vertices = {
			-1.0f,  1.0f, 0.0f,  // 0, Top Left
			-1.0f, -1.0f, 0.0f,  // 1, Bottom Left
			 1.0f, -1.0f, 0.0f,  // 2, Bottom Right
			 1.0f,  1.0f, 0.0f,  // 3, Top Right
	};
	
	private float[] vertexColors = {
			 1.0f,  0.0f, 0.0f, 1.0f, // 0, Top Left
			 0.0f,  1.0f, 0.0f, 1.0f, // 1, Bottom Left
			 0.0f,  0.0f, 1.0f, 1.0f, // 2, Bottom Right
			 1.0f,  1.0f, 0.0f, 1.0f  // 3, Top Right
	};
	
	// the order we're connecting them
	private short[] indices = { 0, 1, 3, 2 };
	
	private float[] pos = { 0.0f, 0.0f, 0.0f };
	
	// here's the vertex buffer
	private FloatBuffer vtxBuffer;
	private ShortBuffer idxBuffer;
	private FloatBuffer clrBuffer;
	
	
	// --------------------------------------------------------
	// ctor
	public Quad() {
		
		// create our buffers
		ByteBuffer vtxBB = ByteBuffer.allocateDirect(vertices.length * 4);
		vtxBB.order(ByteOrder.nativeOrder());
		vtxBuffer = vtxBB.asFloatBuffer();
		vtxBuffer.put(vertices);
		vtxBuffer.position(0);
		
		ByteBuffer idxBB = ByteBuffer.allocateDirect(indices.length * 2);
		idxBB.order(ByteOrder.nativeOrder());
		idxBuffer = idxBB.asShortBuffer();
		idxBuffer.put(indices);
		idxBuffer.position(0);
		
		ByteBuffer clrBB = ByteBuffer.allocateDirect(vertexColors.length * 4);
		clrBB.order(ByteOrder.nativeOrder());
		clrBuffer = clrBB.asFloatBuffer();
		clrBuffer.put(vertexColors);
		clrBuffer.position(0);
		
	}
	
	public void setPos(float x, float y, float z) {
		pos[0] = x;
		pos[1] = y;
		pos[2] = z;
	}
	
	// --------------------------------------------------------
	// our drawing func
	public void draw(GL10 gl) {
		
		// save the mtx state
		gl.glPushMatrix();
		
		// reset the transform matrix
		gl.glLoadIdentity();
		
		// apply the transformations
		gl.glTranslatef(pos[0], pos[1], pos[2]);
		
		// ccw winding
		gl.glFrontFace(GL10.GL_CCW);
		// enable the culling
		gl.glEnable(GL10.GL_CULL_FACE);
		// cull back
		gl.glCullFace(GL10.GL_BACK);
		
		// enable the color buffer mode
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, clrBuffer);
		
		// enble the vtx array
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		// give it the vtx buffer
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vtxBuffer);
		// now use it to draw the elements
		gl.glDrawElements(GL10.GL_TRIANGLE_STRIP, indices.length, GL10.GL_UNSIGNED_SHORT, idxBuffer);
		// now disable what we enabled before
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		// disable the culling
		gl.glDisable(GL10.GL_CULL_FACE);
		
		// popo the matrix state
		gl.glPopMatrix();
	
	}
}
