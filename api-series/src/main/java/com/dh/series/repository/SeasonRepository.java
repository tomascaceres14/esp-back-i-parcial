package com.dh.series.repository;

import com.dh.series.model.Season;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeasonRepository extends MongoRepository<Season, Long> {
}
