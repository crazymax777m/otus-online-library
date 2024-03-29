package com.example.otusonlinelibrary.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

@Table("books_details")
@Setter
@Getter
public class BookDetails {
    @Id
    private Long id;

    private Long bookId;

    private String description;

    private Long yearOfPublication;

    private Long pagesCount;

    private Double price;
    @PersistenceCreator
    public BookDetails(Long id, Long bookId, String description, Long yearOfPublication, Long pagesCount, Double price) {
        this.id = id;
        this.bookId = bookId;
        this.description = description;
        this.yearOfPublication = yearOfPublication;
        this.pagesCount = pagesCount;
        this.price = price;
    }
}
