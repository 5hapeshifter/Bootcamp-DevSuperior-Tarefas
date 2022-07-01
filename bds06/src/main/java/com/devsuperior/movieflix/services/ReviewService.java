package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewInsertDTO;
import com.devsuperior.movieflix.dto.ReviewUserDTO;
import com.devsuperior.movieflix.entity.Movie;
import com.devsuperior.movieflix.entity.Review;
import com.devsuperior.movieflix.entity.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AuthService authService;

    @Transactional
    public ReviewUserDTO save(ReviewInsertDTO dto){
        Movie movie = movieRepository.getOne(dto.getMovieId());
        User user = authService.authenticated();

        Review review = new Review();
        review.setText(dto.getText());
        review.setMovie(movie);
        review.setUser(user);

        review = reviewRepository.save(review);

        return new ReviewUserDTO(review);


    }
}
