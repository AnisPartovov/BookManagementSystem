package com.bharathkalyans.authors.service;


import com.bharathkalyans.authors.dto.BookDto;
import com.bharathkalyans.authors.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    public List<BookDto> getAllBooks();

    public void delete(int id) throws Exception;

    public void update(Book book, int id) throws Exception;

    public void insertBook(Book book);

    public BookDto getBookById(int bookId);

}
