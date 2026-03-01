package com.javarush.island.animal.herbivore;

import com.javarush.island.animal.Animal;
import com.javarush.island.model.Location;

public class Sheep extends Animal {
    public Sheep() {
        super("Овца",3);
    }

    @Override
    public void eat(Location location) {
    }
}
