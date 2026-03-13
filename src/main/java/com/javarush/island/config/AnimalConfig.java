package com.javarush.island.config;

import com.javarush.island.animal.herbivore.*;
import com.javarush.island.animal.predator.*;

import java.util.HashMap;
import java.util.Map;

public class AnimalConfig {

    public static final Map<Class<?>, Double> weight = new HashMap<>();
    public static final Map<Class<?>, Integer> maxInCell = new HashMap<>();
    public static final Map<Class<?>, Integer> speed = new HashMap<>();
    public static final Map<Class<?>, Double> foodNeeded = new HashMap<>();

    static {
        // Волк
        weight.put(Wolf.class, 50.0);
        maxInCell.put(Wolf.class, 30);
        speed.put(Wolf.class, 3);
        foodNeeded.put(Wolf.class, 8.0);

        // Удав
        weight.put(Boa.class, 15.0);
        maxInCell.put(Boa.class, 30);
        speed.put(Boa.class, 1);
        foodNeeded.put(Boa.class, 3.0);

        // Лиса
        weight.put(Fox.class, 8.0);
        maxInCell.put(Fox.class, 30);
        speed.put(Fox.class, 2);
        foodNeeded.put(Fox.class, 2.0);

        // Медведь
        weight.put(Bear.class, 500.0);
        maxInCell.put(Bear.class, 5);
        speed.put(Bear.class, 2);
        foodNeeded.put(Bear.class, 80.0);

        // Орел
        weight.put(Eagle.class, 6.0);
        maxInCell.put(Eagle.class, 20);
        speed.put(Eagle.class, 3);
        foodNeeded.put(Eagle.class, 1.0);

        // Лошадь
        weight.put(Horse.class, 400.0);
        maxInCell.put(Horse.class, 20);
        speed.put(Horse.class, 4);
        foodNeeded.put(Horse.class, 60.0);

        // Олень
        weight.put(Deer.class, 300.0);
        maxInCell.put(Deer.class, 20);
        speed.put(Deer.class, 4);
        foodNeeded.put(Deer.class, 50.0);

        // Кролик
        weight.put(Rabbit.class, 2.0);
        maxInCell.put(Rabbit.class, 150);
        speed.put(Rabbit.class, 2);
        foodNeeded.put(Rabbit.class, 0.45);

        // Мышь
        weight.put(Mouse.class, 0.05);
        maxInCell.put(Mouse.class, 500);
        speed.put(Mouse.class, 1);
        foodNeeded.put(Mouse.class, 0.01);

        // Коза
        weight.put(Goat.class, 60.0);
        maxInCell.put(Goat.class, 140);
        speed.put(Goat.class, 3);
        foodNeeded.put(Goat.class, 10.0);

        // Овца
        weight.put(Sheep.class, 70.0);
        maxInCell.put(Sheep.class, 140);
        speed.put(Sheep.class, 3);
        foodNeeded.put(Sheep.class, 15.0);

        // Кабан
        weight.put(WildBoar.class, 400.0);
        maxInCell.put(WildBoar.class, 50);
        speed.put(WildBoar.class, 2);
        foodNeeded.put(WildBoar.class, 50.0);

        // Буйвол
        weight.put(Buffalo.class, 700.0);
        maxInCell.put(Buffalo.class, 10);
        speed.put(Buffalo.class, 3);
        foodNeeded.put(Buffalo.class, 100.0);

        // Утка
        weight.put(Duck.class, 1.0);
        maxInCell.put(Duck.class, 200);
        speed.put(Duck.class, 4);
        foodNeeded.put(Duck.class, 0.15);

        // Гусеница
        weight.put(Caterpillar.class, 0.01);
        maxInCell.put(Caterpillar.class, 1000);
        speed.put(Caterpillar.class, 0);
        foodNeeded.put(Caterpillar.class, 0.0);
    }
}
