package com.diganta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diganta.entity.Category;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}
