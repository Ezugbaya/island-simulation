package com.javarush.island.animal.herbivore;

import com.javarush.island.animal.Animal;
import com.javarush.island.model.Location;

public class Duck extends Animal {

    public Duck() {
        super("Утка",4);
    }

    @Override
    public void eat(Location location) {
    }
}
