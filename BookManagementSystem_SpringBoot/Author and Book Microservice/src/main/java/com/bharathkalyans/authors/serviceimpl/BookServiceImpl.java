package com.bharathkalyans.authors.serviceimpl;

import com.bharathkalyans.authors.dao.BookRepository;
import com.bharathkalyans.authors.dto.BookDto;
import com.bharathkalyans.authors.entity.Book;
import com.bharathkalyans.authors.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BookServiceImpl implements BookService {


    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> booksFound = (List<Book>) bookRepository.findAll();
        List<BookDto> booksList = new ArrayList<>();

        for (Book bookEntity : booksFound) {
            BookDto bookDto = new BookDto();
            bookDto.setBookId(bookEntity.getBookCode());
            bookDto.setAuthorName(bookEntity.getAuthorName());
            bookDto.setBookName(bookEntity.getBookName());
            bookDto.setDate(bookEntity.getDate());
            booksList.add(bookDto);
        }
        return booksList;
    }

    @Override
    public void delete(int id) throws Exception {
        Optional<Book> book = bookRepository.findById(id);
        if (book == null || !book.isPresent()) {
            throw new Exception("Book Not Found!");
        }
        bookRepository.deleteById(id);
    }

    @Override
    public void update(Book book, int id) throws Exception {
        Optional<Book> bookFound = bookRepository.findById(id);
        if (bookFound.isEmpty()) {
            throw new Exception("Book Not Found!");
        }
        book.setBookCode(id);
        bookRepository.save(book);
    }

    @Override
    public void insertBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public BookDto getBookById(int bookId) {
        BookDto bookDto = new BookDto();
        Optional<Book> bookEntity = bookRepository.findById(bookId);
        if (bookEntity.isEmpty()) return null;
        bookDto.setBookId(bookEntity.get().getBookCode());
        bookDto.setAuthorName(bookEntity.get().getAuthorName());
        bookDto.setBookName(bookEntity.get().getBookName());
        bookDto.setDate(bookEntity.get().getDate());

        return bookDto;
    }
}
