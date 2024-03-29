package com.example.otusonlinelibrary.repositories;

import com.example.otusonlinelibrary.dtos.DetailedBookDto;
import com.example.otusonlinelibrary.entities.Book;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepository extends ListCrudRepository<Book, Long> {

    @Query(
            "select b.title, a.full_name, g.genre_name, bd.description, bd.year_of_publication, bd.pages_count, bd.price, " +
                    "round(coalesce(avg(r.rating), 0), 2) as average_rating " +
                    "from books b " +
                    "left join authors a on a.id = b.author_id " +
                    "left join books_details bd on b.id = bd.book_id " +
                    "left join genres g on b.id = g.book_id " +
                    "left join reviews r on b.id = r.book_id " +
                    "group by b.title, a.full_name, g.genre_name, bd.description, bd.year_of_publication, bd.pages_count, bd.price " +
                    "order by b.title " +
                    "limit :limit " +
                    "offset :offset"
    )
    Optional<List<DetailedBookDto>> findAllDetailedBooks(
            @Param("offset") Integer offset,
            @Param("limit") Integer limit
    );

    @Query(
            "select b.title, a.full_name, g.genre_name, bd.description, bd.year_of_publication, bd.pages_count, bd.price, " +
                    "round(coalesce(avg(r.rating), 0), 2) as average_rating " +
                    "from books b " +
                    "left join authors a on a.id = b.author_id " +
                    "left join books_details bd on b.id = bd.book_id " +
                    "left join genres g on b.id = g.book_id " +
                    "left join reviews r on b.id = r.book_id " +
                    "where g.genre_name = :genreName " +
                    "group by b.title, a.full_name, g.genre_name, bd.description, bd.year_of_publication, bd.pages_count, bd.price " +
                    "order by b.title " +
                    "limit :limit " +
                    "offset :offset"
    )
    Optional<List<DetailedBookDto>> findAllDetailedBooksWithGenreName(String genreName,
                                                                      @Param("offset") Integer offset,
                                                                      @Param("limit") Integer limit);

    @Query(
            "select b.title, a.full_name, g.genre_name, bd.description, bd.year_of_publication, bd.pages_count, bd.price, " +
                    "round(coalesce(avg(r.rating), 0), 2) as average_rating " +
                    "from books b " +
                    "left join authors a on a.id = b.author_id " +
                    "left join books_details bd on b.id = bd.book_id " +
                    "left join genres g on b.id = g.book_id " +
                    "left join reviews r on b.id = r.book_id " +
                    "where b.title = :bookTitle " +
                    "group by b.title, a.full_name, g.genre_name, bd.description, bd.year_of_publication, bd.pages_count, bd.price " +
                    "order by b.title " +
                    "limit :limit " +
                    "offset :offset"
    )
    Optional<List<DetailedBookDto>> findAllDetailedBooksWithBookTitle(String bookTitle,
                                                                      @Param("offset") Integer offset,
                                                                      @Param("limit") Integer limit);

    @Query(
            "select b.title, a.full_name, g.genre_name, bd.description, bd.year_of_publication, bd.pages_count, bd.price, " +
                    "round(coalesce(avg(r.rating), 0), 2) as average_rating " +
                    "from books b " +
                    "left join authors a on a.id = b.author_id " +
                    "left join books_details bd on b.id = bd.book_id " +
                    "left join genres g on b.id = g.book_id " +
                    "left join reviews r on b.id = r.book_id " +
                    "where a.full_name = :authorName " +
                    "group by b.title, a.full_name, g.genre_name, bd.description, bd.year_of_publication, bd.pages_count, bd.price " +
                    "order by b.title " +
                    "limit :limit " +
                    "offset :offset"
    )
    Optional<List<DetailedBookDto>> findAllDetailedBooksWithAuthorName(String authorName,
                                                                       @Param("offset") Integer offset,
                                                                       @Param("limit") Integer limit);

    @Query(
            "select b.title, a.full_name, g.genre_name, bd.description, bd.year_of_publication, bd.pages_count, bd.price, " +
                    "round(coalesce(avg(r.rating), 0), 2) as average_rating " +
                    "from books b " +
                    "left join authors a on a.id = b.author_id " +
                    "left join books_details bd on b.id = bd.book_id " +
                    "left join genres g on b.id = g.book_id " +
                    "left join reviews r on b.id = r.book_id " +
                    "where a.full_name = :authorName and g.genre_name = :genreName " +
                    "group by b.title, a.full_name, g.genre_name, bd.description, bd.year_of_publication, bd.pages_count, bd.price " +
                    "order by b.title " +
                    "limit :limit " +
                    "offset :offset"
    )
    Optional<List<DetailedBookDto>> findAllDetailedBooksWithAuthorNameAndGenreName(String authorName, String genreName,
                                                                                   @Param("offset") Integer offset,
                                                                                   @Param("limit") Integer limit);

    @Query(
            "select b.title, a.full_name, g.genre_name, bd.description, bd.year_of_publication, bd.pages_count, bd.price, " +
                    "round(coalesce(avg(r.rating), 0), 2) as average_rating " +
                    "from books b " +
                    "left join authors a on a.id = b.author_id " +
                    "left join books_details bd on b.id = bd.book_id " +
                    "left join genres g on b.id = g.book_id " +
                    "left join reviews r on b.id = r.book_id " +
                    "where r.rating >= :rating " +
                    "group by b.title, a.full_name, g.genre_name, bd.description, bd.year_of_publication, bd.pages_count, bd.price " +
                    "order by average_rating " +
                    "limit :limit " +
                    "offset :offset"
    )
    Optional<List<DetailedBookDto>> findAllDetailedBooksWithRatingMoreThanDesired(Integer rating,
                                                                                  @Param("offset") Integer offset,
                                                                                  @Param("limit") Integer limit);

    @Query(
            "select b.title, a.full_name, g.genre_name, bd.description, bd.year_of_publication, bd.pages_count, bd.price, " +
                    "round(coalesce(avg(r.rating), 0), 2) as average_rating " +
                    "from books b " +
                    "left join authors a on a.id = b.author_id " +
                    "left join books_details bd on b.id = bd.book_id " +
                    "left join genres g on b.id = g.book_id " +
                    "left join reviews r on b.id = r.book_id " +
                    "where bd.price <= :price " +
                    "group by b.title, a.full_name, g.genre_name, bd.description, bd.year_of_publication, bd.pages_count, bd.price " +
                    "order by bd.price " +
                    "limit :limit " +
                    "offset :offset"
    )
    Optional<List<DetailedBookDto>> findAllDetailedBooksWithPriceLessThanDesired(Double price,
                                                                                 @Param("offset") Integer offset,
                                                                                 @Param("limit") Integer limit);

    @Query("select count(*) from books")
    Long countAllBooks();

    @Query(
            "select b.title, a.full_name, g.genre_name, bd.description, bd.year_of_publication, bd.pages_count, bd.price, " +
                    "round(coalesce(avg(r.rating), 0), 2) as average_rating " +
                    "from books b " +
                    "left join authors a on a.id = b.author_id " +
                    "left join books_details bd on b.id = bd.book_id " +
                    "left join genres g on b.id = g.book_id " +
                    "left join reviews r on b.id = r.book_id " +
                    "where r.review_date >= current_date - interval '1' month " +
                    "group by b.title, a.full_name, g.genre_name, bd.description, bd.year_of_publication, bd.pages_count, bd.price " +
                    "order by average_rating " +
                    "limit 5"
    )
    Optional<List<DetailedBookDto>> findTop5DetailedBooksLastMonth();

    @Modifying
    @Transactional
    @Query(
            "insert into books (title, author_id) " +
                    "values (:bookTitle, (select a.id from authors a where a.full_name = :authorName)); " +
                    "insert into genres (genre_name, book_id) " +
                    "values (:genreName, (select b.id from books b where b.title = :bookTitle)); " +
                    "insert into books_details (book_id, description, year_of_publication, pages_count, price) " +
                    "values ((select b.id from books b where b.title = :bookTitle), :description, :yearOfPublication, :pagesCount, :price)"
    )
    void addNewBook(String bookTitle,
                    String authorName,
                    String genreName,
                    String description,
                    Integer yearOfPublication,
                    Integer pagesCount,
                    Double price);


}
