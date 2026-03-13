package com.javarush.island;

import com.javarush.island.animal.Animal;
import com.javarush.island.animal.herbivore.*;
import com.javarush.island.animal.predator.*;
import com.javarush.island.config.AnimalConfig;
import com.javarush.island.model.Island;
import com.javarush.island.model.Location;
import com.javarush.island.simulation.MultiSimulation;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class App {

    private static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {

        Island island = new Island(10, 10);
        populateIsland(island);
        MultiSimulation simulation = new MultiSimulation(island);
        for (int i = 0; i < 20; i++) {
            log.info("Шаг: {}", i);
            simulation.tick();
        }
    }

    private static void populateIsland(Island island) {
        Class<?>[] animals = {
                Wolf.class, Boa.class, Fox.class, Bear.class, Eagle.class,
                Horse.class, Deer.class, Rabbit.class, Mouse.class,
                Goat.class, Sheep.class, WildBoar.class,
                Buffalo.class, Duck.class, Caterpillar.class
        };
        for (int i = 0; i < island.getRows(); i++) {
            for (int j = 0; j < island.getCols(); j++) {
                Location location = island.getLocation(i, j);
                for (Class<?> animalClass : animals) {
                    int max = AnimalConfig.maxInCell.get(animalClass);
                    int count = random.nextInt(max / 3);
                    for (int k = 0; k < count; k++) {
                        try {

                            Animal animal =
                                    (Animal) animalClass.getDeclaredConstructor().newInstance();

                            location.addAnimal(animal);

                        } catch (Exception ignored) {
                        }
                    }
                }
            }
        }
    }
}