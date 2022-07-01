package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entity.Movie;

import java.io.Serializable;


public class MovieByGenreDTO implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private Integer year;
    private String imgUrl;

    public MovieByGenreDTO(){

    }

    public MovieByGenreDTO(String title, String subTitle, Integer year, String imgUrl, Long id) {
        this.title = title;
        this.subTitle = subTitle;
        this.year = year;
        this.imgUrl = imgUrl;
        this.id = id;
    }
    public MovieByGenreDTO(Movie movie){
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.subTitle = movie.getSubtitle();
        this.year = movie.getYear();
        this.imgUrl = movie.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}


