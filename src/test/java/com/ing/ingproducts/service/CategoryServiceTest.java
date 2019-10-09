package com.ing.ingproducts.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.ingproducts.dto.CategoryDetails;
import com.ing.ingproducts.dto.CategoryResponse;
import com.ing.ingproducts.entity.Category;
import com.ing.ingproducts.exception.CommonException;
import com.ing.ingproducts.repository.CategoryRepository;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {
	 @Mock
	 CategoryRepository categoryRepository;
	 @InjectMocks
	 CategoryServiceImpl categoryServiceImpl;
	 Category category=new Category();
	 CategoryResponse categoryResponse=new CategoryResponse();
	 List<Category> categories=new ArrayList<>();
	 List<CategoryDetails>details=new ArrayList<>();
	 @Before
	 public void setUp() {
		 category.setCategoryId(1L);
		 category.setCategoryName("ProductCategory1");
		 categories.add(category);
		 CategoryDetails categoryDetails=new CategoryDetails(1L,"ProductCategory1");
		 categoryResponse.setStatusCode(200);
		 categoryResponse.setStatusMessage("success");
		 details.add(categoryDetails);
		 categoryResponse.setCategories(details);
	 }
	 
	 @Test
	 public void testGetAllCategories() {
		 Mockito.when(categoryRepository.findAll()).thenReturn(categories);
		 CategoryResponse result= categoryServiceImpl.getAllCategories();
		 assertEquals(new Integer(200) , result.getStatusCode());
	 }
	 
	 @Test(expected = CommonException.class)
	 public void testGetAllCategoriesException() {
		 categories=new ArrayList<>();
		 Mockito.when(categoryRepository.findAll()).thenReturn(categories);
		 CategoryResponse result= categoryServiceImpl.getAllCategories();
		 assertEquals(new Integer(200) , result.getStatusCode());
	 }
}
