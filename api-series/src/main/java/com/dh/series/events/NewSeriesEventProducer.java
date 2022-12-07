package com.dh.series.events;

import com.dh.series.config.RabbitMQConfig;
import com.dh.series.model.Serie;
import com.dh.series.model.dto.SeasonDTO;
import com.dh.series.model.dto.SerieDTO;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class NewSeriesEventProducer {

    private final RabbitTemplate rabbitTemplate;

    public NewSeriesEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void execute(Serie serie) {
        SerieDTO serieDTO = new SerieDTO();
        BeanUtils.copyProperties(serie, serieDTO);
        // corregir logica de mapeo
        SeasonDTO seasonDTO = serieDTO.getSeasons().get(0);

        if (seasonDTO != null && serie.getSeasons() != null) {
            BeanUtils.copyProperties(serie.getSeasons(), serieDTO.getSeasons());
        }

        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.TOPIC_NEW_PLAYLIST, serieDTO);
    }

}