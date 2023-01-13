package org.udemy.exercice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.udemy.exercice.service.MovieServiceInterface;

public interface MovieControllerInterface {

    public void setMovieService(MovieServiceInterface movieService);
    void createMovie();
}
