package com.javarush.island.animal.herbivore;

import com.javarush.island.animal.Animal;
import com.javarush.island.model.Location;

public class Caterpillar extends Animal {
    public Caterpillar() {
        super("Гусеница", 0);
    }

    @Override
    public void eat(Location location) {
    }

}
