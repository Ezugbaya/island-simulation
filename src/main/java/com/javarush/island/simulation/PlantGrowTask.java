package com.javarush.island.simulation;

import com.javarush.island.model.Island;
import com.javarush.island.model.Location;
import com.javarush.island.model.Plant;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class PlantGrowTask {
    private Island island;

    public PlantGrowTask(Island island) {
        this.island = island;
    }

    public void grow() {

        for (int i = 0; i < island.getRows(); i++) {
            for (int j = 0; j < island.getCols(); j++) {
                Location location = island.getLocation(i, j);
                int grow = (int) (Math.random() * 15);
                for (int k = 0; k < grow; k++) {
                    location.addPlant(new Plant());
                }
            }
        }
        log.info("Растение растет");
    }
}
