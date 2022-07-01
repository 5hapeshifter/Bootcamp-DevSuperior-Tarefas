package com.devsuperior.movieflix.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ReviewInsertDTO {

    @NotBlank
    @NotNull
    private String text;
    private Long movieId;

    public ReviewInsertDTO(){
    }

    public ReviewInsertDTO(String text, Long movieId) {
        this.text = text;
        this.movieId = movieId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
