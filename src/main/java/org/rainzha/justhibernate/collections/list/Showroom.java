package org.rainzha.justhibernate.collections.list;

import lombok.Data;
import org.rainzha.justhibernate.collections.Car;

import java.util.List;

@Data
public class Showroom {
    private int id = 0;
    private String manager = null;
    private String location = null;
    private List<Car> cars = null;
}
