package com.ing.ingproducts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.ingproducts.dto.CategoryResponse;
import com.ing.ingproducts.service.CategoryService;

@RestController
@RequestMapping("/categories")
@CrossOrigin(allowedHeaders = {"*","*/"}, origins = {"*","*/"})
public class CategoryController {
    private static Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	CategoryService categoryService;
	/**
	 * @return ResponseEntity of CategoryResponse which includes all the categories along with their Ids
	 * @since  2019-10-03
	 */
	@GetMapping("/")
	public ResponseEntity<CategoryResponse> getAllCategories() {
		logger.info("getAllCategories() in  CategoryController started");
		CategoryResponse categoryResponse=categoryService.getAllCategories();
		logger.info("getAllCategories() in  CategoryController started");
	    return new ResponseEntity<>(categoryResponse,HttpStatus.OK);
	}
}
