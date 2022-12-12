package com.dh.catalog.controller.dto;

import com.dh.catalog.model.Movie;
import com.dh.catalog.model.dto.MovieDTO;
import com.dh.catalog.model.dto.SeriesDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieSerieGenreDTO {

    private List<MovieDTO> movies;

    private List<SeriesDTO> series;

}
