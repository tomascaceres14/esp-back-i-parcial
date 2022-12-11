package com.dh.catalog.event;

import com.dh.catalog.config.RabbitMQConfig;
import com.dh.catalog.model.Movie;
import com.dh.catalog.model.dto.MovieDTO;
import com.dh.catalog.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class NewMovieEventConsumer {

    private final MovieRepository movieRepository;

    public NewMovieEventConsumer(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NEW_MOVIE)
    public void execute(MovieDTO movieDTO) {
        Movie movieNew= new Movie();
        BeanUtils.copyProperties(movieDTO, movieNew);
        movieRepository.deleteById(movieNew.getMovieId());
        movieRepository.save(movieNew);
    }
}