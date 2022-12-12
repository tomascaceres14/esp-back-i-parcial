package com.dh.catalog.event;

import com.dh.catalog.config.RabbitMQConfig;
import com.dh.catalog.model.Series;
import com.dh.catalog.repository.SeriesRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NewSeriesEventConsumer {

    private final SeriesRepository seriesRepository;

    public NewSeriesEventConsumer(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NEW_SERIES)
    public void execute(Series series) {
        seriesRepository.deleteById(series.getSerieId());
        seriesRepository.save(series);
    }

}