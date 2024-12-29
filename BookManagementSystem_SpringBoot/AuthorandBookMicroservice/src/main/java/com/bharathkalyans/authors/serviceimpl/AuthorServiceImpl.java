package com.bharathkalyans.authors.serviceimpl;

import com.bharathkalyans.authors.dao.AuthorRepository;
import com.bharathkalyans.authors.entity.Author;
import com.bharathkalyans.authors.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAuthors() {
        return (List<Author>) authorRepository.findAll();
    }
}
