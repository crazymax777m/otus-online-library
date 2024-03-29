package com.example.otusonlinelibrary.repositories;

import com.example.otusonlinelibrary.dtos.AuthorDto;
import com.example.otusonlinelibrary.dtos.GenreDto;
import com.example.otusonlinelibrary.entities.Genre;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenresRepository extends ListCrudRepository<Genre, Long> {

    @Query(
            "select distinct genre_name from genres " +
                    " order by genre_name"
    )
    Optional<List<GenreDto>> findAllGenres();

    @Query(
            "select genre_name from genres " +
                    "where genre_name = :genreName"
    )
    Optional<GenreDto> findGenreWithGenreName(String genreName);

    @Query(
            "select genre_name from genres " +
                    "where genre_name like concat(:partialName, '%') " +
                    "order by genre_name"
    )
    Optional<List<GenreDto>> findAllGenresWithPartialName(String partialName);

}
