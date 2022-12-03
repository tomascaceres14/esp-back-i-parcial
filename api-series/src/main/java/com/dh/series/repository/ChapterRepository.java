package com.dh.series.repository;

import com.dh.series.model.Chapter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChapterRepository extends MongoRepository<Chapter, Long> {
}
