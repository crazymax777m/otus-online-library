package com.example.otusonlinelibrary.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

@Table("genres")
@Setter
@Getter
public class Genre {
    @Id
    private Long id;

    private String genreName;

    private Long bookId;

    @PersistenceCreator
    public Genre(Long id, String genreName, Long bookId) {
        this.id = id;
        this.genreName = genreName;
        this.bookId = bookId;
    }
}
