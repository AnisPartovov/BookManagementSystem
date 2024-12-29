package com.bharathkalyans.librarymanagementsystem.service;


import com.bharathkalyans.librarymanagementsystem.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    public List<Book> getBooks();

    public void addBook(Book book);

    public void updateBook(Book book, int id);

    public void deleteBook(int id);

    public Book getBookById(int id);

}
