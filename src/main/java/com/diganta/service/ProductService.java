package com.diganta.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.diganta.entity.Category;
import com.diganta.entity.Product;
import com.diganta.exception.ProductAlreadyExists;
import com.diganta.repository.ICategoryRepository;
import com.diganta.repository.IProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

	private final IProductRepository productRepo;
	private final ICategoryRepository categoryRepo;

	@Override
	public Page<Product> getAllProducts(Pageable pageable) {
		return productRepo.findAll(pageable);
	}

	@Override
	public Product createProduct(Product product) {
		Optional<Product> prod = productRepo.findByProductName(product.getProductName());
		if (prod.isPresent()) {
			throw new ProductAlreadyExists("Product already exists.");
		}
		Category category = categoryRepo.findById(product.getCategory().getCategoryId())
				.orElseThrow(() -> new IllegalArgumentException("Category not found"));
		product.setCategory(category);
		return productRepo.save(product);
	}

	@Override
	public Product updateProduct(int pId, Product product) {

		Product p = getProductById(pId);
		if (p != null) {
			p.setProductName(product.getProductName());
			p.setProductPrice(product.getProductPrice());
			return productRepo.save(p);
		}
		return null;
	}

	@Override
	public Product getProductById(int pId) {
		return productRepo.findById(pId).orElseThrow(() -> new IllegalArgumentException("Product not found"));
	}

	@Override
	public void deleteProduct(int pId) {
		Product p = getProductById(pId);
		if (p != null) {
			productRepo.delete(p);
		}
	}
}