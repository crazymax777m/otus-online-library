package com.example.otusonlinelibrary.controllers;

import com.example.otusonlinelibrary.dtos.DetailedBookDto;
import com.example.otusonlinelibrary.dtos.PageDto;
import com.example.otusonlinelibrary.exceptions.BadArgumentException;
import com.example.otusonlinelibrary.exceptions.ResourceNotFoundException;
import com.example.otusonlinelibrary.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController {
    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    private Integer calculateTotalPages(Integer pageSize, Long totalElements) {
        return (int) Math.ceil((double) totalElements / pageSize);
    }

    @GetMapping()
    public PageDto<DetailedBookDto> findAllDetailedBooks(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "3") Integer size) {

        List<DetailedBookDto> books = booksService.findAllDetailedBooks(page, size)
                .orElseThrow(() -> new ResourceNotFoundException("В библиотеке нет ни одной книги"));

        Long totalBooks = booksService.countAllBooks();

        return new PageDto<>(books, page, size, calculateTotalPages(size, totalBooks), totalBooks);
    }

    @GetMapping("/search/genre")
    public PageDto<DetailedBookDto> findAllDetailedBooksWithGenreName(
            @RequestParam String genreName,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "3") Integer size) {

        List<DetailedBookDto> books = booksService.findAllDetailedBooksWithGenreName(genreName, page, size)
                .orElseThrow(() -> new ResourceNotFoundException("По Вашему запросу ничего не было найдено"));

        Long totalBooks = booksService.countAllBooks();

        return new PageDto<>(books, page, size, calculateTotalPages(size, totalBooks), totalBooks);
    }

    @GetMapping("/search/title")
    public PageDto<DetailedBookDto> findAllDetailedBooksWithBookTitle(
            @RequestParam String bookTitle,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "3") Integer size) {

        List<DetailedBookDto> books = booksService.findAllDetailedBooksWithBookTitle(bookTitle, page, size)
                .orElseThrow(() -> new ResourceNotFoundException("По Вашему запросу ничего не было найдено"));

        Long totalBooks = booksService.countAllBooks();

        return new PageDto<>(books, page, size, calculateTotalPages(size, totalBooks), totalBooks);
    }

    @GetMapping("/search/author")
    public PageDto<DetailedBookDto> findAllDetailedBooksWithAuthorName(
            @RequestParam String authorName,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "3") Integer size) {

        List<DetailedBookDto> books = booksService.findAllDetailedBooksWithAuthorName(authorName, page, size)
                .orElseThrow(() -> new ResourceNotFoundException("По Вашему запросу ничего не было найдено"));

        Long totalBooks = booksService.countAllBooks();

        return new PageDto<>(books, page, size, calculateTotalPages(size, totalBooks), totalBooks);
    }

    @GetMapping("/search/author/genre")
    public PageDto<DetailedBookDto> findAllDetailedBooksWithAuthorNameAndGenreName(
            @RequestParam String authorName,
            @RequestParam String genreName,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "3") Integer size) {

        List<DetailedBookDto> books = booksService.findAllDetailedBooksWithAuthorNameAndGenreName(authorName, genreName, page, size)
                .orElseThrow(() -> new ResourceNotFoundException("По Вашему запросу ничего не было найдено"));

        Long totalBooks = booksService.countAllBooks();

        return new PageDto<>(books, page, size, calculateTotalPages(size, totalBooks), totalBooks);
    }

    @GetMapping("/search/rating")
    public PageDto<DetailedBookDto> findAllDetailedBooksWithRatingMoreThanDesired(
            @RequestParam Integer rating,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "3") Integer size) {

        List<DetailedBookDto> books = booksService.findAllDetailedBooksWithRatingMoreThanDesired(rating, page, size)
                .orElseThrow(() -> new ResourceNotFoundException("По Вашему запросу ничего не было найдено"));

        Long totalBooks = booksService.countAllBooks();

        return new PageDto<>(books, page, size, calculateTotalPages(size, totalBooks), totalBooks);
    }

    @GetMapping("/search/price")
    public PageDto<DetailedBookDto> findAllDetailedBooksWithPriceLessThanDesired(
            @RequestParam Double price,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "3") Integer size) {

        List<DetailedBookDto> books = booksService.findAllDetailedBooksWithPriceLessThanDesired(price, page, size)
                .orElseThrow(() -> new ResourceNotFoundException("По Вашему запросу ничего не было найдено"));

        Long totalBooks = booksService.countAllBooks();

        return new PageDto<>(books, page, size, calculateTotalPages(size, totalBooks), totalBooks);
    }

    @PostMapping
    public void addNewBook(@RequestParam String bookTitle,
                           @RequestParam String authorName,
                           @RequestParam String genreName,
                           @RequestParam String description,
                           @RequestParam Integer yearOfPublication,
                           @RequestParam Integer pagesCount,
                           @RequestParam Double price) {
        if (price < 0) {
            throw new BadArgumentException("Цена не может быть отрицательной");
        }

        if (yearOfPublication < 1 || yearOfPublication > LocalDate.now().getYear()) {
            throw new BadArgumentException("Год не может быть меньше 1 и больше текущего");
        }

        if (pagesCount < 1) {
            throw new BadArgumentException("Количество страниц не может быть меньше 1");
        }

        try {
            booksService.addNewBook(bookTitle, authorName, genreName, description, yearOfPublication, pagesCount, price);
        } catch (Exception e) {
            throw new BadArgumentException("Такая книга уже существует");
        }

    }

    @GetMapping("/top")
    public List<DetailedBookDto> findTop5DetailedBooksLastMonth() {
        return booksService.findTop5DetailedBooksLastMonth()
                .orElseThrow(() -> new ResourceNotFoundException("По Вашему запросу ничего не было найдено"));
    }

}
