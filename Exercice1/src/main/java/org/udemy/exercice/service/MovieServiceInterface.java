package org.udemy.exercice.service;

import org.udemy.exercice.entity.Movie;
import org.udemy.exercice.repository.MovieRepositoryInterface;

import java.util.List;

public interface MovieServiceInterface {

    public void setMovieRepositoryInterface(MovieRepositoryInterface movieRepositoryInterface);
    void registerMovie(Movie movie);

    List<Movie> getMovieList();

    Movie getMovie(String number);
}
