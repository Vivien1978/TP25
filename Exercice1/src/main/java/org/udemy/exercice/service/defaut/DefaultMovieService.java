package org.udemy.exercice.service.defaut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.udemy.exercice.entity.Movie;
import org.udemy.exercice.repository.MovieRepositoryInterface;
import org.udemy.exercice.service.MovieServiceInterface;

import java.util.List;

@Service
public class DefaultMovieService implements MovieServiceInterface {

    @Autowired
    private MovieRepositoryInterface movieRepositoryInterface;
    //GoLiveMovieRepository goLiveMovieRepository = new GoLiveMovieRepository();


    public MovieRepositoryInterface getMovieRepositoryInterface() {
        return movieRepositoryInterface;
    }

    public void setMovieRepositoryInterface(MovieRepositoryInterface movieRepositoryInterface) {
        this.movieRepositoryInterface = movieRepositoryInterface;
    }

    public void registerMovie(Movie movie) {
        movieRepositoryInterface.add(movie);
        //goLiveMovieRepository.add(movie);

    }

    @Override
    public List<Movie> getMovieList() {
        return movieRepositoryInterface.list();
    }

    @Override
    public Movie getMovie(String number) {
        return movieRepositoryInterface.getDetail(number);
    }
}
