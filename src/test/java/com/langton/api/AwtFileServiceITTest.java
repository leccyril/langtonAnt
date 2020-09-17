package com.langton.api;

import java.io.File;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


import com.langton.model.Color;
import com.langton.model.Grid;
import com.langton.service.IFileService;

@SpringBootTest
public class AwtFileServiceITTest {

	@Autowired
	private IFileService service;

	
	@Test
	public void generateOutputFileInputTest() {
		Grid grid = new Grid(Color.WHITE, 10, 10);
			File file=service.generateOutputFile(grid);
			assertTrue(file.exists());
	}
	
	@Test
	public void generateOutputFileNullInputTest() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			service.generateOutputFile(null);
		});
	}

}
