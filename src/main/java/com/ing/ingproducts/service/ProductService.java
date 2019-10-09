package com.ing.ingproducts.service;

import com.ing.ingproducts.dto.ProductDescriptionDto;
import com.ing.ingproducts.dto.ProductResponse;

public interface ProductService {

	public ProductResponse getProductsByCategory(Long categoryId);

	public ProductDescriptionDto getProductDetails(Long productId);

}
