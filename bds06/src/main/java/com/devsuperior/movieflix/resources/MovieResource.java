package com.devsuperior.movieflix.resources;


import com.devsuperior.movieflix.dto.MovieByGenreDTO;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieReviewDTO;
import com.devsuperior.movieflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<Page<MovieByGenreDTO>> findAllByGenre(Pageable pageable, @RequestParam(defaultValue = "0") Long genreId){
        Page<MovieByGenreDTO> genreList = movieService.findAllByGenre(pageable, genreId);
        return ResponseEntity.ok().body(genreList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable Long id){
        MovieDTO movie = movieService.findById(id);
        return ResponseEntity.ok().body(movie);
    }

    @GetMapping(value = "/{id}/reviews")
    public ResponseEntity<List<MovieReviewDTO>> findReviewsByMovieId(@PathVariable Long id){
        List<MovieReviewDTO> review = movieService.findReviewsByMovieId(id);
        return ResponseEntity.ok().body(review);

    }
}
