package com.langton.model;

import lombok.Data;

@Data
public class Ant {

	private Orientation orientation=Orientation.NORTH;
	private int x;
	private int y;
	
	public Ant(Orientation orientation, int x, int y) {
		super();
		this.orientation = orientation;
		this.x = x;
		this.y = y;
	}

	

}
