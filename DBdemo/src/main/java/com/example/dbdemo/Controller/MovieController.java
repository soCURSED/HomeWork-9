package com.example.dbdemo.Controller;

import com.example.dbdemo.Model.Movie;
import com.example.dbdemo.Service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity getMovies() {
        return ResponseEntity.status(200).body(movieService.getAllMovies());
    }

    // get movie by id
//    @GetMapping("/{movieID}")
//    public ResponseEntity getMovies(@PathVariable Integer movieID) {
//        return movieService.getAMovie(movieID);
//    }



    @PostMapping
    public ResponseEntity addUsers(@RequestBody @Valid Movie movie, Errors errors) {
      if (errors.hasErrors()){
          System.out.println("11111111111111111111111");
          return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
      }
        System.out.println("ERRRRRRerererer");
        movieService.addNewMovie(movie);
        return ResponseEntity.status(200).body("New Movie Added");
    }

    @PutMapping("/{movieID}")
    public ResponseEntity updateMovie(@RequestBody Movie movie, @PathVariable Integer movieID) {
        movieService.updateMovie(movie, movieID);
        return ResponseEntity.status(200).body("Movie Updated");

    }

    @DeleteMapping("/{movieID}")
    public ResponseEntity deleteUser(@PathVariable Integer userID) {
        movieService.deleteUMovie(userID);
        return ResponseEntity.status(200).body("Movie Deleted");

    }
}



