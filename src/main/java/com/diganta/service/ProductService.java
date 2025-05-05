package com.diganta.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.diganta.entity.Product;
import com.diganta.repository.IProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

	private final IProductRepository productRepo;

	@Override
	public Page<Product> getAllProducts(Pageable pageable) {
		return productRepo.findAll(pageable);
	}

	@Override
	public Product createProduct(Product product) {
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
		return productRepo.findById(pId).orElse(null);
	}

	@Override
	public void deleteProduct(int pId) {
		Product p = getProductById(pId);
		if (p != null) {
			productRepo.delete(p);
		}
	}
}