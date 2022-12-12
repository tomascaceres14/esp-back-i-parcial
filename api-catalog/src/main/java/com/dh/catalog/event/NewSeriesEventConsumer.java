package com.dh.catalog.event;
import com.dh.catalog.config.RabbitMQConfig;
import com.dh.catalog.model.Chapter;
import com.dh.catalog.model.Season;
import com.dh.catalog.model.Series;
import com.dh.catalog.model.dto.ChapterDTO;
import com.dh.catalog.model.dto.SeasonDTO;
import com.dh.catalog.model.dto.SeriesDTO;
import com.dh.catalog.repository.SeriesRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class NewSeriesEventConsumer {

    private final SeriesRepository seriesRepository;

    public NewSeriesEventConsumer(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NEW_SERIES)
    public void execute(Series seriesDTO) {
        Series series = new Series();
        BeanUtils.copyProperties(seriesDTO, series);
        for (SeasonDTO sDTO :
                seriesDTO.getSeasonsDTO()) {
            Season season = new Season();
            BeanUtils.copyProperties(sDTO, season);
            for (ChapterDTO cDTO :
                    sDTO.getChaptersDTO()) {
                Chapter chapter = new Chapter();
                BeanUtils.copyProperties(cDTO, chapter);
                season.getChapters().add(chapter);
            }
            series.getSeasons().add(season);
        }

        seriesRepository.deleteById(series.getSerieId());
        seriesRepository.save(series);
    }

}