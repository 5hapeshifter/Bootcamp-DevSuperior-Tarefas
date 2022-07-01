package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.dto.ReviewInsertDTO;
import com.devsuperior.movieflix.dto.ReviewUserDTO;
import com.devsuperior.movieflix.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewResource {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewUserDTO> InsertReview(@Valid @RequestBody ReviewInsertDTO dto){
        ReviewUserDTO review = reviewService.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(review.getId()).toUri();
        return ResponseEntity.created(uri).body(review);
    }
}
