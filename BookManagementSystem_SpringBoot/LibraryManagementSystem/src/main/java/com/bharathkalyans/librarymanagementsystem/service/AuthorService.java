package com.bharathkalyans.librarymanagementsystem.service;

import com.bharathkalyans.librarymanagementsystem.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    public List<Author> getAuthors();

}
