package com.daneking.movieservice.movie;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Data
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue
    private Long Id;
    private String title;
    private String poster;
}