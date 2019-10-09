package com.ing.ingproducts.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ing.ingproducts.dto.CategoryDetails;
import com.ing.ingproducts.dto.CategoryResponse;
import com.ing.ingproducts.entity.Category;
import com.ing.ingproducts.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
    private static Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	CategoryRepository categoryRepository;

	/**
	 * @return CategoryResponse which includes all the categories along with their Ids
	 * @since  2019-10-03
	 */
	@Override
	public CategoryResponse getAllCategories() {
		logger.info("getAllCategories() in  CategoryServiceImpl started");
		CategoryResponse response =new CategoryResponse();
		response.setStatusCode(200);
		response.setStatusMessage("Success");
		List<Category>categories= categoryRepository.findAll();
		List<CategoryDetails> categoryList=new ArrayList<>();
		categories.forEach(category->categoryList.add(new CategoryDetails(category.getCategoryId(), category.getCategoryName())));
		response.setCategories(categoryList);
		logger.info("getAllCategories() in  CategoryServiceImpl ended");
		return response;
	}

}
