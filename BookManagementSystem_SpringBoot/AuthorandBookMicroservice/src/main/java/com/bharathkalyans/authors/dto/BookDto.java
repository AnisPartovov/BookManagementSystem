package com.bharathkalyans.authors.dto;

public class BookDto {

    private int bookId;

    private String bookName;

    private String authorName;

    private String date;

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
        return "BookDto{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", currentDate='" + date + '\'' +
                '}';
    }
}

//https://stackoverflow.com/questions/39397147/difference-between-entity-and-dto#:~:text=Difference%20between%20DTO%20%26%20Entity%3A%20Entity%20is%20class,Dto%20is%20class%20mapped%20to%20%22view%22%20layer%20mostly.