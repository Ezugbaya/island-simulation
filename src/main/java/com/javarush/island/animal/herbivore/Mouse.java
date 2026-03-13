package com.javarush.island.animal.herbivore;

import com.javarush.island.animal.Animal;
import com.javarush.island.model.Location;

public class Mouse extends Animal {
    public Mouse() {
        super("Мышь", 1);
    }

    @Override
    public void eat(Location location) {
    }

    @Override
    public Animal reproduce() {

        if (Math.random() < 0.3) {
            return new Mouse();
        }

        return null;
    }
}
