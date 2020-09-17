package com.langton.api;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.langton.model.Ant;
import com.langton.model.Cell;
import com.langton.model.Color;
import com.langton.model.Grid;
import com.langton.model.Orientation;
import com.langton.service.IAntService;

@SpringBootTest
class AntServiceITTest {
	
	@Value("${application.file.path}")
	private String filePath;

	@Value("${application.file.name}")
	private String fileName;

	@Value("${application.file.format}")
	private String fileFormat;
	
	@Autowired
	private IAntService service;

	@Test
	void launchTests() {
		Grid grid =new Grid(Color.WHITE, 100, 100);
		Ant ant =new Ant(Orientation.EAST, 100/2, 100/2);
		service.moveForward(grid, ant);		
		assertEquals(Orientation.SOUTH,ant.getOrientation());
		assertEquals(50,ant.getX());
		assertEquals(49,ant.getY());		
		assertEquals(Color.BLACK,grid.getCells().get(new Cell(50,50)));
	
	}
	
	
	@Test
	void launchAntTests() {
		service.launchAnt(20);
		File file = new File(filePath + File.separator + fileName);
		assertTrue(file.exists());	
		file.delete();
	}
	

}
