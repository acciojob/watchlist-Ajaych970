package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String,Movie> moveiData=new HashMap<>();
    HashMap<String,Director> directorData=new HashMap<>();
    HashMap<String, List<String>> moveiAndDirectorData=new HashMap<>();


    public String addMovei(Movie movei){
        String moveiName=movei.getName();
        moveiData.put(moveiName,movei);
        return "Movei Added successfully";
    }

    public String addDirector(Director director){
        String directorName=director.getName();
        directorData.put(directorName,director);
        return "Director added successfully";
    }

    public String addMoveiAndDirectorPair(String moveiName, String directorName){
        if(moveiAndDirectorData.containsKey(directorName)){
            moveiAndDirectorData.get(directorName).add(moveiName);
        }else {
            List <String> list=new ArrayList<>();
            list.add(moveiName);
            moveiAndDirectorData.put(directorName,list);
        }
        return "Movei and director pair added successfully";
    }

    public List<Movie> getMovei(){
        List<Movie> movei=new ArrayList<Movie>(moveiData.values());
        return movei;
    }

    public  List<Director> getDirectorList(){
        List<Director> director=new ArrayList<Director>(directorData.values());
        return director;
    }

    public List<String> getMoviesAndDirector(String name){
        return moveiAndDirectorData.get(name);
    }

    public String deleteDirectorAndMovei(String name){
        List<String> movies = moveiAndDirectorData.get(name);

        for(String movie: movies){
            moveiData.remove(movie);
        }

        directorData.remove(name);

        moveiAndDirectorData.remove(name);

        return "Director and its movies has been deleted";
    }
}
