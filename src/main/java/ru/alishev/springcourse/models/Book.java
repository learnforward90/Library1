package ru.alishev.springcourse.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {

    private int bookId;

    @NotEmpty
    @Size(min = 2, max = 100, message = "Name between 0 and 100 characters")
    private String bookName;

    @NotEmpty
    @Size(min = 2, max = 100, message = "Author between 0 and 100 characters")
    private String bookAuthor;

    private int bookYear;

    public Book() {

    }

    public Book(int bookId, String bookName, String bookAuthor, int bookYear) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
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

    public String getBookAuthor() {
        return bookAuthor;
    }
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookYear() {
        return bookYear;
    }
    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }

    @Override
    public String toString() {
        return "bookId=" + bookId + ", bookName=" + bookName  + ", bookAuthor=" + bookAuthor + ", bookYear=" + bookYear;
    }
}
