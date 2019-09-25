
package com.example.booksapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("bookAuthor")
    @Expose
    private String bookAuthor;
    @SerializedName("bookDescription")
    @Expose
    private String bookDescription;
    @SerializedName("bookID")
    @Expose
    private Integer bookID;
    @SerializedName("bookImage")
    @Expose
    private String bookImage;
    @SerializedName("bookName")
    @Expose
    private String bookName;

    public Book(String bookAuthor, String bookDescription, Integer bookID, String bookImage, String bookName) {
        this.bookAuthor = bookAuthor;
        this.bookDescription = bookDescription;
        this.bookID = bookID;
        this.bookImage = bookImage;
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

}
