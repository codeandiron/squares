package com.wishabi;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;

public class AppletDemo extends Applet {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Square> squares;
	int width, height;
	
	public void init(){
		width = getSize().width;
		height = getSize().height;
		setBackground(Color.black);
	}

	public void paint(Graphics g) {
		squares = new ArrayList<Square>();
		
		Rectangle bounds = g.getClipBounds();
		
		g.setColor(Color.WHITE);
		for (int x = 0; x <= 600; x += 100)
			g.drawLine(x, 0, x, 600);
		for (int y = 0; y <= 600; y += 100)
			g.drawLine(0, y, 600, y);
		
		Frame frame = new Frame(0, 0, bounds.width, bounds.height);
		
		String[] widths = {"14", "23", "14", "35", "35", "19", "59", 
				"13", "34", "62", "61", "60", "58", "54", "43", "2", "100", "95", "65", "67"};
		
		for(int i = 0; i<widths.length; i++){
			Square square = new Square(0, 0, Integer.parseInt(widths[i]));
			squares.add(square);
			System.out.println("Added square with width: " + square);
		}
		
		Collections.sort(squares, new SquareComparator());
		
		try {
			squares = frame.placeSquares(squares);
			for(Square square : squares){
				g.setColor(square.color);
				g.fillRect(square.x, square.y, square.width, square.width);
			}
		} catch (FrameFullException e) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("TimesRoman", Font.BOLD, 36));
			g.drawString("Too small!", 10, 50);
		}
	}
}