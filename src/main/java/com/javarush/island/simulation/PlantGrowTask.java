package com.javarush.island.simulation;

import com.javarush.island.model.Island;
import com.javarush.island.model.Location;
import com.javarush.island.model.Plant;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class PlantGrowTask {
    private Island island;

    public PlantGrowTask (Island island){
        this.island=island;
    }

    public void grow(){
        Random random = new Random();

        for (int i = 0; i < island.getRows(); i++) {
            for (int j = 0; j < island.getCols(); j++) {

                Location location = island.getLocation(i,j);

                if (random.nextDouble()<0.3){
                    location.addPlant(new Plant());
                }
            }
        }
    log.info("Растение растет");
    }
}
