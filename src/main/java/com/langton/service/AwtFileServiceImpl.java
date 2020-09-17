package com.langton.service;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.langton.model.Cell;
import com.langton.model.Color;
import com.langton.model.Grid;

@Service
public class AwtFileServiceImpl implements IFileService {

	public static final Logger logger = LoggerFactory.getLogger(AwtFileServiceImpl.class);

	@Value("${application.file.path}")
	private String filePath;

	@Value("${application.file.name}")
	private String fileName;

	@Value("${application.file.format}")
	private String fileFormat;

	@Override
	public File generateOutputFile(Grid grid) {

		logger.info("Start generating output file formtat {}", fileFormat);

		Validate.notNull(grid, "grid must not be null");

		//we calculate the final size to print
		int finalWidth = grid.getWidth() + Math.abs(grid.getMinWidth());
		int finalHeight = grid.getHeight() + Math.abs(grid.getMinHeight());

		//we calculate the offset to define cause we can't print negative value
		int widthOffset = Math.abs(0 - grid.getMinWidth());
		int heightOffset = Math.abs(0 - grid.getMinHeight());

		BufferedImage bufferedImage = new BufferedImage(finalWidth, finalHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bufferedImage.createGraphics();

		logger.debug("grid {} width and {} height", grid.getWidth(), grid.getHeight());
		logger.debug("grid {} minwidth and {} minheight", grid.getMinWidth(), grid.getMinHeight());

		// start with blank picture
		g2d.setColor(java.awt.Color.white);
		g2d.fillRect(0, 0, finalWidth, finalHeight);

		//for each element we print with offset (because on graphic2d negative value does not exists)
		for (Map.Entry<Cell, Color> entry : grid.getCells().entrySet()) {

			g2d.setColor(entry.getValue() == Color.WHITE ? java.awt.Color.white : java.awt.Color.black);
			g2d.drawRect(entry.getKey().getX() + widthOffset, entry.getKey().getY() + heightOffset, 1, 1);
		}

		// Disposes of this graphics context and releases any system resources that it
		// is using.
		g2d.dispose();

		// create the file
		File file = new File(filePath + File.separator + fileName);
		try {
			ImageIO.write(bufferedImage, fileFormat, file);

			logger.info("File generated here {}", filePath + File.separator + fileName);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return file;
	}

}
