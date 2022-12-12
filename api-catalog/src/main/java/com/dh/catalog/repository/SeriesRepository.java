package com.dh.catalog.repository;

import com.dh.catalog.model.Series;
import com.dh.catalog.model.dto.SeriesDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SeriesRepository extends MongoRepository<Series, String> {
    List<SeriesDTO> findByGenre(String genre);
}
