package com.langton.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public interface IFileStorageService {
	
	/**
	 * Will download the result file
	 * @return
	 */
	ResponseEntity<Resource> loadFileAsResource();

}
