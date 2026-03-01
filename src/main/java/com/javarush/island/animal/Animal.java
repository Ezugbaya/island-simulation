package com.javarush.island.animal;

import com.javarush.island.model.Location;
import lombok.Getter;

@Getter
public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat(Location location);
}
