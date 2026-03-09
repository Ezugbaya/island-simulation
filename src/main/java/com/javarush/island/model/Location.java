package com.javarush.island.model;

import com.javarush.island.animal.Animal;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class Location {
    //животные в клетке
    private List<Animal> animals = new CopyOnWriteArrayList<>();

    //растения
    private List<Plant> plants = new CopyOnWriteArrayList<>();

    public void addAnimal(Animal animal){
        animals.add(animal);
    }
    public void removeAnimal (Animal animal){
        animals.remove(animal);
    }
    public void addPlant (Plant plant){
        plants.add(plant);
    }
}
