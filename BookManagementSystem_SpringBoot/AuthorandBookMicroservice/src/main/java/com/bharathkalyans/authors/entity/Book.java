package com.bharathkalyans.authors.entity;

import jakarta.persistence.*;


@Entity
public class Book {

    @Id
    @SequenceGenerator(name = "book_sequence_generator", sequenceName = "book_sequence_generator", allocationSize = 1)
    @GeneratedValue(generator = "book_sequence_generator", strategy = GenerationType.SEQUENCE)
    private int bookId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "modified_book_date")
    private String date;

    public int getBookCode() {
        return bookId;
    }

    public void setBookCode(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
