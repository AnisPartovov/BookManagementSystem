package com.bharathkalyans.librarymanagementsystem.model;

public class Book {

    int bookId;

    String bookName;

    String authorName;

    String date;

    public Book() {
    }

    public Book(String bookName, String authorName, String currentDate) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.date = currentDate;
    }

    public Book(int bookId, String bookName, String authorName, String currentDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.date = currentDate;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
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

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", currentDate='" + date + '\'' +
                '}';
    }
}
