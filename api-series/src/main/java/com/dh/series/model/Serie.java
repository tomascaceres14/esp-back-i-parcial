package com.dh.series.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "Serie")
public class Serie implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Long serieId;

    private String name;

    private String genre;

    private List<Season> seasons;
}
