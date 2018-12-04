package org.virusparadox.main;

import  org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import  org.lwjgl.glfw.GLFWVidMode.*;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

/*
 * ##############################################
 * We will be using LWJGL v3 for this application (Imported via Maven)
 * Author: VirusParadox
 * 
 * Explanation: This will be an app that is gonna make a real virtual world 
 * with all the physics elements and chemestry biology elements to really make a -FAKE- world
 * this is for testing purposes only so you can test a lot of things here and really learn something
 * about THEORY
 * ##############################################
 * 
 * 
 * 
 */


public class Main {
	
	private long window; 
	
	private String version; 
	
	
	//Construction of applicaiton
	public Main() {
		
		initializeGLFW();
		windowtick();
		
		cleanup();
		
	}
	
	//Mostly GLFW window stuff (setting it up)
	public void initializeGLFW() {
		
		if(!GLFW.glfwInit()) {
			
			System.err.println("Something went wrong with initializing GLFW(The window for this application)");
			
			
			
		}
		
		//Hinting the window(Customizing the window)
		GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
		
		
		window = GLFW.glfwCreateWindow(900, 800, "Some Cool shit", 0, 0);
		
		if(window == 0L) {
			
			System.err.println("Failed to create the window" + "\n" +"-Window ID: " +  window);
			
			
		}
		
		GLFWVidMode vim = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
		
		
		GLFW.glfwSetWindowPos(window, (vim.width() - 900) / 2, (vim.height() - 800) / 2);
		
		
		GLFW.glfwMakeContextCurrent(window);
		
		
		GLFW.glfwShowWindow(window);
		
		
		
		
	}
	
	//A method that constantly ticks
	public void windowtick() {
		
		GL.createCapabilities();
		
		version = GL11.glGetString(GL11.GL_VERSION);
		
		System.out.println(version);
		
		GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
		
		while(!GLFW.glfwWindowShouldClose(window)) {
			
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			
			GLFW.glfwSwapBuffers(window);
			
			
			GLFW.glfwPollEvents();
			
			
			
			
		}
		
		
		
		
		
	}
	
	
	
	public void cleanup() {
		
		GLFW.glfwDestroyWindow(window);
		
		GLFW.glfwTerminate();
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		
		new Main();
		
		
	}

}
