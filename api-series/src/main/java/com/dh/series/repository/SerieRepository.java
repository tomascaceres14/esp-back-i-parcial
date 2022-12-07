package com.dh.series.repository;

import com.dh.series.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends MongoRepository<Serie, Long> {
    List<Serie> getSerieByGenre(String genre);
}
