package com.daneking.movieservice.reviews.fallback;

import com.daneking.movieservice.model.MovieReview;
import com.daneking.movieservice.reviews.ReviewsFeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ReviewServiceFallback implements ReviewsFeignClient {
    @Override
    public CollectionModel<MovieReview> getMovieReviews(Long movieId) {
        return new CollectionModel<>(Collections.emptyList());
    }
}
