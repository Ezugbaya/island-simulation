package com.javarush.island.animal;

import com.javarush.island.config.EatMatrix;
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
        Random random = new Random();

        int dx = random.nextInt(3) - 1;
        int dy = random.nextInt(3) - 1;

        int newX = x + dx;
        int newY = y + dy;

        newX = Math.max(0, Math.min(island.getRows() - 1, newX));
        newY = Math.max(0, Math.min(island.getCols() - 1, newY));

        if (newX == x && newY == y) {
            return;
        }

        island.getLocation(newX, newY).addAnimal(this);
        island.getLocation(x, y).removeAnimal(this);

        //System.out.println(name + " передвинулся");
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
        foodLevel -= 1;
    }

    //проверка смерти
    public boolean isDead() {
        return foodLevel <= 0;
    }

    //размножение
    public Animal reproduce() {
        return null;
    }
}
