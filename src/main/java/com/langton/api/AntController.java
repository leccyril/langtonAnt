package com.langton.api;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.langton.service.AntServiceImpl;
import com.langton.service.IAntService;
import com.langton.service.IFileStorageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Will launch the langton")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AntController {
	
	public static final Logger logger = LoggerFactory.getLogger(AntController.class);

	@Autowired
	private IAntService service;
	
	@Autowired
    private IFileStorageService fileStorageService;
	
    @ApiOperation(value = "Launch langton ant algortithm following step number parameter")
    //​@ApiParam(name = stepNumber,​required = true, type=String.class)
	@PutMapping(value = "/{stepNumber}")
	public String launchAnt(@PathVariable("stepNumber") int stepNumber){
		service.launchAnt(stepNumber);
		return "process finished file available";
		
	}
    
    @ApiOperation(value = "downlad file generated")
    @GetMapping(value="/download")
    public ResponseEntity<Resource> downloadFile() {
       return fileStorageService.loadFileAsResource();
    }
}
	
	
