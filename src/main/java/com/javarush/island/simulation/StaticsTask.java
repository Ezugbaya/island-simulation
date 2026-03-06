package com.javarush.island.simulation;

import com.javarush.island.model.Island;
import com.javarush.island.model.Location;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StaticsTask {

    private Island island;

    public StaticsTask(Island island) {
        this.island = island;
    }

    public void print() {
        int animals = 0;
        int plants = 0;

        for (int i = 0; i < island.getRows(); i++) {
            for (int j = 0; j < island.getCols(); j++) {

                Location location = island.getLocation(i, j);

                animals += location.getAnimals().size();
                plants += location.getPlants().size();
            }
        }
        log.info("Животных: {}", animals);
        log.info("Растений: {}", plants);
    }
}
