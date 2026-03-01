package com.javarush.island.model;

import com.javarush.island.animal.Animal;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Location {
    //животные в клетке
    private List<Animal> animals = new ArrayList<>();

    //растения
    private List<Plant> plants = new ArrayList<>();

    public void addAnimal(Animal animal){
        animals.add(animal);
    }
    public void removeAnimal (Animal animal){
        animals.remove(animal);
    }
}
