package com.javarush.island.animal.herbivore;

import com.javarush.island.animal.Animal;
import com.javarush.island.model.Location;

public class Rabbit extends Animal {

    public Rabbit() {
        super("Кролик", 2);
    }

    @Override
    public void eat(Location location) {
        if (!location.getPlants().isEmpty()){
            location.getPlants().remove(0);
        }
    }
}
