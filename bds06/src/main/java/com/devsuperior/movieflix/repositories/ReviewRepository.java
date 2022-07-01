package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entity.Movie;
import com.devsuperior.movieflix.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT obj FROM Review obj WHERE obj.movie.id = :id")
    List<Review> findReviewByMovieId(Long id);
}
