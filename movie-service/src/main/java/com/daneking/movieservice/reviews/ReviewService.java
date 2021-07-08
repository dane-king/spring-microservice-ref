package com.daneking.movieservice.reviews;

import com.daneking.movieservice.movie.model.MovieReview;
import org.slf4j.Logger;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.util.function.Function;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class ReviewService {
    private static final Logger LOGGER = getLogger(ReviewService.class);
    private final CircuitBreaker reviewCircuitBreaker;
    private final WebClient webClient;


    public ReviewService(CircuitBreakerFactory circuitBreakerFactory, WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://api-gateway:8080/review-service").build();
        this.reviewCircuitBreaker = circuitBreakerFactory.create("reviews");
    }

    public Flux<MovieReview> getReviews(Long movieId) {
        Function<UriBuilder, URI> getReviewById = uriBuilder -> uriBuilder.path("/reviews/{id}").build(movieId);
        return webClient.get()
                .uri(getReviewById).retrieve()
                .bodyToFlux(MovieReview.class);
//        return reviewCircuitBreaker.run(webClient.get().uri("/reviews").retrieve().bodyToMono(CollectionModel<MovieReview>.class)
//                , throwable -> {
//                    LOGGER.warn("Error Making review requests", throwable);
//                    return Mono.just(CollectionModel<MovieReview>.empty());
//                });
    }
}
