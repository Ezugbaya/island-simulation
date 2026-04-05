package com.javarush.island.model;

import java.util.Random;

public enum Direction {

    UP,
    DOWN,
    LEFT,
    RIGHT;

    private static final Random random = new Random();

    public static Direction random() {
        return values()[random.nextInt(values().length)];
    }
}
