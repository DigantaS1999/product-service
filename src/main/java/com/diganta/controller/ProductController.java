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

import com.diganta.entity.Product;
import com.diganta.service.IProductService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final IProductService productService;

	@GetMapping
	public ResponseEntity<?> getProductsByPage(@RequestParam(name = "page", defaultValue = "0") Integer page,
			@RequestParam(name = "size", defaultValue = "10") Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(productService.getAllProducts(pageable));
	}

	@GetMapping("{pId}")
	public ResponseEntity<?> getProductById(@PathVariable("pId") Integer pId) {
		Product product = productService.getProductById(pId);
		if (product == null) {
			return new ResponseEntity<>("Product not available.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
	}

	@PutMapping("{pId}")
	public ResponseEntity<?> updateProduct(@PathVariable("pId") Integer pId, @RequestBody Product product) {
		Product prod = productService.getProductById(pId);
		if (prod == null) {
			return new ResponseEntity<>("Product not available.", HttpStatus.NOT_FOUND);
		}
		Product updateProduct = productService.updateProduct(pId, product);
		return new ResponseEntity<>(updateProduct, HttpStatus.OK);
	}

	@DeleteMapping("{pId}")
	public ResponseEntity<?> deleteProduct(@PathVariable("pId") Integer pId) {
		Product prod = productService.getProductById(pId);
		if (prod == null) {
			return new ResponseEntity<>("Product not available.", HttpStatus.NOT_FOUND);
		}
		productService.deleteProduct(pId);
		return new ResponseEntity<>("Product deleted successfully.", HttpStatus.OK);
	}

}
