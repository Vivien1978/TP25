package org.udemy.exercice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.udemy.exercice.entity.Movie;
import org.udemy.exercice.form.MovieForm;
import org.udemy.exercice.service.MovieServiceInterface;


import javax.validation.Valid;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Scanner;

@Controller
public class MovieController {//implements MovieControllerInterface{

    @Autowired
    private MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

/*System.out.println("[INFO] - {MovieController} - Methode AddMovie - Titre:"+movieForm.getTitle());
        System.out.println("[INFO] - {MovieController} - Methode AddMovie - Genre:"+movieForm.getGenre());
        System.out.println("[INFO] - {MovieController} - Methode AddMovie - Results:"+results.toString());


 */
    @PostMapping("/movie")
    public String addMovie(@Valid @ModelAttribute MovieForm movieForm, BindingResult results){

        boolean testValid = movieForm.getTitle() == null;
        System.out.println("[INFO] - {MovieController} - Appel de la méthode addMovie");
        System.out.println("[INFO] - {MovieController} - Erreur : "+results.toString());
        if (results.hasErrors()) {
            System.out.println("[INFO] - {MovieController} - Methode AddMovie - Erreur BindingResult");
            return "add-movie-form";
        }

            System.out.println("[INFO] - {MovieController} - Title value :"+movieForm.getTitle());
            System.out.println("[INFO] - {MovieController} - Title length :"+movieForm.getTitle().length());
            System.out.println("[INFO] - {MovieController} - Title null :"+testValid);
            System.out.println("[INFO] - {MovieController} - Title vide :"+movieForm.getTitle().isEmpty());
            System.out.println("[INFO] - {MovieController} - Title Blanc :"+movieForm.getTitle().isBlank());
            Movie movie = new Movie();
            movie.setTitle(movieForm.getTitle());
            movie.setGenre(movieForm.getGenre());
            movieService.registerMovie(movie);
            return "movie-added";
    }

    @GetMapping("/about-us")
    public String displayFullDetails(){
        System.out.println("[INFO] - {MovieController} - Appel de la méthode displayFullDetails");
        return "about-us";
    }


    public void createMovie()  {

        System.out.println( "What's your movie and his king ?" );
        Scanner sc = new Scanner(System.in);
        String titre = sc.nextLine();
        String genre = sc.nextLine();

        Movie movie = new Movie();
        movie.setTitle(titre);
        movie.setGenre(genre);

        movieService.registerMovie(movie);
    }

}
