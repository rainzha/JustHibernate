package org.rainzha.justhibernate.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Movie {
    private int id = 0;
    private String title = null;
    private String synopsis = null;
    private String director = null;
    private LocalDateTime createTime = null;
}
