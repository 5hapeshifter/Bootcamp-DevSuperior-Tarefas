package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entity.Review;

public class ReviewUserDTO extends ReviewDTO{
    private UserDTO user;

    public ReviewUserDTO(){

    }

    public ReviewUserDTO(Long id, String text, Long movieId, UserDTO user) {
        super(id, text, movieId);
        this.user = user;
    }

    public ReviewUserDTO(Review entity) {
        super(entity);
        user = new UserDTO(entity.getUser());
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
