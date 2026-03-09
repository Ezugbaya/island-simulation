package com.javarush.island.simulation;

import com.javarush.island.animal.Animal;
import com.javarush.island.model.Island;
import com.javarush.island.model.Location;

import java.util.concurrent.Callable;

// Жизнь животного
public class AnimalLifeTask implements Callable<Void> {

    private Animal animal;
    private Island island;
    private Location location;
    private int x;
    private int y;

    public AnimalLifeTask(Animal animal, Island island, Location location, int x, int y) {
        this.animal = animal;
        this.island = island;
        this.location = location;
        this.x = x;
        this.y = y;
    }

    @Override
    public Void call() throws Exception {
        //животное есть
        animal.eat(location);

        //размножение
        Animal child = animal.reproduce();

        if (child != null){
            location.addAnimal(child);
        }

        //движение
        animal.move(island,x,y);
        return null;
    }
}
