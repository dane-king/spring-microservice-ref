package com.daneking.movieservice.movie;

import com.daneking.movieservice.movie.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MovieRepository extends CrudRepository<Movie, Long> {
}