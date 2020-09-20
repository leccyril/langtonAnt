package com.langton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.langton.service.IAntService;
import com.langton.service.IFileStorageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value="Spring boot REST Api for the Langton ant algorithm")
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
	@PutMapping(value = "/{stepNumber}")
	public String launchAnt(@ApiParam(
		    name =  "stepNumber",
		    type = "int",
		    value = "step number for ant to execute",
		    example = "11000",
		    required = true) @PathVariable("stepNumber") int stepNumber){
		service.launchAnt(stepNumber);
		return "process finished file available";
		
	}
    
    @ApiOperation(value = "Download file generated")
    @GetMapping(value="/download")
    public ResponseEntity<Resource> downloadFile() {
       return fileStorageService.loadFileAsResource();
    }
}
	
	
