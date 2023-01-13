package org.udemy.exercice.service.golive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.udemy.exercice.entity.Movie;
import org.udemy.exercice.repository.MovieRepositoryInterface;
import org.udemy.exercice.service.MovieServiceInterface;

import java.io.IOException;
import java.util.List;

//@Service
public class GoLiveMovieService implements MovieServiceInterface {
    @Autowired
    private MovieRepositoryInterface movieRepositoryInterface;

    public MovieRepositoryInterface getMovieRepositoryInterface() {
        return movieRepositoryInterface;
    }

    public void setMovieRepositoryInterface(MovieRepositoryInterface movieRepositoryInterface) {
        this.movieRepositoryInterface = movieRepositoryInterface;
    }

    public void registerMovie(Movie movie)   {
        movieRepositoryInterface.add(movie);

    }

    @Override
    public List<Movie> getMovieList() {
        return movieRepositoryInterface.list();
    }

    @Override
    public Movie getMovie(String number) {
        throw new UnsupportedOperationException();
    }
}
