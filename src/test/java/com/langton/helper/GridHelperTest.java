package com.langton.helper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;

import com.langton.model.Ant;
import com.langton.model.Cell;
import com.langton.model.Color;
import com.langton.model.Grid;
import com.langton.model.Orientation;

@SpringBootTest
public class GridHelperTest {
	
	@Test
	public void revertColorToBlackTest(){
		Grid grid = new Grid(Color.WHITE, 100, 100);
		GridHelper.revertCellColorFromByPosition(Color.WHITE, grid, 10, 10);
		assertEquals(Color.BLACK,grid.getCells().get(new Cell(10,10)));		
	}
	
	@Test
	public void revertColorToWhiteTest(){
		Grid grid = new Grid(Color.WHITE, 100, 100);
		GridHelper.revertCellColorFromByPosition(Color.BLACK, grid, 10, 10);
		assertEquals(Color.WHITE,grid.getCells().get(new Cell(10,10)));		
	}
	
	@Test
	public void revertColorNulleTest(){
		Assertions.assertThrows(NullPointerException.class, () -> {
			GridHelper.revertCellColorFromByPosition(Color.BLACK, null, 10, 10);
		});	
	}

}
