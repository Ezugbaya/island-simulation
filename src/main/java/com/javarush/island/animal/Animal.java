package com.javarush.island.animal;

import com.javarush.island.model.Location;
import lombok.Getter;

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
    public void move() {

    }

    //питание
    public abstract void eat(Location location);

    //размножение
    public void reproduce(){

    }
}
