package com.bharathkalyans.librarymanagementsystem.controller;


import com.bharathkalyans.librarymanagementsystem.entity.Users;
import com.bharathkalyans.librarymanagementsystem.model.Author;
import com.bharathkalyans.librarymanagementsystem.model.Book;
import com.bharathkalyans.librarymanagementsystem.service.AuthorService;
import com.bharathkalyans.librarymanagementsystem.service.BookService;
import com.bharathkalyans.librarymanagementsystem.service.impl.LoginServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MyController {


    String currentUsername = "";
    @Autowired
    LoginServiceImpl loginService;

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    /*LOGIN HANDLER*/

    @RequestMapping("/index")
    public String loadHomePage() {
        return "index";
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "index";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        Users user = loginService.validateUser(username);

        if (user != null)
            System.out.println(user.getUsername() + " found in the database!");
        if (user != null && password.equals(user.getPassword())) {
            this.currentUsername = user.getUsername();
            model.addAttribute("user", user);
            return "redirect:/books";
        } else {
            model.addAttribute("wrongUser", true);
            return "index";
        }
    }

    /*HOME PAGE HANDLER*/

    @GetMapping("/books")
    public String login(Model model) {

        List<Book> bookList = bookService.getBooks();
        System.out.println("*************** BOOKS ******************");
        for (Book book : bookList) {
            System.out.println(book);
        }
        model.addAttribute("username", currentUsername);
        model.addAttribute("books", bookList);
        return "books_page";
    }


    @GetMapping(value = "/books/new")
    public String addBookForm(Model model) {
        Book book = new Book();
        List<Author> authorList = authorService.getAuthors();
        System.out.println("************ AUTHORS ****************");
        for (Author author : authorList) {
            System.out.println(author);
        }
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("book", book);
        model.addAttribute("authors", authorList);
        return "add_book";
    }

    @PostMapping("/books")
    public String addBook(@ModelAttribute("book") Book book) {
        book.setDate(String.valueOf(LocalDate.now()));
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{id}")
    public String editBook(@PathVariable int id, Model model) {
        Book demoBook = new Book(100, "Angels and Demons", "Dan Brown", String.valueOf(java.time.LocalDate.now()));
        List<Author> authorList = authorService.getAuthors();
        Book myBook = bookService.getBookById(id);
        model.addAttribute("authors", authorList);
        model.addAttribute("book", myBook);
        return "edit_book";
    }


    @PostMapping("/books/{id}")
    public String updateBook(@PathVariable int id, @ModelAttribute("book") Book book, Model model) {
        Book existingBook = bookService.getBookById(id);
        existingBook.setBookName(book.getBookName());
        existingBook.setAuthorName(book.getAuthorName());
        existingBook.setDate(String.valueOf(LocalDate.now()));

        bookService.updateBook(existingBook, id);
        return "redirect:/books";
    }


    /*LOGOUT HANDLER*/

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:/login?logout";
    }

    @GetMapping(value = "/books/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

}
