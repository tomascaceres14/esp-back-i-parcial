package com.dh.series.service;

import com.dh.series.model.Chapter;
import com.dh.series.model.Season;
import com.dh.series.model.Serie;

import java.util.List;

public interface SerieService {

    void save (Serie serie);

    List<Serie> getAll();

    Serie getById(Long id);

    void deleteById(Long id);

    void update(Serie serie);

    void addChapter(Long serieId, Long seasonId, Chapter chapter) throws Exception;

    void addSeason(Long serieId, Season season) throws Exception;

}
