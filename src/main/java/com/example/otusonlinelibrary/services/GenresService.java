package com.example.otusonlinelibrary.services;

import com.example.otusonlinelibrary.dtos.GenreDto;
import com.example.otusonlinelibrary.repositories.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenresService {
    private final GenresRepository genresRepository;

    @Autowired
    public GenresService(GenresRepository genresRepository) {
        this.genresRepository = genresRepository;
    }

    public Optional<List<GenreDto>> findAllGenres() {
        return genresRepository.findAllGenres();
    }

    public Optional<GenreDto> findGenreWithGenreName(String genreName) {
        return genresRepository.findGenreWithGenreName(genreName);
    }

    public Optional<List<GenreDto>> findAllGenresWithPartialName(String partialName) {
        return genresRepository.findAllGenresWithPartialName(partialName);
    }
}
