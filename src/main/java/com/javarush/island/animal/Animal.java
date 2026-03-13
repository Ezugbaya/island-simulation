package com.javarush.island.animal;

import com.javarush.island.config.AnimalConfig;
import com.javarush.island.config.EatMatrix;
import com.javarush.island.model.Direction;
import com.javarush.island.model.Island;
import com.javarush.island.model.Location;
import com.javarush.island.model.Plant;
import lombok.Getter;

import java.util.Random;

@Getter
public abstract class Animal {
    // имя животного
    protected String name;

    // скорость передвижения
    protected int speed;

    // сытость
    protected double foodLevel;

    //мах сытость
    protected double maxFood;

    public Animal(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public Animal(double maxFood) {
        this.maxFood = maxFood;
        this.foodLevel = maxFood / 2;   // животное стартует наполовину сытым
    }

    //движение
    public void move(Island island, int x, int y) {

        int speed = AnimalConfig.speed.get(this.getClass());

        // если скорость 0 — животное не двигается
        if (speed == 0) {
            return;
        }

        int newX = x;
        int newY = y;

        // случайное количество шагов (не больше speed)
        int steps = (int) (Math.random() * speed) + 1;

        for (int i = 0; i < steps; i++) {

            Direction direction = Direction.random();

            switch (direction) {
                case UP -> newX--;
                case DOWN -> newX++;
                case LEFT -> newY--;
                case RIGHT -> newY++;
            }

            // проверяем границы острова
            if (newX < 0 || newY < 0 ||
                    newX >= island.getRows() ||
                    newY >= island.getCols()) {

                return;
            }
        }
        Location oldLocation = island.getLocation(x, y);
        Location newLocation = island.getLocation(newX, newY);

        oldLocation.removeAnimal(this);
        newLocation.addAnimal(this);
    }

    //питание
    public void eat(Location location) {

        // пытаемся съесть животное
        for (Animal prey : location.getAnimals()) {
            if (prey == this) continue;
            int chance = EatMatrix.getChance(this.getClass(), prey.getClass());
            if (chance > 0 && Math.random() * 100 < chance) {
                location.removeAnimal(prey);
                foodLevel = Math.min(maxFood, foodLevel + 1);
                return;
            }
        }

        // пытаемся съесть растение
        for (Plant plant : location.getPlants()) {
            int chance = EatMatrix.getChance(this.getClass(), Plant.class);
            if (chance > 0 && Math.random() * 100 < chance) {
                location.getPlants().remove(plant);
                foodLevel = Math.min(maxFood, foodLevel + 1);
                return;
            }
        }
    }

    //уменьшение сытости
    public void loseFood() {
        foodLevel -= maxFood * 0.2;
    }

    //проверка смерти
    public boolean isDead() {
        return foodLevel <= 0;
    }

    //размножение
    public Animal reproduce(Location location) {

        long sameAnimals = location.getAnimals()
                .stream()
                .filter(a -> a.getClass() == this.getClass())
                .count();

        if (sameAnimals >= 2 && Math.random() < 0.01) { // 10% шанс
            try {
                return this.getClass().getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                return null;
            }
        }

        return null;
    }
}
