package com.daneking.movieservice.reviews;

import com.daneking.movieservice.model.MovieReview;
import com.daneking.movieservice.reviews.fallback.ReviewServiceFallback;
import com.daneking.movieservice.reviews.fallback.ReviewServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "review-service"/*,fallback = ReviewServiceFallback.class*/, fallbackFactory = ReviewServiceFallbackFactory.class)
public interface ReviewsFeignClient {
    @GetMapping("/reviews/search/findAllByMovieId")
    CollectionModel<MovieReview> getMovieReviews(@RequestParam("movieID") Long movieId);
}