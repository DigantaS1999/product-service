package com.diganta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diganta.entity.Category;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

	Optional<Category> findByCategoryName(String categoryName);
}