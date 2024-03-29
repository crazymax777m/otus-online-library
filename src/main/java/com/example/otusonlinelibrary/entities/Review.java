package com.example.otusonlinelibrary.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("reviews")
@Setter
@Getter
public class Review {
    @Id
    private Long id;

    private Long bookId;

    private String authorName;

    private String text;

    private Integer rating;

    private LocalDate reviewDate;

    @PersistenceCreator
    public Review(Long id, Long bookId, String authorName, String text, Integer rating, LocalDate reviewDate) {
        this.id = id;
        this.bookId = bookId;
        this.authorName = authorName;
        this.text = text;
        this.rating = rating;
        this.reviewDate = reviewDate;
    }
}
