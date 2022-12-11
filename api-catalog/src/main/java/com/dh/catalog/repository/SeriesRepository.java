package com.dh.catalog.repository;


import com.dh.catalog.model.Series;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeriesRepository extends MongoRepository<Series, String> {
}
