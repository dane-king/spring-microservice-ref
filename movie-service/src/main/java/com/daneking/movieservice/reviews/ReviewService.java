package com.daneking.movieservice.reviews;

import com.daneking.movieservice.movie.model.MovieReview;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Function;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class ReviewService {
    private static final Logger LOGGER = getLogger(ReviewService.class);
    private final CircuitBreaker reviewCircuitBreaker;
    private final WebClient webClient;


    private String reviewBaseUrl;
    private Object MovieReview;


    public ReviewService(CircuitBreakerFactory circuitBreakerFactory, WebClient.Builder webClient, @Value("${review-service.baseUrl}")String reviewBaseUrl) {
        LOGGER.info("Review Base url: {}", reviewBaseUrl);
        this.webClient = webClient.baseUrl(reviewBaseUrl).build();
        this.reviewCircuitBreaker = circuitBreakerFactory.create("reviews");
    }

    public Flux<MovieReview> getReviews(Long movieId) {
        Function<UriBuilder, URI> getReviewById = uriBuilder -> uriBuilder.path("/reviews/{id}").build(movieId);
        return reviewCircuitBreaker.run(()->this.webClient.get()
                .uri(getReviewById).retrieve()
                .bodyToFlux(MovieReview.class),
                throwable -> {
                    LOGGER.warn("Unable to call review service at {}, exception {}", reviewBaseUrl, throwable);
                    return Flux.empty();
                });

    }
}
