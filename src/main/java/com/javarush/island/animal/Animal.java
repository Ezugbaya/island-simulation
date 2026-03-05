package com.javarush.island.animal;

import com.javarush.island.model.Island;
import com.javarush.island.model.Location;
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
    public abstract void eat(Location location);

    //размножение
    public Animal reproduce() {
        return null;
    }
}
