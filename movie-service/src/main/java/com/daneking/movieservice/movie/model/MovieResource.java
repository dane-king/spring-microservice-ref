package com.daneking.movieservice.movie.model;

import com.daneking.movieservice.movie.Movie;
import lombok.Data;
import org.springframework.hateoas.Link;

import java.util.Collection;

@Data
public class MovieResource {
    private Long id;
    private String title;
    private String poster;
    private Collection<MovieReview> reviews;

    public MovieResource(Movie movie, Collection<MovieReview> reviews) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.poster = movie.getPoster();
        this.reviews = reviews;
    }
}