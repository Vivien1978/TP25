package org.udemy.exercice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.udemy.exercice.entity.Movie;
import org.udemy.exercice.form.MovieForm;
import org.udemy.exercice.repository.MovieRepositoryInterface;
import org.udemy.exercice.service.MovieServiceInterface;

import java.util.List;

@Controller
@RequestMapping("/dvdstore")
public class HomeController {

    @Autowired
    MovieServiceInterface movieService;

    @GetMapping("/home")
    public String displayHome( Model model){

        System.out.println("[INFO] - {HomeController} - Appel de la méthode displayHome");
        model.addAttribute("movies",movieService.getMovieList());
        return "dvdstore-home";
    }

    @GetMapping("/{id}")
    public String displayList(@PathVariable("id") String number, Model model)
    {
        System.out.println("[INFO] - {HomeController} - Appel de la méthode displayList");
        model.addAttribute("movie",movieService.getMovie(number));
        return "dvdstore-details";
    }

    @GetMapping("/add-movie-form")
    public String displayMovieForm(@ModelAttribute MovieForm movie){
        System.out.println("[INFO] - {HomeController} -  Appel de la méthode displayList");
        return "add-movie-form";
    }

}
