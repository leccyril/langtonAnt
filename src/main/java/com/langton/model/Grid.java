
package com.langton.model;


import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * The grid where ant will walk, it is composed from cells
 * @author Administrator
 *
 */
@Data
public class Grid {
    
	private Map<Cell, Color> cells=new HashMap<>();
    private int width,height, minWidth, minHeight;
    
    private Color baseColor;
    
    public Grid(Color color,int x, int y){
        this.width = x;
        this.height = y;
        this.minWidth = 0;
        this.minHeight = 0;
        this.baseColor=color;
        initGrid();
    }
    
    public void initGrid() {
        for(int i=0;i<width;i++) {
        	for (int j=0;j<height;j++) {
        		cells.put(new Cell(i,j), baseColor);
        	}
        } 	
    }

}
