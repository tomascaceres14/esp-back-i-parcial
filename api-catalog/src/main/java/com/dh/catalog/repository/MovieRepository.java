package com.dh.catalog.repository;

import com.dh.catalog.model.Movie;
import com.dh.catalog.model.dto.MovieDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, String> {
    List<MovieDTO> findByGenre(String genre);
}
