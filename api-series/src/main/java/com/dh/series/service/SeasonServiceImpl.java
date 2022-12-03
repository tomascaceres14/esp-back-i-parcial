package com.dh.series.service;

import com.dh.series.events.NewSeriesEventProducer;
import com.dh.series.model.Chapter;
import com.dh.series.model.Season;
import com.dh.series.model.Serie;
import com.dh.series.repository.ChapterRepository;
import com.dh.series.repository.SeasonRepository;
import com.dh.series.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonServiceImpl implements SerieService {

    private final SerieRepository serieRepository;
    private final SeasonRepository seasonRepository;
    private final NewSeriesEventProducer seriesEventProducer;

    public SeasonServiceImpl(SerieRepository serieRepository, SeasonRepository seasonRepository, ChapterRepository chapterRepository, SeasonRepository seasonRepository1, NewSeriesEventProducer seriesEventProducer) {
        this.serieRepository = serieRepository;
        this.seasonRepository = seasonRepository1;
        this.seriesEventProducer = seriesEventProducer;
    }

    @Override
    public void save(Serie serie) {
        serieRepository.save(serie);
        seriesEventProducer.execute(serie);
    }

    @Override
    public List<Serie> getAll() {
        return serieRepository.findAll();
    }

    @Override
    public Serie getById(Long id) {
        return serieRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        serieRepository.deleteById(id);
    }

    @Override
    public void update(Serie serie) {
        if (serieRepository.existsById(serie.getSerieId())) {
            serieRepository.save(serie);
        }
    }

    @Override
    public void addSeason(Long serieId, Season season) throws Exception {

        Serie serie = serieRepository.findById(serieId).orElse(null);

        if (serie == null) {
            throw new Exception("Serie id " + serieId + " not found");
        }

        serie.getSeasons().add(season);
        serieRepository.save(serie);
    }

    @Override
    public void addChapter(Long serieId, Long seasonId, Chapter chapter) throws Exception {

        Serie serie = serieRepository.findById(serieId).orElse(null);
        Season season = seasonRepository.findById(seasonId).orElse(null);

        if (serie == null && season == null ) {
            throw new Exception("Serie or chapter id " + serieId + " not found");
        }

        serie.getSeasons().get(Math.toIntExact(seasonId)).getChapters().add(chapter);
        serieRepository.save(serie);
    }
}
