package com.wishabi;

import java.util.Comparator;

public class SquareComparator implements Comparator<Square> {

	@Override
	public int compare(Square o1, Square o2) {
	    final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
	    
	    if(o1.width > o2.width) {
	    	return BEFORE;
	    }else if(o1.width == o2.width){
	    	return EQUAL;
	    }else{
	    	return AFTER;
	    }
	}
}
