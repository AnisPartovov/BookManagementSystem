package com.bharathkalyans.librarymanagementsystem.model;

public class Author {

    private String authorName;

    public Author() {
    }

    public Author(String name) {
        this.authorName = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorName='" + authorName + '\'' +
                '}';
    }
}
