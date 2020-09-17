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
public class AntHelperTest {
	
	@Test
	public void revertColorToBlackTest(){
		Grid grid = new Grid(Color.WHITE, 100, 100);
		AntHelper.revertColorBaseCell(Color.WHITE, grid, 10, 10);
		assertEquals(Color.BLACK,grid.getCells().get(new Cell(10,10)));		
	}
	
	@Test
	public void revertColorToWhiteTest(){
		Grid grid = new Grid(Color.WHITE, 100, 100);
		AntHelper.revertColorBaseCell(Color.BLACK, grid, 10, 10);
		assertEquals(Color.WHITE,grid.getCells().get(new Cell(10,10)));		
	}
	
	@Test
	public void revertColorNulleTest(){
		Assertions.assertThrows(NullPointerException.class, () -> {
			AntHelper.revertColorBaseCell(Color.BLACK, null, 10, 10);
		});	
	}
	
	@Test
	public void setNewOrientationFromBlackNorthTest(){
		Ant ant = new Ant(Orientation.NORTH,10,10);
		AntHelper.setNewOrientation(ant, Color.BLACK);
		assertEquals(Orientation.WEST,ant.getOrientation());		
	}
	
	@Test
	public void setNewOrientationFromWhiteSouthTest(){
		Ant ant = new Ant(Orientation.SOUTH,10,10);
		AntHelper.setNewOrientation(ant, Color.WHITE);
		assertEquals(Orientation.WEST,ant.getOrientation());		
	}
	
	@Test
	public void setNewOrientationNullInputTest() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			AntHelper.setNewOrientation(null, null);
		});
	}
	
	@Test
	public void setNewOrientationNullFromWhiteInputTest() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			AntHelper.setNewOrientation(null, Color.WHITE);
		});
	}
	
	@Test
	public void setNewOrientationNullFromBlackInputTest() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			AntHelper.setNewOrientation(null, Color.BLACK);
		});
	}
	
	@Test
	public void setUpdatePositionTest() {
		Ant ant= new Ant(Orientation.NORTH,10,10);
		AntHelper.updateAntPosition(ant);
		assertEquals(11,ant.getY());	
		assertEquals(10,ant.getX());	
	}
	
	
	@Test
	public void setUpdatePositionNullTest() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			AntHelper.updateAntPosition(null);
		});
	}

}
