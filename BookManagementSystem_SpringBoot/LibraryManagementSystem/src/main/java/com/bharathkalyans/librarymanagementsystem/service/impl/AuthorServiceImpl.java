package com.bharathkalyans.librarymanagementsystem.service.impl;

import com.bharathkalyans.librarymanagementsystem.model.Author;
import com.bharathkalyans.librarymanagementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final String url = "http://localhost:8999/authors";
    private RestTemplate restTemplate;

    @Autowired
    public AuthorServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public List<Author> getAuthors() {
        ResponseEntity<Author[]> responseEntity = restTemplate.getForEntity(url, Author[].class);
        return List.of(responseEntity.getBody());
    }
}
