package com.example.dbdemo.Controller;

import com.example.dbdemo.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepository extends JpaRepository<Movie,Integer> {
}
