package com.ing.ingproducts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ing.ingproducts.dto.UploadResponse;
import com.ing.ingproducts.service.UploadProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(allowedHeaders = {"*","*/"}, origins = {"*","*/"})
public class UploadProductController {
    private static Logger logger = LoggerFactory.getLogger(UploadProductController.class);
    @Autowired 
    UploadProductService uploadProductService;

	/**
	 * @return ResponseEntity of CategoryResponse which includes all the categories along with their Ids
	 * @since  2019-10-03
	 */
	@PostMapping("/upload")
	public ResponseEntity<UploadResponse> uploadProducts(@RequestParam("file") MultipartFile fileInput) {
		logger.info("getAllCategories() in  UploadProductController started");
		UploadResponse uploadResponse=new UploadResponse();
		uploadProductService.upload(fileInput);
		uploadResponse.setStatusCode(200);
		uploadResponse.setMessage("success");
		logger.info("getAllCategories() in  UploadProductController ended");
	    return new ResponseEntity<>(uploadResponse,HttpStatus.OK);
	}
}
