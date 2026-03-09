package com.example.BaiTap2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import com.example.BaiTap2.Model.Book;
import com.example.BaiTap2.Model.Category;
import com.example.BaiTap2.Service.BookService;
import com.example.BaiTap2.Service.CategoryService;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listBooks(Model model) {
        List<Book> bookList = bookService.getAllBooks();
        model.addAttribute("books", bookList);
        return "index";
    }

@GetMapping("/add")
public String showAddForm(Model model) {
    model.addAttribute("book", new Book());
    model.addAttribute("categories", categoryService.getAllCategories());
    return "add-book";
}

@PostMapping("/save")
public String saveBook(@ModelAttribute("book") Book book,
                       @RequestParam("imageFile") MultipartFile file) {

    if (!file.isEmpty()) {
        String fileName = file.getOriginalFilename();
        book.setImage(fileName);

        try {
            file.transferTo(new File("src/main/resources/static/images/" + fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    bookService.saveBook(book);
    return "redirect:/books";
}

    @GetMapping("/edit/{id}")
public String editBook(@PathVariable int id, Model model) {
    Book book = bookService.getBookById(id);

    if (book.getCategory() == null) {
        book.setCategory(new Category());
    }

    model.addAttribute("book", book);
    model.addAttribute("categories", categoryService.getAllCategories());
    return "add-book";
}

    @PostMapping("/delete/{id}")
public String deleteProduct(@PathVariable("id") Integer id) {
    bookService.deleteBook(id);
    return "redirect:/books";
}
}