package com.javarush.island.animal.predator;

import com.javarush.island.animal.Animal;
import com.javarush.island.animal.herbivore.Rabbit;
import com.javarush.island.model.Location;

public class Wolf extends Animal {
    public Wolf() {
        super("Волк",3);
    }

    @Override
    public void eat(Location location) {
        for (Animal animal: location.getAnimals()){
            if (!(animal instanceof Wolf)){
                location.removeAnimal(animal);
                break;
            }
        }
    }
}
