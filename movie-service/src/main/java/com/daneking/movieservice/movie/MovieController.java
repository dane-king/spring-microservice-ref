package com.daneking.movieservice.movie;

import com.daneking.movieservice.movie.model.Movie;
import com.daneking.movieservice.movie.model.MovieResource;
import com.daneking.movieservice.movie.model.MovieReview;
import com.daneking.movieservice.reviews.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.persistence.EntityNotFoundException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieRepository movieRepository;
    private ReviewService reviewService;


    public MovieController(MovieRepository movieRepository, ReviewService reviewService) {
        this.movieRepository = movieRepository;
        this.reviewService = reviewService;
    }

    @GetMapping("/{movieID}")
    public Mono<MovieResource> getMovie(@PathVariable("movieID") Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new EntityNotFoundException("Movie not found"));
        Collection<MovieReview> reviews = reviewService.getReviews(movieId)
                .collectList()
                .block(Duration.of(5, ChronoUnit.SECONDS));

        return Mono.just(new MovieResource(movie,reviews));
    }
}
