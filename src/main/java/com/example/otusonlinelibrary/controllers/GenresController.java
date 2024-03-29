package com.example.otusonlinelibrary.controllers;

import com.example.otusonlinelibrary.dtos.GenreDto;
import com.example.otusonlinelibrary.exceptions.ResourceNotFoundException;
import com.example.otusonlinelibrary.services.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/genres")
public class GenresController {

    private final GenresService genresService;

    @Autowired
    public GenresController(GenresService genresService) {
        this.genresService = genresService;
    }

    @GetMapping
    public List<GenreDto> findAllGenres() {
        return genresService.findAllGenres()
                .orElseThrow(() -> new ResourceNotFoundException("Не найдено ни одного жанра"));
    }

    @GetMapping("/search")
    public GenreDto findGenreWithGenreName(@RequestParam String genreName) {
        return genresService.findGenreWithGenreName(genreName)
                .orElseThrow(() -> new ResourceNotFoundException("По Вашему запросу ничего не было найдено"));
    }

    @GetMapping("/search/partial")
    public List<GenreDto> findAllGenresWithPartialName(@RequestParam String partialName) {
        return genresService.findAllGenresWithPartialName(partialName)
                .orElseThrow(() -> new ResourceNotFoundException("По Вашему запросу ничего не было найдено"));
    }
}
