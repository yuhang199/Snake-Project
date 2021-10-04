package com.company;

import java.util.Random;

public class Food {
    private int foodX;
    private int foodY;
    private final Random rand = new Random();

    public Food () {
        this.foodX = (rand.nextInt(34) * 25) + 25;
        this.foodY = (rand.nextInt(24) * 25) + 75;
    }

    public int getFoodX() {
        return this.foodX;
    }

    public int getFoodY() {
        return this.foodY;
    }
}
