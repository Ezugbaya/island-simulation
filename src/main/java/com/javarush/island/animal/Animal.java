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
    protected int foodLevel = 5;

    public Animal(String name, int speed) {
        this.name = name;
        this.speed = speed;
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
        //попытка съесть животное
        for (Animal prey : location.getAnimals()) {

            //самого себя есть нельзя
            if (prey == this) {
                continue;
            }
            int chance = EatMatrix.getChance(this.getClass(), prey.getClass());
            if (chance > 0 && Math.random() * 100 < chance) {
                location.removeAnimal(prey);
                return;
            }
        }
        //попытка съесть растение
        for (Plant plant : location.getPlants()) {
            int chance = EatMatrix.getChance(this.getClass(), Plant.class);
            if (chance > 0 && Math.random() * 100 < chance) {
                location.getPlants().remove(plant);
                return;
            }
        }
    }

    //размножение
    public Animal reproduce() {
        return null;
    }
}
