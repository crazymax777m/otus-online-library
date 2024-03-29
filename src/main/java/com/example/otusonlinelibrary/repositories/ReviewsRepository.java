package com.example.otusonlinelibrary.repositories;

import com.example.otusonlinelibrary.entities.Review;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReviewsRepository extends ListCrudRepository<Review, Long> {

    @Modifying
    @Query(
        "insert into reviews (book_id, author_name, text, rating, review_date) " +
                "values ((select b.id from books b where b.title = :bookTitle), :authorName, :text, :rating, :reviewDate)"
    )
    void addReview(String bookTitle, String authorName, String text, Integer rating, LocalDate reviewDate);

}
