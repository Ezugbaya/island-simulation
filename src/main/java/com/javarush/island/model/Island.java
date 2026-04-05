package com.javarush.island.model;

public class Island {
    private Location[][] locations;

    public Island(int rows, int cols) {
        locations = new Location[rows][cols];

        //создаем клетки
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                locations[i][j] = new Location();
            }
        }
    }

    public Location getLocation(int x, int y) {
        return locations[x][y];
    }

    public int getRows() {
        return locations.length;
    }

    public int getCols() {
        return locations[0].length;
    }
}
