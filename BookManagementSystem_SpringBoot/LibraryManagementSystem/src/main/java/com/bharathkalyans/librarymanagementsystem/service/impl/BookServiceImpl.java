package com.bharathkalyans.librarymanagementsystem.service.impl;

import com.bharathkalyans.librarymanagementsystem.model.Book;
import com.bharathkalyans.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final String url = "http://localhost:8999/books";

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public List<Book> getBooks() {
        ResponseEntity<Book[]> responseEntity = restTemplate.getForEntity(url, Book[].class);
        return Arrays.asList(responseEntity.getBody());
    }

    @Override
    public void addBook(Book book) {
        restTemplate.postForEntity(url, book, Book.class);
    }

    @Override
    public void updateBook(Book book, int id) {
        restTemplate.put(url + "/" + id, book, Book.class);
    }

    @Override
    public void deleteBook(int id) {
        restTemplate.delete(url + "/" + id);
    }

    @Override
    public Book getBookById(int id) {
        ResponseEntity<Book> responseEntity = restTemplate.getForEntity(url + "/" + id, Book.class);
        return responseEntity.getBody();
    }


}
