package com.dh.catalog.model.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChapterDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer chapterId;

    private String name;

    private Integer number;

    private String urlStream;
}
