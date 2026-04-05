package com.javarush.island.model;

import com.javarush.island.animal.Animal;
import com.javarush.island.config.AnimalConfig;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.javarush.island.model.Plant.MAX_PLANTS;

@Getter
public class Location {
    //животные в клетке
    private List<Animal> animals = new CopyOnWriteArrayList<>();

    //растения
    private List<Plant> plants = new CopyOnWriteArrayList<>();

    public void addAnimal(Animal animal) {

        int max = AnimalConfig.maxInCell.get(animal.getClass());

        long count = animals.stream().filter(a -> a.getClass() == animal.getClass()).count();

        if (count < max) {
            animals.add(animal);
        }
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public void addPlant(Plant plant) {

        if (plants.size() < MAX_PLANTS) {
            plants.add(plant);
        }
    }
}
