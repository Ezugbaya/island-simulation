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

    public SimpleSimulation(Island island){
        this.island = island;
    }

    public void tick(){
        for (int i = 0; i < island.getRows(); i++) {
            for (int j = 0; j < island.getCols(); j++) {
                Location location = island.getLocation(i,j);

                List<Animal> copy = new ArrayList<>(location.getAnimals());

                for (Animal animal:copy){
                    animal.eat(location);
                }
            }
        }
        log.info("tick завершен");
    }

}
