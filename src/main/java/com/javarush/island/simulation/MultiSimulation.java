package com.javarush.island.simulation;


import com.javarush.island.animal.Animal;
import com.javarush.island.model.Island;
import com.javarush.island.model.Location;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class MultiSimulation {
    private Island island;

    //пул потоков
    private ExecutorService executor = Executors.newFixedThreadPool(8);
    private PlantGrowTask plantGrowTask;
    private StaticsTask staticsTask;

    public MultiSimulation(Island island) {

        this.island = island;
        this.plantGrowTask = new PlantGrowTask(island);
        this.staticsTask = new StaticsTask(island);
    }

    public void tick() throws InterruptedException {
        List<Callable<Void>> tasks = new ArrayList<>();

        for (int i = 0; i < island.getRows(); i++) {
            for (int j = 0; j < island.getCols(); j++) {

                Location location = island.getLocation(i, j);

                List<Animal> copy = new ArrayList<>(location.getAnimals());

                for (Animal animal : copy) {
                    tasks.add(new AnimalLifeTask(animal, island, location, i, j));

                }
            }
        }
        //выполняем задачи параллельно
        executor.invokeAll(tasks);
        plantGrowTask.grow();
        staticsTask.print();
        log.info("Multi tick завершен");
    }
}
