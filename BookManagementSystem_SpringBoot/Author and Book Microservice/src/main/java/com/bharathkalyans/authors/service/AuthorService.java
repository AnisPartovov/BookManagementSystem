package com.bharathkalyans.authors.service;

import com.bharathkalyans.authors.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    public List<Author> getAuthors();
}
