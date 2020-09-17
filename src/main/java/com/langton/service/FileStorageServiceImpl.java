package com.langton.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FileStorageServiceImpl implements IFileStorageService {

	public static final Logger logger = LoggerFactory.getLogger(FileStorageServiceImpl.class);

	@Value("${application.file.path}")
	private String filePath;

	@Value("${application.file.name}")
	private String fileName;

	public ResponseEntity<Resource> loadFileAsResource() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
		try {
			File file = new File(filePath + File.separator + fileName);
			Path path = Paths.get(file.getAbsolutePath());

			return ResponseEntity.ok().headers(headers).contentLength(file.length())
					.contentType(MediaType.APPLICATION_OCTET_STREAM)
					.body(new ByteArrayResource(Files.readAllBytes(path)));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
}
