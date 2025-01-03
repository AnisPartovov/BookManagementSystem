package com.bharathkalyans.authors.dto;

public class AuthorDto {
    private String name;

    public AuthorDto() {
    }

    public AuthorDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
