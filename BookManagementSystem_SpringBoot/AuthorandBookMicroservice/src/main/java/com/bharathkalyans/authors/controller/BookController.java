package com.bharathkalyans.authors.controller;


import com.bharathkalyans.authors.dto.BookDto;
import com.bharathkalyans.authors.entity.Author;
import com.bharathkalyans.authors.entity.Book;
import com.bharathkalyans.authors.service.AuthorService;
import com.bharathkalyans.authors.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getBook() {
        List<BookDto> books = bookService.getAllBooks();

        if (books != null && books.size() > 0) {
            return new ResponseEntity<>(books, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<BookDto> getBookById(@PathVariable int bookId) {
        BookDto book = bookService.getBookById(bookId);
        if (book != null) return new ResponseEntity<>(book, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book) {
        System.out.println("Author Name :: " + book.getAuthorName());
        bookService.insertBook(book);
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Object> deleteBookById(@PathVariable Integer bookId) {
        try {
            bookService.delete(bookId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Book not Found!", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Object> updateBook(@RequestBody BookDto bookDto, @PathVariable Integer bookId) {
        try {
            Book book = new Book();
            book.setBookCode(bookDto.getBookId());
            book.setBookName(bookDto.getBookName());
            book.setAuthorName(bookDto.getAuthorName());
            book.setDate(bookDto.getDate());
            bookService.update(book, bookId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Book Not Found!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/authors")
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    //Testing
    @RequestMapping("/names")
    public List<String> getNames() {
        return List.of("Bharath", "Kalyan", "Nagarro");
    }
}
