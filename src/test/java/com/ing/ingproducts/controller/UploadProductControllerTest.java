package com.ing.ingproducts.controller;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import com.ing.ingproducts.dto.UploadResponse;
import com.ing.ingproducts.service.UploadProductService;

@RunWith(MockitoJUnitRunner.class)
public class UploadProductControllerTest {
	@Mock
    UploadProductService uploadProductService;
	@InjectMocks
    UploadProductController uploadProductController;
	
	MockMultipartFile firstFile;
	UploadResponse uploadResponse=new UploadResponse();
	@Before
	public void setUp() throws FileNotFoundException, IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("Productdetails.xlsx").getFile());
		firstFile = new MockMultipartFile("data", new FileInputStream(file));
		uploadResponse.setStatusCode(200);
		uploadResponse.setMessage("success");
	}
	@Test
	public void testUpload() {
		 ResponseEntity<UploadResponse> response=uploadProductController.uploadProducts(firstFile);
		 assertEquals("success", response.getBody().getMessage());
	}

}
