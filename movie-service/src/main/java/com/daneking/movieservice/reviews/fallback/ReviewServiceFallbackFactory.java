package com.daneking.movieservice.reviews.fallback;

import com.daneking.movieservice.model.MovieReview;
import com.daneking.movieservice.reviews.ReviewsFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ReviewServiceFallbackFactory implements FallbackFactory<ReviewsFeignClient> {
    public static final Logger LOGGER = LoggerFactory.getLogger(ReviewServiceFallback.class);
    @Override
    public ReviewsFeignClient create(Throwable throwable) {
        return new ReviewsFeignClient() {
            @Override
            public CollectionModel<MovieReview> getMovieReviews(Long movieId) {
                LOGGER.error("Error Occurred trying to fetch reviews from review service", throwable);
                return new CollectionModel<>(Collections.emptyList());
            }
        };
    }
}
