package com.dh.catalog.service;

import com.dh.catalog.client.MovieRepositoryFeing;
import com.dh.catalog.client.ServiceRepositoryFeing;
import com.dh.catalog.model.Movie;
import com.dh.catalog.model.Series;
import com.dh.catalog.model.dto.GenreDTO;
import com.dh.catalog.repository.MovieRepository;
import com.dh.catalog.repository.SeriesRepository;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService{

    private final MovieRepository movieRepository;
    private final SeriesRepository seriesRepository;
    private final MovieRepositoryFeing movieRepositoryFeign;
    private final ServiceRepositoryFeing serviceRepositoryFeign;

    public CatalogService(MovieRepository movieRepository, SeriesRepository seriesRepository, MovieRepositoryFeing movieRepositoryFeing, ServiceRepositoryFeing serviceRepositoryFeign) {
        this.movieRepository = movieRepository;
        this.seriesRepository = seriesRepository;
        this.movieRepositoryFeign = movieRepositoryFeing;
        this.serviceRepositoryFeign = serviceRepositoryFeign;
    }

    public List<Movie> findMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    public List<Series> findSeriesByGenre(String genre) {
        return seriesRepository.findByGenre(genre);
    }

    public void getCatalogFallbackValue(CallNotPermittedException ex) throws Exception {
        throw new Exception("Circuit breaker activated");
    }

    @Retry(name = "retryCatalog")
    @CircuitBreaker(name = "clientCatalog", fallbackMethod = "getCatalogFallbackValue")
    public GenreDTO findMoviesAndSeriesByGenreOnline(String genre){
        GenreDTO response = new GenreDTO();
        response.setMovies(movieRepositoryFeign.findByGenre(genre));
        response.SaveToSeriesDTO(serviceRepositoryFeign.findByGenre(genre));
        response.setGenre(genre);
        return response;
    }


}
