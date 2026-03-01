package com.javarush.island.animal.predator;

import com.javarush.island.animal.Animal;
import com.javarush.island.model.Location;

public class Bear extends Animal {
    public Bear() {
        super("Медведь",2);
    }

    @Override
    public void eat(Location location) {
    }
}
