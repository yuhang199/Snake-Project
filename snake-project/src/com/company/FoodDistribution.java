package com.company;

import java.util.Random;

public class FoodDistribution {
  private Food[] foods;
  private final Random rand = new Random();

  public FoodDistribution() {
    this.foods = new Food[15];
    for (int i = 0; i < 15; ++i) {
      int type = rand.nextInt(3);
      if (type == 0) {
        this.foods[i] = new NormalFood();
      } else if (type == 1) {
        this.foods[i] = new BonusFood();
      } else {
        this.foods[i] = new Poison();
      }
    }
  }

  public int getSize() {
    return this.foods.length;
  }

  public Food getFood(int index) {
    return this.foods[index];
  }

  public int getFoodPoint(int index) {
    return this.foods[index].getPoints();
  }

  public int contains(int x, int y) {
    for (int i = 0; i < this.foods.length; ++i) {
      if (this.foods[i].getFoodX() == x && this.foods[i].getFoodY() == y) {
        return i;
      }
    }
    return -1;
  }

  public void setFood(int index) {
    int type = rand.nextInt(3);
    if (type == 0) {
      this.foods[index] = new NormalFood();
    } else if (type == 1) {
      this.foods[index] = new BonusFood();
    } else {
      this.foods[index] = new Poison();
    }
  }

  public void initFoodDistribution() {
    this.foods = new Food[15];
    for (int i = 0; i < 15; ++i) {
      int type = rand.nextInt(3);
      if (type == 0) {
        this.foods[i] = new NormalFood();
      } else if (type == 1) {
        this.foods[i] = new BonusFood();
      } else if (type == 2){
        this.foods[i] = new Poison();
      }
    }
  }
}
