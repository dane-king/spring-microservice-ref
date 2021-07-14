package com.daneking.movieservice.movie.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieReview {
    private Long Id;
    private Long movieId;
    private String review;
    private String authorName;
}
