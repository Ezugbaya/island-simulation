package com.javarush.island.animal.predator;

import com.javarush.island.animal.Animal;
import com.javarush.island.model.Location;

public class Fox extends Animal {
    public Fox() {
        super("Лиса", 2);
    }

    @Override
    public void eat(Location location) {
    }

    @Override
    public Animal reproduce() {

        if (Math.random() < 0.3) {
            return new Fox();
        }

        return null;
    }
}
