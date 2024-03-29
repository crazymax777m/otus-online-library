package com.example.otusonlinelibrary.controllers;

import com.example.otusonlinelibrary.dtos.AuthorDto;
import com.example.otusonlinelibrary.exceptions.ResourceNotFoundException;
import com.example.otusonlinelibrary.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorsController {
    private final AuthorsService authorsService;

    @Autowired
    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @GetMapping
    public List<AuthorDto> findAllAuthors() {
        return authorsService.findAllAuthors()
                .orElseThrow(() -> new ResourceNotFoundException("Сейчас в библиотеке нет активных авторов"));
    }

    @GetMapping("/search")
    public AuthorDto findAuthorByFullName(@RequestParam String fullName) {
        return authorsService.findAuthorByFullName(fullName)
                .orElseThrow(() -> new ResourceNotFoundException("По Вашему запросу ничего не было найдено"));
    }

    @GetMapping("/search/partial")
    public List<AuthorDto> findAllAuthorsWithPartialName(@RequestParam String partialName) {
        return authorsService.findAllAuthorsWithPartialName(partialName)
                .orElseThrow(() -> new ResourceNotFoundException("По Вашему запросу ничего не было найдено"));
    }

    @PostMapping
    public void addNewAuthor(@RequestParam String authorName) {
        authorsService.addNewAuthor(authorName);
    }
}
