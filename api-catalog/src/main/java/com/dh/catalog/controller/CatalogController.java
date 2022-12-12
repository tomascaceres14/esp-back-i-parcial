package com.dh.catalog.controller;

import com.dh.catalog.model.dto.GenreDTO;
import com.dh.catalog.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogController {
	private final CatalogService catalogService;

	public CatalogController(CatalogService catalogService) {
		this.catalogService = catalogService;
	}

	@GetMapping("/online/{genre}")
	ResponseEntity<GenreDTO> getAllByGenreOnline(@PathVariable String genre) {
		return ResponseEntity.ok().body(catalogService.findMoviesAndSeriesByGenreOnline(genre));
	}

	@GetMapping("/offline/{genre}")
	ResponseEntity<GenreDTO> getAllByGenreOffline(@PathVariable String genre) {
		GenreDTO response = new GenreDTO();
		response.setGenre(genre);

		response.SaveToMoviesDTO(catalogService.findMoviesByGenre(genre));
		response.SaveToSeriesDTO(catalogService.findSeriesByGenre(genre));

		return ResponseEntity.ok().body(response);
	}
}
