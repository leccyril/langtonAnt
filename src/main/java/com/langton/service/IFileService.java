package com.langton.service;

import java.io.File;

import org.springframework.core.io.Resource;

import com.langton.model.Grid;

/**
 * Will generate the output file of result
 * 
 * @author Administrator
 *
 */
public interface IFileService {

	/**
	 * generate the grid on file
	 * @param grid grid to generate
	 */
	File generateOutputFile(Grid grid);
	
	
}
