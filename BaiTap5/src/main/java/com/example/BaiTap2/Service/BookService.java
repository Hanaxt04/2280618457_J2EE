package com.example.BaiTap2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BaiTap2.Model.Book;
import com.example.BaiTap2.repository.BookRepository;
import com.example.BaiTap2.repository.CategoryRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}