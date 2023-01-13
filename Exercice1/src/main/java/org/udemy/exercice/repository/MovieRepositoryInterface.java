package org.udemy.exercice.repository;

import org.udemy.exercice.entity.Movie;

import java.util.List;

public interface MovieRepositoryInterface {



    void add(Movie movie);
    List<Movie> list();
    Movie getDetail(String number);
}
