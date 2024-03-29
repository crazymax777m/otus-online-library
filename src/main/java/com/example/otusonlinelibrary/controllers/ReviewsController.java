package com.example.otusonlinelibrary.controllers;

import com.example.otusonlinelibrary.exceptions.BadArgumentException;
import com.example.otusonlinelibrary.services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewsController {
    private final ReviewsService reviewsService;

    @Autowired
    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @PostMapping
    public void addReview(
            @RequestParam String bookTitle,
            @RequestParam String authorName,
            @RequestParam String text,
            @RequestParam Integer rating
            ) {
        if (rating < 0 || rating > 10) {
            throw new BadArgumentException("Оценка должна находиться в диапазоне от 0 до 10");
        }

        reviewsService.addReview(bookTitle, authorName, text, rating);
    }

}
