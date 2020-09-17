package com.langton.helper;

import org.apache.commons.lang3.Validate;

import com.langton.model.Ant;
import com.langton.model.Cell;
import com.langton.model.Color;
import com.langton.model.Grid;
import com.langton.model.Orientation;

/**
 * Used to help ant objet with orientation or position
 * 
 * @author Administrator
 *
 */
public class AntHelper {
	
	public final static String ANT_NULL_MSG="ant could not be null";

	private AntHelper() {
		throw new AssertionError("You can not instanciate this class");
	}

	/**
	 * 
	 * @param ant
	 * @param color
	 */
	public static void setNewOrientation(Ant ant, Color color) {

		Validate.notNull(ant, ANT_NULL_MSG);
		Validate.notNull(color, "color could not be null");

		switch (color) {
		case WHITE:
			setNewOrientationFromWhite(ant);
			break;
		case BLACK:
			setNewOrientationFromBlack(ant);
			break;
		default:
			setNewOrientationFromWhite(ant);
			break;
		}

	}

	/**
	 * update the ant position following orientation
	 * 
	 * @param ant
	 */
	public static void updateAntPosition(Ant ant) {

		Validate.notNull(ant, ANT_NULL_MSG);

		if (ant.getOrientation() == Orientation.NORTH) {
			ant.setY(ant.getY() + 1);
		} else if (ant.getOrientation() == Orientation.WEST) {
			ant.setX(ant.getX() - 1);
		} else if (ant.getOrientation() == Orientation.SOUTH) {
			ant.setY(ant.getY() - 1);
		} else if (ant.getOrientation() == Orientation.EAST) {
			ant.setX(ant.getX() + 1);
		}

	}

	/**
	 * Will update the position following the black rule
	 * 
	 * @param ant
	 */
	private static void setNewOrientationFromBlack(Ant ant) {

		Validate.notNull(ant, ANT_NULL_MSG);

		if (ant.getOrientation() == Orientation.NORTH) {
			ant.setOrientation(Orientation.WEST);
		} else if (ant.getOrientation() == Orientation.WEST) {
			ant.setOrientation(Orientation.SOUTH);
		} else if (ant.getOrientation() == Orientation.SOUTH) {
			ant.setOrientation(Orientation.EAST);
		} else if (ant.getOrientation() == Orientation.EAST) {
			ant.setOrientation(Orientation.NORTH);
		}
	}

	/**
	 * Will update the position following the white rule
	 * 
	 * @param ant
	 */
	private static void setNewOrientationFromWhite(Ant ant) {

		Validate.notNull(ant, ANT_NULL_MSG);

		if (ant.getOrientation() == Orientation.NORTH) {
			ant.setOrientation(Orientation.EAST);
		} else if (ant.getOrientation() == Orientation.EAST) {
			ant.setOrientation(Orientation.SOUTH);
		} else if (ant.getOrientation() == Orientation.SOUTH) {
			ant.setOrientation(Orientation.WEST);
		} else if (ant.getOrientation() == Orientation.WEST) {
			ant.setOrientation(Orientation.NORTH);
		}
	}

	/**
	 * Will revert the color grid following the current color cell
	 * 
	 * @param currentColor
	 * @param grid
	 * @param ant
	 */
	public static void revertColorBaseCell(Color currentColor, Grid grid, int x, int y) {
		
		Validate.notNull(grid, "grid could not be null");
		
		Validate.notNull(currentColor, "current color could not be null");

		grid.getCells().replace(new Cell(x, y), (currentColor == Color.WHITE) ? Color.BLACK : Color.WHITE);

	}

}
