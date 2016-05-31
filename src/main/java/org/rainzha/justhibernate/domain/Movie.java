package org.rainzha.justhibernate.domain;

import lombok.Data;

@Data
public class Movie {
    private int id = 0;
    private String title = null;
    private String synopsis = null;
    private String director = null;
}
