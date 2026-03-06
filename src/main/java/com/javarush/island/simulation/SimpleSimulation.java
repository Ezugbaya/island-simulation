package com.javarush.island.simulation;

import com.javarush.island.animal.Animal;
import com.javarush.island.model.Island;
import com.javarush.island.model.Location;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

//однопоточная симуляция
@Slf4j
public class SimpleSimulation {
    private Island island;
    private PlantGrowTask plantGrowTask;
    private StaticsTask staticsTask;

    public SimpleSimulation(Island island) {
        this.island = island;
        this.plantGrowTask = new PlantGrowTask(island);
        this.staticsTask = new StaticsTask(island);
    }

    public void tick() {
        for (int i = 0; i < island.getRows(); i++) {
            for (int j = 0; j < island.getCols(); j++) {
                Location location = island.getLocation(i, j);

                List<Animal> copy = new ArrayList<>(location.getAnimals());

                for (Animal animal : copy) {
                    //животное ест
                    animal.eat(location);

                    if (location.getAnimals().size() >1) {

                        Animal child = animal.reproduce();
                        if (child != null) {
                            location.addAnimal(child);

                        }
                    }
                    //животное двигается
                    animal.move(island, i, j);
                }


            }
        }
        plantGrowTask.grow();
        log.info("tick завершен");
        staticsTask.print();
    }

}
