package com.diganta.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.diganta.entity.Category;
import com.diganta.repository.ICategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService {

	private final ICategoryRepository categoryRepo;

	@Override
	public Category createCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(int cId, Category category) {
		Category cat = getCategoryById(cId);
		if (cat != null) {
			cat.setCategoryName(category.getCategoryName());
			return categoryRepo.save(cat);
		}
		return null;
	}

	@Override
	public void deleteCategoryById(int cId) {
		Category category = getCategoryById(cId);
		if (category != null) {
			categoryRepo.delete(category);
		}
	}

	@Override
	public Category getCategoryById(int cId) {
		return categoryRepo.findById(cId).orElse(null);
	}

	@Override
	public Page<Category> getAllCategories(Pageable pageable) {
		return categoryRepo.findAll(pageable);
	}
}