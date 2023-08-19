package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public  String addMovei(Movie movie){
        String res = movieRepository.addMovei(movie);
        return res;
    }


    public String addDirector(Director director){

        String ans = movieRepository.addDirector(director);

        return ans;
    }


    public String addMovieDirectorPair(String movieName, String directorName){

        String ans = movieRepository.addMoveiAndDirectorPair(movieName, directorName);

        return ans;
    }


    public Movie getMovieByName(String name){

        List<Movie> movieList = movieRepository.getMovei();

        Movie ans = null;
        for(Movie movie: movieList){

            if(movie.getName().equals(name)){
                ans = movie;
            }
        }
        return ans;
    }



    public Director getDirectorByName(String name){

        List<Director> directorList = movieRepository.getDirectorList();

        Director ans = null;
        for(Director director: directorList){

            if(director.getName().equals(name)){
                ans = director;
            }
        }

        return ans;
    }


    public List<String> getMoviesByDirectorName(String name){

        List<String> list = movieRepository.getMoviesAndDirector(name);

        return list;
    }


    public List<String> findAllMovies(){

        List<Movie> movieList = movieRepository.getMovei();

        List<String> movies = new ArrayList<>();

        for(Movie movie: movieList){
            movies.add(movie.getName());
        }

        return movies;
    }


    public String deleteDirectorByName(String name){
        String ans = movieRepository.deleteDirectorAndMovei(name);
        return ans;
    }


    public String deleteAllDirectors(){

        List<Director> directorList = movieRepository.getDirectorList();

        for(Director director: directorList){
            deleteDirectorByName(director.getName());
        }

        return "All the director and their movies has been deleted";
    }

}
