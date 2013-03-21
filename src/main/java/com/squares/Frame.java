package com.squares;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Frame extends Rectangle {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Square> placedSquares = new ArrayList<Square>();
	
	//the lowest y coordinate our current placed squares have reached
	private int lowest = 0;
	
	//the rightmost that our squares have reached in the current line
	private int rightmost = 0;
	
	//the amount we need to "jump down" by if we reach the far right of the frame
	private int nextLine = 0;
	
	public Frame(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public ArrayList<Square> placeSquares(ArrayList<Square> squaresToPlace) throws FrameFullException {
		for(Square square : squaresToPlace){
			placeSquare(square);
		}
		return this.placedSquares;
	}

	//Places the square in the "PlacedSquares" of this Frame... if it fits
	private void placeSquare(Square squareToPlace) throws FrameFullException {
		Point nextSquaresOrigin = getNextOrigin(squareToPlace);
		Square placedSquare = new Square(nextSquaresOrigin.x, nextSquaresOrigin.y, squareToPlace.width);
		placedSquares.add(placedSquare);
	}
	
	//Returns the suggested origin of the square... if it fits
	private Point getNextOrigin(Square square) throws FrameFullException{
		
		//If this is the first square, or if we've hit the right of the frame	
		//newLine and save the height of the current square
		if(nextLine == 0 || (rightmost + square.width) > this.width){
			newLine();
			this.nextLine = square.height;
		}
		
		//If the current square will not fit heightwise in the frame
		if((this.lowest + square.height) > this.height){
			throw new FrameFullException("Could not place all of the squares in the frame");
		}
		
		Point origin = new Point(rightmost, lowest);
		
		//Bump the rightmost x coordinate that our squares have reached
		rightmost = rightmost + square.width + 1;
		
		return origin;
	}
	
	//This method bumps us to the next "line" of the frame, like a CRLF
	private void newLine(){
		lowest = lowest + nextLine + 1;
		rightmost = 0;
	}
}
