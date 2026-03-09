package com.example.BaiTap2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BaiTap2.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}

