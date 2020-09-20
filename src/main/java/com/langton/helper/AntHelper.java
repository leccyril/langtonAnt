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
	
	public static final String ANT_NULL_MSG="ant could not be null";

	private AntHelper() {
		throw new AssertionError("You can not instanciate this class");
	}

	/**
	 * 
	 * @param ant
	 * @param color
	 */
	public static void updateAntOrientationFromCellColor(Ant ant, Color color) {

		Validate.notNull(ant, ANT_NULL_MSG);
		Validate.notNull(color, "color could not be null");

		switch (color) {
		case WHITE:
			updateOrientationFromWhiteCell(ant);
			break;
		case BLACK:
			updateOrientationFromBlackCell(ant);
			break;
		default:
			updateOrientationFromWhiteCell(ant);
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
	private static void updateOrientationFromBlackCell(Ant ant) {

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
	private static void updateOrientationFromWhiteCell(Ant ant) {

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


}
