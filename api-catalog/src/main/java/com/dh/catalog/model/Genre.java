package com.dh.catalog.model;

import com.dh.catalog.model.dto.MovieDTO;
import com.dh.catalog.model.dto.SeriesDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Genre {

    private String genre;
    private List<MovieDTO> movies;
    private List<SeriesDTO> series;

}
