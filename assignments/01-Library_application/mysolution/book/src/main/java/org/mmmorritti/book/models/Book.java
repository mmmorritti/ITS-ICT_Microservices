package org.mmmorritti.book.models;

import org.springframework.data.annotation.Id;

public class Book {
    @Id
    private Long bookId;
    private String title;
    private String author;
    private String genre;
    private int year;
    private String publishingHouse;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    @Override
    public String toString(){
        String data = this.title + " "
                + this.author + " "
                + this.genre + " "
                + this.year + " "
                + this.publishingHouse;
        return data;
    }


}
