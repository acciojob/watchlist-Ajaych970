package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;



    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String ans = movieService.addMovei(movie);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }



    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        String ans = movieService.addDirector(director);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }



    @PostMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName")String movieName, @RequestParam("directorName")String directorName){
        String ans = movieService.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }



    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@RequestParam("name")String name){
        Movie movie = movieService.getMovieByName(name);
        return new ResponseEntity<>(movie, HttpStatus.FOUND);
    }



    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@RequestParam("name")String name){
        Director director = movieService.getDirectorByName(name);
        return new ResponseEntity<>(director, HttpStatus.FOUND);
    }



    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@RequestParam("name")String name){
        List<String> movies = movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(movies, HttpStatus.FOUND);
    }



    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movies = movieService.findAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.FOUND);
    }



    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name")String name){
        String ans = movieService.deleteDirectorByName(name);
        return new ResponseEntity<>(ans, HttpStatus.ACCEPTED);
    }



    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String ans = movieService.deleteAllDirectors();
        return new ResponseEntity<>(ans, HttpStatus.ACCEPTED);
    }
}
