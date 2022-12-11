package com.dh.catalog.model.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SeasonDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer seasonId;

    private Integer seasonNumber;

    private List<ChapterDTO> chaptersDTO = new ArrayList<>();

}