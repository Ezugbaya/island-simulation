package com.javarush.island.animal.herbivore;

import com.javarush.island.animal.Animal;
import com.javarush.island.model.Location;

public class Deer extends Animal {

    public Deer(){
        super("Олень",3);
    }

    @Override
    public void eat(Location location) {
        if (!location.getPlants().isEmpty()) {
            location.getPlants().remove(0);
        }
    }
    @Override
    public Animal reproduce() {
        if (Math.random() < 0.3) {
            return new Deer();
        }
        return null;
    }
}
