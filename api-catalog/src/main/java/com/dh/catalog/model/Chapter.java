package com.dh.catalog.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Chapter implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer chapterId;

    private String name;

    private Integer number;

    private String urlStream;

}
