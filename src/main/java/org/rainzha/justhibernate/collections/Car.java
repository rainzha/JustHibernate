package org.rainzha.justhibernate.collections;

import lombok.Data;

@Data
public class Car {
    private int id;
    private String name = null;
    private String color = null;

    public Car() {

    }

    public Car(String name, String color) {
        setName(name);
        setColor(color);
    }
}
