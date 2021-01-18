package org.mmmorritti.book.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Book {
    @Id
    private Long bookId;
    private String title;
    private String author;
    private String genre;
    private int year;
    private String publishingHouse;



}
