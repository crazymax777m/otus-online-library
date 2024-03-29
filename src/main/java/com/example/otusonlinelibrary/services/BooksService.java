package com.example.otusonlinelibrary.services;

import com.example.otusonlinelibrary.dtos.DetailedBookDto;
import com.example.otusonlinelibrary.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Optional<List<DetailedBookDto>> findAllDetailedBooks(Integer page, Integer size) {
        Integer offset = page * size;
        return booksRepository.findAllDetailedBooks(offset, size);
    }

    public Long countAllBooks() {
        return booksRepository.countAllBooks();
    }

    public Optional<List<DetailedBookDto>> findAllDetailedBooksWithGenreName(String genreName,
                                                                             Integer page,
                                                                             Integer size) {
        Integer offset = page * size;
        return booksRepository.findAllDetailedBooksWithGenreName(genreName, offset, size);
    }

    public Optional<List<DetailedBookDto>> findAllDetailedBooksWithBookTitle(String bookTitle,
                                                                             Integer page,
                                                                             Integer size) {
        Integer offset = page * size;
        return booksRepository.findAllDetailedBooksWithBookTitle(bookTitle, offset, size);
    }

    public Optional<List<DetailedBookDto>> findAllDetailedBooksWithAuthorName(String authorName,
                                                                             Integer page,
                                                                             Integer size) {
        Integer offset = page * size;
        return booksRepository.findAllDetailedBooksWithAuthorName(authorName, offset, size);
    }

    public Optional<List<DetailedBookDto>> findAllDetailedBooksWithAuthorNameAndGenreName(String authorName, String genreName,
                                                                              Integer page,
                                                                              Integer size) {
        Integer offset = page * size;
        return booksRepository.findAllDetailedBooksWithAuthorNameAndGenreName(authorName, genreName, offset, size);
    }

    public Optional<List<DetailedBookDto>> findAllDetailedBooksWithRatingMoreThanDesired(Integer rating,
                                                                                          Integer page,
                                                                                          Integer size) {
        Integer offset = page * size;
        return booksRepository.findAllDetailedBooksWithRatingMoreThanDesired(rating, offset, size);
    }

    public Optional<List<DetailedBookDto>> findAllDetailedBooksWithPriceLessThanDesired(Double price,
                                                                                         Integer page,
                                                                                         Integer size) {
        Integer offset = page * size;
        return booksRepository.findAllDetailedBooksWithPriceLessThanDesired(price, offset, size);
    }

    public void addNewBook(String bookTitle,
                           String authorName,
                           String genreName,
                           String description,
                           Integer yearOfPublication,
                           Integer pagesCount,
                           Double price) {
        booksRepository.addNewBook(bookTitle, authorName, genreName, description, yearOfPublication, pagesCount, price);
    }

    public Optional<List<DetailedBookDto>> findTop5DetailedBooksLastMonth() {
        return booksRepository.findTop5DetailedBooksLastMonth();
    }

}
