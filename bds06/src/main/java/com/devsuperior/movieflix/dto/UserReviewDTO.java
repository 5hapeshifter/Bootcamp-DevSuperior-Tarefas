package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entity.User;

import java.io.Serializable;

public class UserReviewDTO implements Serializable {

    private String name;

    public UserReviewDTO(){

    }

    public UserReviewDTO(String name){
        this.name = name;
    }

    public UserReviewDTO(User entity) {
        name = entity.getName();

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
