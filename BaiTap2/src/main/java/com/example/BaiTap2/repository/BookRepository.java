package com.example.BaiTap2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BaiTap2.Model.Book;

    public interface BookRepository extends JpaRepository<Book, Integer> {
        
    }
