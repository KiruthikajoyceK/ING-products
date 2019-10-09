package com.ing.ingproducts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.ingproducts.dto.ProductDescriptionDto;
import com.ing.ingproducts.dto.ProductDetails;
import com.ing.ingproducts.dto.ProductResponse;
import com.ing.ingproducts.entity.Product;
import com.ing.ingproducts.exception.CommonException;
import com.ing.ingproducts.repository.ProductRepository;
import com.ing.ingproducts.util.IngProductsUtil;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;

	
	public ProductResponse getProductsByCategory(Long categoryId) {
		ProductResponse productResponse=new ProductResponse();
		List<Product> products =productRepository.findProductByCategoryId(categoryId);
		if(products.isEmpty())
		{
			throw new CommonException(IngProductsUtil.PRODUCT_CATEGORY_NOT_FOUND);
		}
		List<ProductDetails> productDetailsList=new ArrayList<>();
		products.stream().forEach(
				product->{
					ProductDetails productDetails=new ProductDetails();
					productDetails.setProductId(product.getProductId());
					productDetails.setProductDescription(product.getProductDescription());
					productDetails.setProductName(product.getProductName());
					productDetailsList.add(productDetails);
				});
		
		productResponse.setProductDetails(productDetailsList);
		productResponse.setStatusMessage(IngProductsUtil.SUCCESS);
			return productResponse;
	}


	public ProductDescriptionDto getProductDetails(Long productId) {
		
		ProductDescriptionDto productDescription=new ProductDescriptionDto();
		
		Optional<Product> product=productRepository.findById(productId);
		if(product.isPresent())
		{
			productDescription.setProductId(product.get().getProductId());
			productDescription.setProductDescription(product.get().getProductDescription());
			productDescription.setProductName(product.get().getProductName());
		}
		else
		{
			throw new CommonException(IngProductsUtil.PRODUCT_NOT_FOUND);
		}
		return productDescription;
	}

}
