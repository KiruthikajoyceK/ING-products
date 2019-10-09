package com.ing.ingproducts.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;
import com.ing.ingproducts.entity.Category;
import com.ing.ingproducts.entity.Product;
import com.ing.ingproducts.repository.CategoryRepository;

@RunWith(MockitoJUnitRunner.class)
public class UploadProductServiceTest {
	@Mock
	CategoryRepository categoryRepository;
	@InjectMocks
	UploadProductServiceImpl uploadProductServiceImpl;
	List<Category> categories=new ArrayList<>();
	MockMultipartFile firstFile;
	@Before
	public void setUp() throws FileNotFoundException, IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("Productdetails.xlsx").getFile());
		firstFile = new MockMultipartFile("data", new FileInputStream(file));
		Category category=new Category();
		category.setCategoryId(1L);
		category.setCategoryName("Category1");
		List<Product> products=new ArrayList<>();
		Product product=new Product();
		product.setProductId(1L);
		product.setProductName("Product1");
		product.setProductDescription("productDescription");
		product.setCategory(category);
		category.setProducts(products);
		categories.add(category);
	}

	@Test
	public void testUpload() {
		 String message=uploadProductServiceImpl.upload(firstFile);
		 assertEquals("success", message);
	}
	
}
