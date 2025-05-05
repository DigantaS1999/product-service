package com.diganta.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.diganta.entity.Product;

public interface IProductService {

	Product createProduct(Product product);

	Product updateProduct(int pId, Product product);

	Product getProductById(int pId);

	void deleteProduct(int pId);

	Page<Product> getAllProducts(Pageable pageable);
}
