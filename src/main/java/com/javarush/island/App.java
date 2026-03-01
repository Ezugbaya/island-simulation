package com.javarush.island;

import com.javarush.island.animal.herbivore.Deer;
import com.javarush.island.animal.herbivore.Rabbit;
import com.javarush.island.animal.predator.Wolf;
import com.javarush.island.model.Island;
import com.javarush.island.model.Location;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class App {

    public static void main(String[] args) {

        Island island = new Island(10, 10);

        Location location = island.getLocation(2, 2);

        location.addAnimal(new Rabbit());
        location.addAnimal(new Deer());
        location.addAnimal(new Wolf());

        location.getAnimals()
                .forEach(a -> log.info(a.getName()));
    }
}