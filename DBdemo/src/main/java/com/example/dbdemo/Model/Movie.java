package com.example.dbdemo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity @Validated
//@Table(name = "moviedb")
public class Movie {

    @Id
    @NotNull(message = "ID can't be null!")
    @Min(value = 100,message= "Length most be more than 3")
    @Column(unique = true)
    private Integer ID;

    @NotEmpty(message = "name can't be Empty!")
    @Size(min = 2,message = "Length most be more than 2")
    @Column(unique = true)
    private String name;

    @Pattern(regexp = "(Drama|Action|Comedy)",message = "Only: (Drama|Action|Comedy)")
    @Column(nullable = false)
    private String genre;

    @Range(min = 1, max = 5, message = "Rating only Between 1 - 5")
    private Integer rating;

    @NotNull(message = "Rating can't be null!")
@Min(value = 60, message = "60 minute or more")
    private Integer duration;


    @NotEmpty(message = "launchDate can't be empty!")
    private String  launchDate;


}
