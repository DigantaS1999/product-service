package com.diganta.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diganta.entity.Category;
import com.diganta.service.ICategoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	private final ICategoryService categoryService;

	@GetMapping
	public ResponseEntity<?> getCategoryByPage(@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "10") Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(categoryService.getAllCategories(pageable));
	}

	@PostMapping
	public ResponseEntity<?> addCategory(@RequestBody Category category) {
		return new ResponseEntity<>(categoryService.createCategory(category), HttpStatus.CREATED);
	}

	@GetMapping("{cId}")
	public ResponseEntity<?> getCategoryById(@PathVariable("cId") Integer cId) {
		Category category = categoryService.getCategoryById(cId);
		if (category == null) {
			return new ResponseEntity<>("Category not available.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

	@PutMapping("{cId}")
	public ResponseEntity<?> updateCategoryById(@PathVariable("cId") Integer cId, @RequestBody Category cat) {
		Category category = categoryService.getCategoryById(cId);
		if (category == null) {
			return new ResponseEntity<>("Category not available.", HttpStatus.NOT_FOUND);
		}
		Category updatedCategory = categoryService.updateCategory(cId, cat);
		return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
	}

	@DeleteMapping("{cId}")
	public ResponseEntity<?> deleteCategoryById(@PathVariable("cId") Integer cId) {
		Category category = categoryService.getCategoryById(cId);
		if (category == null) {
			return new ResponseEntity<>("Category not available.", HttpStatus.NOT_FOUND);
		}
		categoryService.deleteCategoryById(cId);
		return new ResponseEntity<>("Category deleted successfully.", HttpStatus.OK);
	}

}
