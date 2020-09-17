package com.langton.model;

/**
 * 
 * @author Administrator
 *
 */
public enum Orientation {
    
    NORTH,
    EAST,
    SOUTH,
    WEST;
    
	private static final Orientation[] VALUES = values();
	
	
	public Orientation getOppositeOrientation() {
        return VALUES[(ordinal() + 2) % 4];
    }
	
	public Orientation rotateClockwise() {
		return VALUES[(ordinal() + 1) % 4];
	}
    
	public Orientation rotateOppositeClockwise() {
		return (ordinal() == 0) ? VALUES[3] : VALUES[(ordinal() - 1) % 4];
	}
    
	
}
