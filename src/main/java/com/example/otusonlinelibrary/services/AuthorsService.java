package com.example.otusonlinelibrary.services;

import com.example.otusonlinelibrary.dtos.AuthorDto;
import com.example.otusonlinelibrary.repositories.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorsService {
    private final AuthorsRepository authorsRepository;

    @Autowired
    public AuthorsService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    public Optional<List<AuthorDto>> findAllAuthors() {
        return authorsRepository.findAllAuthors();
    }

    public Optional<AuthorDto> findAuthorByFullName(String fullName) {
        return authorsRepository.findAuthorWithFullName(fullName);
    }

    public Optional<List<AuthorDto>> findAllAuthorsWithPartialName(String partialName) {
        return authorsRepository.findAllAuthorsWithPartialName(partialName);
    }

    public void addNewAuthor(String authorName) {
        authorsRepository.addNewAuthor(authorName);
    }
}
