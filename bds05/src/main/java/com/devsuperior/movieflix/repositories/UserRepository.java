package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<com.devsuperior.movieflix.entities.User, Long> {

    User findByEmail(String email);

}
