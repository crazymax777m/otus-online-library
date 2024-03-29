package com.example.otusonlinelibrary.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table("authors")
@Setter
@Getter
public class Author {
    @Id
    private Long id;

    private String fullName;

    @MappedCollection(idColumn = "author_id")
    private Set<Book> books;
    @PersistenceCreator
    public Author(Long id, String fullName, Set<Book> books) {
        this.id = id;
        this.fullName = fullName;
        this.books = books;
    }
}
