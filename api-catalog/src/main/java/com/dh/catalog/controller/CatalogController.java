package com.dh.catalog.controller;

import com.dh.catalog.client.MovieServiceClient;
import com.dh.catalog.client.SerieServiceClient;
import com.dh.catalog.model.dto.Genre;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogController {

	private final MovieServiceClient movieServiceClient;
	private final SerieServiceClient serieServiceClient;

	public CatalogController(MovieServiceClient movieServiceClient, SerieServiceClient serieServiceClient) {
		this.movieServiceClient = movieServiceClient;
		this.serieServiceClient = serieServiceClient;
	}

	@GetMapping("/online/{genre}")
	ResponseEntity<Genre> getAllByGenreOnline(@PathVariable String genre) {
		Genre response = new Genre();

		response.setMovies(movieServiceClient.findByGenre(genre));
		response.setSeries(serieServiceClient.findByGenre(genre));
		response.setGenre(genre);

		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/offline/{genre}")
	ResponseEntity<Genre> getAllByGenreOffline(@PathVariable String genre) {
		Genre response = new Genre();

		response.setMovies(movieServiceClient.findByGenre(genre));
		response.setSeries(serieServiceClient.findByGenre(genre));
		response.setGenre(genre);

		return ResponseEntity.ok().body(response);
	}

}
