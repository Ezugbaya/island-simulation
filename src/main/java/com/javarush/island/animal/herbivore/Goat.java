package com.javarush.island.animal.herbivore;

import com.javarush.island.animal.Animal;
import com.javarush.island.model.Location;

public class Goat extends Animal {
    public Goat() {
        super("Коза",3);
    }

    @Override
    public void eat(Location location) {
    }
}
