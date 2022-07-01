package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieByGenreDTO;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieReviewDTO;
import com.devsuperior.movieflix.entity.Genre;
import com.devsuperior.movieflix.entity.Movie;
import com.devsuperior.movieflix.entity.Review;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Transactional(propagation= Propagation.REQUIRED, readOnly=true)
    public Page<MovieByGenreDTO>  findAllByGenre(Pageable pageable, Long genreId){
        if(genreId == 0L){
            Page<Movie> list = movieRepository.findAllMoviesOrderByTitle(pageable);
            return list.map(movie -> new MovieByGenreDTO(movie));
        }
        Genre obj = genreRepository.getOne(genreId);
        Page<Movie> list = movieRepository.findAllByGenreOrderByTitle(pageable, obj);
        return list.map(movie -> new MovieByGenreDTO(movie));
    }

    @Transactional(readOnly=true)
    public MovieDTO findById(Long id){
        Optional<Movie> obj = movieRepository.findById(id);
        Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
        return new MovieDTO(entity);
    }

    public List<MovieReviewDTO> findReviewsByMovieId(Long id) {
        try {
            List<Review> obj = reviewRepository.findReviewByMovieId(id);
            List<MovieReviewDTO> list = new ArrayList<>();
            obj.forEach(x -> list.add(new MovieReviewDTO(x)));
            return list;
        }catch (Exception e) {
            throw new ResourceNotFoundException("Movie not found");
        }
    }

    }
