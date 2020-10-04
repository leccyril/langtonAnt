package com.langton.helper;

import org.apache.commons.lang3.Validate;

import com.langton.model.Ant;
import com.langton.model.Cell;
import com.langton.model.Color;
import com.langton.model.Grid;

/**
 * Used to help ant object with orientation or position
 * 
 * @author Administrator
 *
 */
public class GridHelper {
	
	public static final String GRID_NULL_MSG="grid could not be null";
	
	public static final String ANT_NULL_MSG="ant could not be null";

	private GridHelper() {
		throw new AssertionError("You can not instanciate this class");
	}

	/**
	 * Will update width, minWidth, height and minHeight values
	 * @param grid the current grid to update
	 * @param ant the current ant position
	 */
	public static void updateWidhtAndHeight(Grid grid,Ant ant) {
		
		Validate.notNull(ant, ANT_NULL_MSG);
		
		Validate.notNull(grid, GRID_NULL_MSG);
		
		if(grid.getWidth()<ant.getX()) {
			grid.setWidth(ant.getX());
		}else if(ant.getX()<0) {
			grid.setMinWidth(ant.getX());
		}
		
		if(grid.getHeight()<ant.getY()) {
			grid.setHeight(ant.getY());
		}else if(ant.getY()<0) {
			grid.setMinHeight(ant.getY());
		}
	}
	
	/**
	 * Will revert the color grid following the current color cell
	 * 
	 * @param currentColor
	 * @param grid
	 * @param ant
	 */
	public static void revertCellColorFromByPosition(Color currentColor, Grid grid, int x, int y) {
		
		Validate.notNull(grid, GRID_NULL_MSG);
		
		Validate.notNull(currentColor, "current color could not be null");

		grid.getCells().replace(new Cell(x, y), (currentColor == Color.WHITE) ? Color.BLACK : Color.WHITE);

	}

}
