package com.javarush.island;

import com.javarush.island.config.SimulationConfig;
import com.javarush.island.model.Island;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class App {

    public static void main(String[] args) {

        // создаем остров
        Island island = new Island(SimulationConfig.ROWS,SimulationConfig.COLS);

        log.info("Создан остров: {} x {}",island.getRows(),island.getCols());
    }
}