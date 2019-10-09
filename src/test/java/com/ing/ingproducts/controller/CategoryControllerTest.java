package com.ing.ingproducts.controller;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.ing.ingproducts.dto.CategoryDetails;
import com.ing.ingproducts.dto.CategoryResponse;
import com.ing.ingproducts.service.CategoryServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {
	 @Mock
	 CategoryServiceImpl categoryServiceImpl;
	 @InjectMocks
	 CategoryController categoryController;
	 List<CategoryDetails>details=new ArrayList<>();
	 CategoryResponse categoryResponse=new CategoryResponse();

	 @Before
	 public void setUp() {
		 CategoryDetails categoryDetails=new CategoryDetails(1L,"ProductCategory1");
		 details.add(categoryDetails);
		 categoryResponse.setStatusCode(200);
		 categoryResponse.setStatusMessage("success");
		 categoryResponse.setCategories(details);

	 }
	 @Test
	 public void testGetAllCategories() {
		 Mockito.when(categoryServiceImpl.getAllCategories()).thenReturn(categoryResponse);
		 ResponseEntity<CategoryResponse> categoryResponse=categoryController.getAllCategories();
		 assertNotNull(categoryResponse);
		 
	 }
}
