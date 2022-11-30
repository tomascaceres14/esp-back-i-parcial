package com.dh.series.controller;

import com.dh.series.model.Serie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/v1/series")
public class SerieController {

    @GetMapping("/{genre}")
    private List<Serie> getSeriesByGenre(@PathVariable String genre){
        return null;
    }

    @PostMapping()
    private void postSerie(Serie serie){

    }

}
