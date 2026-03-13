package com.javarush.island.animal.herbivore;

import com.javarush.island.animal.Animal;
import com.javarush.island.model.Location;

public class WildBoar extends Animal {
    public WildBoar() {
        super("Кабан", 2);
    }

    @Override
    public void eat(Location location) {
    }

    @Override
    public Animal reproduce() {

        if (Math.random() < 0.3) {
            return new WildBoar();
        }

        return null;
    }
}
