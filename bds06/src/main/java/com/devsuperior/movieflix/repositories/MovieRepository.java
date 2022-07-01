package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entity.Genre;
import com.devsuperior.movieflix.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    public Page<Movie> findAllByGenreOrderByTitle(Pageable pageable, Genre genre);

    @Query("SELECT obj FROM Movie obj " +
            "ORDER BY obj.title")
    public Page<Movie> findAllMoviesOrderByTitle(Pageable pageable);
}
