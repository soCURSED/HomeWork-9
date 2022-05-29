package com.example.dbdemo.Service;

import com.example.dbdemo.Controller.MyRepository;
import com.example.dbdemo.Model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class MovieService {

    private final MyRepository myRepository;

    public List<Movie> getAllMovies(){
        return myRepository.findAll();
            }

    public void addNewMovie(Movie movie) {
        myRepository.save(movie);
    }

    public void updateMovie(Movie movie, Integer movieID) {

        Movie oldMovie = myRepository.findById(movieID).get();
        oldMovie.setName(movie.getName());
        oldMovie.setGenre(movie.getGenre());
        oldMovie.setDuration(movie.getDuration());
        oldMovie.setLaunchDate(movie.getLaunchDate());
        oldMovie.setRating(movie.getRating());
        oldMovie.setDuration(movie.getDuration());
        myRepository.save(oldMovie);



    }


    public void deleteUMovie(Integer movieID) {
        myRepository.deleteById(movieID);
    }

//    public void getAMovie(Integer movieID) {
//
//        Movie getMovie = myRepository.findById(movieID).get();
//        return getMovie;

    }

