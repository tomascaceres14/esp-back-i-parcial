package com.dh.catalog.model.dto;

import com.dh.catalog.model.Chapter;
import com.dh.catalog.model.Movie;
import com.dh.catalog.model.Season;
import com.dh.catalog.model.Series;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GenreDTO {

    private String genre;
    private List<MovieDTO> movies;
    private List<SeriesDTO> series;

    public void SaveToSeriesDTO(List<Series> series){
        List<SeriesDTO> newSeriesDTO = new ArrayList<>();
        for (Series serie :
                series) {
            SeriesDTO serieDTO = new SeriesDTO();
            BeanUtils.copyProperties(serie, serieDTO);
            for (Season s :
                    serie.getSeasons()) {
                SeasonDTO sDTO = new SeasonDTO();
                BeanUtils.copyProperties(s, sDTO);
                for (Chapter c :
                        s.getChapters()) {
                    ChapterDTO cDTO = new ChapterDTO();
                    BeanUtils.copyProperties(c, cDTO);
                    sDTO.getChaptersDTO().add(cDTO);
                }
                serieDTO.getSeasonsDTO().add(sDTO);
            }
            newSeriesDTO.add(serieDTO);
        }
        setSeries(newSeriesDTO);
    }

    public void SaveToMoviesDTO(List<Movie> movies) {
        List<MovieDTO> newMoviesDTO = new ArrayList<>();
        for (Movie m :
                movies) {
           MovieDTO mDTO = new MovieDTO();
           BeanUtils.copyProperties(m, mDTO);
           newMoviesDTO.add(mDTO);
        }
        setMovies(newMoviesDTO);
    }

}
