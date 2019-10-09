package com.ing.ingproducts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ing.ingproducts.dto.ProductDescriptionDto;
import com.ing.ingproducts.dto.ProductResponse;
import com.ing.ingproducts.service.ProductService;



@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class ProductController {
	@Autowired
	ProductService productServiceIntf;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@GetMapping("/categories/{categoryId}/products")
	public ResponseEntity<ProductResponse> getProductsByCategory(@PathVariable Long categoryId)
	{
		LOGGER.info("inside product Controller");
		ProductResponse productResponse=productServiceIntf.getProductsByCategory(categoryId);
		
		return new ResponseEntity<>(productResponse,HttpStatus.OK);
		
	}
	
	@GetMapping("/products/{productId}")
	public ResponseEntity<ProductDescriptionDto> getProductDetails(@PathVariable Long productId)
	{
		LOGGER.info("inside product Description");
		ProductDescriptionDto productDescription=productServiceIntf.getProductDetails(productId);
		
		return new ResponseEntity<>(productDescription,HttpStatus.OK);
		
	}

}
