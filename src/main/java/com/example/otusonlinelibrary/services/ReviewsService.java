package com.example.otusonlinelibrary.services;

import com.example.otusonlinelibrary.repositories.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReviewsService {
    private final ReviewsRepository reviewsRepository;

    @Autowired
    public ReviewsService(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    public void addReview(String bookTitle, String authorName, String text, Integer rating) {
        LocalDate reviewDate = LocalDate.now();
        reviewsRepository.addReview(bookTitle, authorName, text, rating, reviewDate);
    }
}
