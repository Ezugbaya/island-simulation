package com.javarush.island.simulation;

import com.javarush.island.animal.Animal;
import com.javarush.island.model.Island;
import com.javarush.island.model.Location;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class StaticsTask {

    private final Island island;

    public StaticsTask(Island island) {
        this.island = island;
    }

    public void printStatistics() {
        Map<String, Integer> animals = new HashMap<>();
        int plants = 0;
        for (int i = 0; i < island.getRows(); i++) {
            for (int j = 0; j < island.getCols(); j++) {
                Location location = island.getLocation(i, j);

                // считаем животных
                for (Animal animal : location.getAnimals()) {

                    String name = animal.getClass().getSimpleName();

                    animals.put(name,
                            animals.getOrDefault(name, 0) + 1);
                }

                // считаем растения
                plants += location.getPlants().size();
            }
        }

        log.info("===== Статистика острова =====");
        animals.forEach((animal, count) ->
                log.info("{} : {}", animal, count));
        log.info("Растений : {}", plants);

        int totalAnimals = animals.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

        log.info("Всего животных : {}", totalAnimals);
    }


}
