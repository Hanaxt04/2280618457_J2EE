package com.example.Buoi2.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Buoi2.Model.Book;
@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private Integer nextId = 1;
    public List<Book> getAllBooks() {
        return books;
    }
    public Optional<Book> getBookbyID (int id){
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }
    public void addBook (Book book){
        book.setId(nextId++);
        books.add(book);
    }
    public void updateBook(Book updatedBook){
        books.stream().filter(book -> book.getId().equals(updatedBook.getId())).findFirst().ifPresent(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
        });
    }
    public void deleteBook(int id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
