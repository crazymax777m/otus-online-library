package com.example.otusonlinelibrary.repositories;

import com.example.otusonlinelibrary.dtos.AuthorDto;
import com.example.otusonlinelibrary.entities.Author;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorsRepository extends ListCrudRepository<Author, Long> {
    @Query(
            "select full_name from authors " +
                    " order by full_name"
    )
    Optional<List<AuthorDto>> findAllAuthors();

    @Query(
            "select full_name from authors " +
                    " where full_name = :fullName"
    )
    Optional<AuthorDto> findAuthorWithFullName(String fullName);

    @Query(
            "select full_name from authors " +
                    "where full_name like concat(:partialName, '%') " +
                    "order by full_name"
    )
    Optional<List<AuthorDto>> findAllAuthorsWithPartialName(String partialName);

    @Modifying
    @Query(
            "insert into authors (full_name) " +
                    "values (:authorName)"
    )
    void addNewAuthor(String authorName);
}
