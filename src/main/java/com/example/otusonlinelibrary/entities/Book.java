package com.example.otusonlinelibrary.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("books")
@Getter
@Setter
public class Book {
    @Id
    private Long id;

    private String title;

    private Long authorId;

    @MappedCollection(idColumn = "book_id")
    private BookDetails bookDetails;

    @MappedCollection(idColumn = "book_id")
    private Genre genre;

    @MappedCollection(idColumn = "book_id")
    private List<Review> reviews;

    @PersistenceCreator
    public Book(Long id, String title, Long authorId, BookDetails bookDetails, Genre genre, List<Review> reviews) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.bookDetails = bookDetails;
        this.genre = genre;
        this.reviews = reviews;
    }
}
