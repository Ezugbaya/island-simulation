package com.javarush.island.config;

import com.javarush.island.animal.Animal;
import com.javarush.island.animal.herbivore.*;
import com.javarush.island.animal.predator.*;
import com.javarush.island.model.Plant;

import java.util.HashMap;
import java.util.Map;

public class EatMatrix {
    private static final Map<Class<?>, Map<Class<?>, Integer>> matrix = new HashMap<>();

    static {
        //волк
        Map<Class<?>, Integer> wolf = new HashMap<>();
        wolf.put(Horse.class, 10);
        wolf.put(Deer.class, 15);
        wolf.put(Rabbit.class, 60);
        wolf.put(Mouse.class, 80);
        wolf.put(Goat.class, 60);
        wolf.put(Sheep.class, 70);
        wolf.put(WildBoar.class, 15);
        wolf.put(Buffalo.class, 10);
        wolf.put(Duck.class, 40);
        matrix.put(Wolf.class, wolf);

        //удав
        Map<Class<?>, Integer> boa = new HashMap<>();
        boa.put(Fox.class, 15);
        boa.put(Rabbit.class, 20);
        boa.put(Mouse.class, 40);
        boa.put(Duck.class, 10);
        matrix.put(Boa.class, boa);

        //лиса
        Map<Class<?>, Integer> fox = new HashMap<>();
        fox.put(Rabbit.class, 70);
        fox.put(Mouse.class, 90);
        fox.put(Duck.class, 60);
        fox.put(Caterpillar.class, 40);
        matrix.put(Fox.class, fox);

        //медведь
        Map<Class<?>, Integer> bear = new HashMap<>();
        bear.put(Boa.class, 80);
        bear.put(Horse.class, 40);
        bear.put(Deer.class, 80);
        bear.put(Rabbit.class, 80);
        bear.put(Mouse.class, 90);
        bear.put(Goat.class, 70);
        bear.put(Sheep.class, 70);
        bear.put(WildBoar.class, 50);
        bear.put(Buffalo.class, 20);
        bear.put(Duck.class, 10);
        matrix.put(Bear.class, bear);

        //орел
        Map<Class<?>, Integer> eagle = new HashMap<>();
        eagle.put(Fox.class, 10);
        eagle.put(Rabbit.class, 90);
        eagle.put(Mouse.class, 90);
        eagle.put(Duck.class, 80);
        matrix.put(Eagle.class, eagle);

        //лошадь
        Map<Class<?>, Integer> horse = new HashMap<>();
        horse.put(Plant.class, 100);
        matrix.put(Horse.class, horse);

        //олень
        Map<Class<?>, Integer> deer = new HashMap<>();
        deer.put(Plant.class, 100);
        matrix.put(Deer.class, deer);

        //кролик
        Map<Class<?>, Integer> rabbit = new HashMap<>();
        rabbit.put(Plant.class, 100);
        matrix.put(Rabbit.class, rabbit);

        //мышь
        Map<Class<?>, Integer> mouse = new HashMap<>();
        mouse.put(Plant.class, 100);
        mouse.put(Caterpillar.class, 90);
        matrix.put(Mouse.class, mouse);

        //коза
        Map<Class<?>, Integer> goat = new HashMap<>();
        goat.put(Plant.class, 100);
        matrix.put(Goat.class, goat);

        //овца
        Map<Class<?>, Integer> sheep = new HashMap<>();
        sheep.put(Plant.class, 100);
        matrix.put(Sheep.class, sheep);

        //кабан
        Map<Class<?>, Integer> wildBoar = new HashMap<>();
        wildBoar.put(Mouse.class, 50);
        wildBoar.put(Caterpillar.class, 90);
        matrix.put(WildBoar.class, wildBoar);

        //буйвол
        Map<Class<?>, Integer> buffalo = new HashMap<>();
        buffalo.put(Plant.class, 100);
        matrix.put(Buffalo.class, buffalo);

        //утка
        Map<Class<?>, Integer> duck = new HashMap<>();
        duck.put(Caterpillar.class, 90);
        duck.put(Plant.class, 100);
        matrix.put(Duck.class, duck);

        //гусеница
        Map<Class<?>, Integer> caterpillar = new HashMap<>();
        caterpillar.put(Plant.class, 100);
        matrix.put(Caterpillar.class, caterpillar);
    }
    public static int getChance(Class<?> predator, Class<?> prey) {

        Map<Class<?>, Integer> diet = matrix.get(predator);

        if (diet == null) {
            return 0;
        }

        return diet.getOrDefault(prey, 0);
    }
}
