package com.dh.catalog.service;

import com.dh.catalog.model.dto.MovieDTO;
import com.dh.catalog.model.dto.SeriesDTO;
import com.dh.catalog.repository.MovieRepository;
import com.dh.catalog.repository.SeriesRepository;

import java.util.List;


public class CatalogService{

    private final MovieRepository movieRepository;
    private final SeriesRepository seriesRepository;


    public CatalogService(MovieRepository movieRepository, SeriesRepository seriesRepository) {
        this.movieRepository = movieRepository;
        this.seriesRepository = seriesRepository;
    }

    public List<MovieDTO> findMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    public List<SeriesDTO> findSeriesByGenre(String genre) {
        return seriesRepository.findByGenre(genre);
    }

}
