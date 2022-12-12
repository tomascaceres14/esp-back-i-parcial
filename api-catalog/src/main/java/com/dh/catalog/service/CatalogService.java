package com.dh.catalog.service;

import com.dh.catalog.model.Movie;
import com.dh.catalog.model.Series;
import com.dh.catalog.model.dto.MovieDTO;
import com.dh.catalog.model.dto.SeriesDTO;
import com.dh.catalog.repository.MovieRepository;
import com.dh.catalog.repository.SeriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService{

    private final MovieRepository movieRepository;
    private final SeriesRepository seriesRepository;


    public CatalogService(MovieRepository movieRepository, SeriesRepository seriesRepository) {
        this.movieRepository = movieRepository;
        this.seriesRepository = seriesRepository;
    }

    public List<Movie> findMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    public List<Series> findSeriesByGenre(String genre) {
        return seriesRepository.findByGenre(genre);
    }

}
