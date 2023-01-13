package org.udemy.exercice.repository.memory;

import org.springframework.stereotype.Repository;
import org.udemy.exercice.entity.Movie;
import org.udemy.exercice.repository.MovieRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {

    private List<Movie> movies = new ArrayList<Movie>();


    public void add(Movie movie){
        movies.add(movie);
        System.out.println("[TYPE REPO : MEMORY] - The movie "+movie.getTitle()+" has been added");

    }

    @Override
    public List<Movie> list() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Movie getDetail(String number) {
        return null;
    }
}
