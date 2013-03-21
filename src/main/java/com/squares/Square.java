package com.wishabi;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

public class Square extends Rectangle {
	
	private static final long serialVersionUID = 1L;
	public Color color;

	@SuppressWarnings("unused")
	private Square(){
		//Disable direct instantiation
	}
	
	public Square(int x, int y, int width){
		super(x, y, width, width);
		
		Random random = new Random();
		java.lang.Float red = new java.lang.Float(random.nextFloat());
		java.lang.Float green = new java.lang.Float(random.nextFloat());
		java.lang.Float blue = new java.lang.Float(random.nextFloat());
		this.color = new Color(red,green,blue);
	}
}

	
