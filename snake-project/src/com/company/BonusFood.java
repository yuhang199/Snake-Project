package com.company;

import java.util.Random;

public class BonusFood implements Food {
  private final int foodX;
  private final int foodY;
  private final int points = 2;
  private String name = "Bonus";

  public BonusFood() {
    Random rand = new Random();
    this.foodX = (rand.nextInt(34) * 25) + 25;
    this.foodY = (rand.nextInt(24) * 25) + 75;
  }

  @Override
  public int getFoodX() {
    return this.foodX;
  }

  @Override
  public int getFoodY() {
    return this.foodY;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getPoints() {
    return this.points;
  }
}
