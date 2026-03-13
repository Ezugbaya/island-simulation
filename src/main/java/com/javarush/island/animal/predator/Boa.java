package com.javarush.island.animal.predator;

import com.javarush.island.animal.Animal;
import com.javarush.island.model.Location;

public class Boa extends Animal {
    public Boa() {
        super("Удав", 1);
    }

    @Override
    public void eat(Location location) {
    }

    @Override
    public Animal reproduce() {

        if (Math.random() < 0.3) {
            return new Boa();
        }

        return null;
    }
}
