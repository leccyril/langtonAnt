package com.langton.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.langton.helper.AntHelper;
import com.langton.model.Ant;
import com.langton.model.Cell;
import com.langton.model.Color;
import com.langton.model.Grid;
import com.langton.model.Orientation;

@Service
public class AntServiceImpl implements IAntService {
	
    public static final Logger logger = LoggerFactory.getLogger(AntServiceImpl.class);


	@Value("${application.grid.color}")
	private String gridColor;

	@Value("${application.grid.x.size}")
	private int gridXSize;

	@Value("${application.grid.y.size}")
	private int gridYSize;
	
	@Value("${application.ant.orientation}")
	private String antInitOrientation;

	@Autowired
	private IFileService fileService;

	@Override
	public void launchAnt(int stepNumber) {
		
		logger.info("Start ant langton process");

		// initialize the grid and the ant
		Grid grid = new Grid(Color.valueOf(Color.class, gridColor), gridXSize, gridYSize);
		Ant ant = new Ant(Orientation.valueOf(antInitOrientation), gridXSize / 2, gridYSize / 2);

		// for each step we move the ant on the grid
		for (int i = 0; i < stepNumber; i++) {
			logger.debug("step number {}",i);
			moveForward(grid, ant);
		}

		//then we generate output file
		fileService.generateOutputFile(grid);
		
		logger.info("End ant langton process");

	}

	@Override
	public void moveForward(Grid grid, Ant ant) {
		
		logger.debug("ant move forward");
				
		grid.getCells().putIfAbsent(new Cell(ant.getX(),ant.getY()),grid.getBaseColor());
		
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
		
		Color currentColor = grid.getCells().get(new Cell(ant.getX(),ant.getY()));
		
		logger.debug("current color {}",currentColor);
		
		AntHelper.setNewOrientation(ant, currentColor);
		AntHelper.revertColorBaseCell(currentColor, grid, ant.getX(), ant.getY());
		AntHelper.updateAntPosition(ant);
		
		logger.debug("ant orientation {}",ant.getOrientation());
		logger.debug("ant x position {}",ant.getX());
		logger.debug("ant y position {}",ant.getY());

	}

}
