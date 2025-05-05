package com.diganta.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.diganta.entity.Category;

public interface ICategoryService {

	Category createCategory(Category category);

	Category updateCategory(int cId, Category category);

	void deleteCategoryById(int cId);

	Category getCategoryById(int cId);

	Page<Category> getAllCategories(Pageable pageable);
}
