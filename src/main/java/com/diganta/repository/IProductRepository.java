package com.diganta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diganta.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

	Optional<Product> findByProductName(String productName);
}