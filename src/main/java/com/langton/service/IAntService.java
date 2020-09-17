package com.langton.service;

import com.langton.model.Ant;
import com.langton.model.Grid;

/**
 * Service initializing and launching Ant on Grid
 * @author Administrator
 *
 */
public interface IAntService {

	/**
	 * Launch the ant and reinit the grid on each launch
	 * @param stepNumber the step to execute (each step will walk the ant)
	 */
	void launchAnt(int stepNumber);
	
	
	/**
	 * make move the ant on the grid
	 * @param grid grid where ant is moving
	 * @param ant
	 */
	void moveForward(Grid grid, Ant ant);
}
