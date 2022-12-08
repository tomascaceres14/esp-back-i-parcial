package com.dh.catalog.event;

import com.dh.catalog.config.RabbitMQConfig;
import com.dh.catalog.model.Series;
import com.dh.catalog.repository.SeriesRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class NewSeriesEventConsumer {

    private final SeriesRepository playlistRepository;

    public NewSeriesEventConsumer(SeriesRepository seriesRepository) {
        this.playlistRepository = seriesRepository;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NEW_SERIES)
    public void execute(NewSeriesEventConsumer.Data data) {
        Series playlistNew= new Series();
        BeanUtils.copyProperties(data.getSerie(), playlistNew);
        if (data.getSerie().getSeasons() != null && playlistNew.getSeasons() != null) {
            BeanUtils.copyProperties(data.getSerie().getSeasons(),playlistNew.getSeasons());
        }
        playlistRepository.deleteById(data.getSerie().getSerieId());
        playlistRepository.save(playlistNew);
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;
        private Data.SerieDto serie = new SerieDto();

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class SerieDto implements Serializable {

            @Serial
            private static final long serialVersionUID = 1L;
            private Long serieId;
            private String name;
            private Integer mgCount;
            private List<Data.SerieDto.SeasonDto> seasons = new ArrayList<>();

            @Getter
            @Setter
            @NoArgsConstructor
            @AllArgsConstructor
            public static class SeasonDto implements Serializable {

                @Serial
                private static final long serialVersionUID = 1L;
                private Long seasonId;
                private Integer seasonNumber;
                private List<Data.SerieDto.SeasonDto.ChapterDto> chapters = new ArrayList<>();

                @Getter
                @Setter
                @NoArgsConstructor
                @AllArgsConstructor
                public static class ChapterDto implements Serializable {

                    @Serial
                    private static final long serialVersionUID = 1L;
                    private Long chapterId;
                    private String name;
                    private Integer number;
                    private String urlStream;

                }
            }
        }

    }
}