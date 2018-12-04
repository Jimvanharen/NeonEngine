package org.virusparadox.math;

import static java.lang.Math.*;

public class Matrix4f {
	
	
	public float[] matrix = new float[4 * 4]; //MATRIX: [X * Y] 
	
	
	
	public static Matrix4f identity() {
		
		Matrix4f result = new Matrix4f();
		
		
		for(int i = 0; i < 4 * 4; i++) {
			
			
			result.matrix[i] = 0.0F;
			
			
			
		}
		
		
		result.matrix[0 + 0 * 4] = 1.0F;
		result.matrix[1 + 1 * 4] = 1.0F;
		result.matrix[2 + 2 * 4] = 1.0F;
		result.matrix[3 + 3 * 4] = 1.0F;
		
		
		
		return result;
	}
	
	
	public Matrix4f multiply(Matrix4f matrix) {
		
		
		Matrix4f result = new Matrix4f();
		
		for(int y = 0; y < 4; y++) {
			
			for(int x = 0; x < 4; x++) {
				
				float sum = 0.0f;
				for(int f = 0; f < 4; f++) {
					
					sum += this.matrix[f + y * 4] * matrix.matrix[x + f * 4];
					
				}
				
				result.matrix[x + y * 4] = sum;
				
				
			}
			
			
		}
		
		
		return result;
		
	}
	
	
	public static Matrix4f translate(Vector3 vector) {
		
		Matrix4f result = identity();
		
		result.matrix[0 + 3 * 4] = vector.x;
		result.matrix[1 + 3 * 4] = vector.y;
		result.matrix[2 + 3 * 4] = vector.z;
		
		
		
		
		return result;
		
	}
	
	
	public static Matrix4f rotate(float angle) {
		
		
		Matrix4f result = identity();
		
		float r = (float) toRadians(angle);
		
		float cos = (float) cos(r);
		float sin = (float) sin(r);
		
		
		result.matrix[0 + 0 * 4] = cos;
		result.matrix[1 + 0 * 4] = sin;
		
		result.matrix[0 + 1 * 4] = -sin;
		result.matrix[1 + 1 * 4] = cos;
		
		
		return result;
		
		
		
	}
	
	
	public static Matrix4f orthographic(float left, float right, float bottom, float top, float near, float far) {
		
		Matrix4f result = identity();
		
		result.matrix[0 + 0 * 4] = 2.0F / (right - left);
		result.matrix[1 + 1 * 4] = 2.0F / (top - bottom);
		result.matrix[2 + 2 * 4] = 2.0F / (near - far);
		
		
		
		result.matrix[0 + 3 * 4] = (left + right) / (left - right);
		result.matrix[1 + 3 * 4] = (bottom + top) / (bottom - top);
		result.matrix[2 + 3 * 4] = (near + far) / (far - near);

		
		
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	

}
