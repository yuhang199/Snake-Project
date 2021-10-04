package com.company;

import java.util.Random;

public class Snake {

  private final Random rand = new Random();
  private int len;
  private int[] snakeX;
  private int[] snakeY;
  private int d;
  private Direction direction;

  public Snake() {
    this.snakeX = new int[750];
    this.snakeY = new int[750];
    this.snakeX[0] = (rand.nextInt(34) * 25) + 25;
    this.snakeY[0] = (rand.nextInt(24) * 25) + 75;
    this.len = rand.nextInt(((snakeX[0] - 25) / 25) + 1) + 1;
    for (int i = 1; i < len; ++i) {
      this.snakeX[i] = this.snakeX[0] - (25 * i);
      this.snakeY[i] = this.snakeY[0];
    }
    this.d = rand.nextInt(4);
    if (this.d == 0) {
      direction = Direction.UP;
    } else if (this.d == 1) {
      direction = Direction.DOWN;
    } else if (this.d == 2) {
      direction = Direction.LEFT;
    } else if (this.d == 3){
      direction = Direction.RIGHT;
    }
  }

  public int getLen() {
    return this.len;
  }

  public int getHeadX() {
    return this.snakeX[0];
  }

  public int getHeadY() {
    return this.snakeY[0];
  }

  public int getBodyX(int i) {
    return this.snakeX[i];
  }

  public int getBodyY(int i) {
    return this.snakeY[i];
  }

  public Direction getDirection() {
    return this.direction;
  }

  public void incrementLen() {
    this.len++;
  }

  public void moveSnake() {
    for (int i = this.len - 1; i > 0; --i) {
      this.snakeX[i] = this.snakeX[i - 1];
      this.snakeY[i] = this.snakeY[i - 1];
    }
    if (this.direction == Direction.RIGHT) {
      this.snakeX[0] += 25;
      if (this.snakeX[0] > 850) {
        this.snakeX[0] = 25;
      }
    }else if (this.direction == Direction.LEFT) {
      this.snakeX[0] -= 25;
      if (this.snakeX[0] < 25) {
        this.snakeX[0] = 850;
      }
    }else if (this.direction == Direction.UP) {
      this.snakeY[0] -= 25;
      if (this.snakeY[0] < 75) {
        this.snakeY[0] = 650;
      }
    }else {
      this.snakeY[0] += 25;
      if (this.snakeY[0] > 650) {
        this.snakeY[0] = 75;
      }
    }

  }

  public void setDirection(int n) {
    this.d = n;
    if (this.d == 0) {
      direction = Direction.UP;
    } else if (this.d == 1) {
      direction = Direction.DOWN;
    } else if (this.d == 2) {
      direction = Direction.LEFT;
    } else if (this.d == 3){
      direction = Direction.RIGHT;
    }
  }

  public void initSnake() {
    this.snakeX = new int[1000];
    this.snakeY = new int[1000];
    this.snakeX[0] = (rand.nextInt(34) * 25) + 25;
    this.snakeY[0] = (rand.nextInt(24) * 25) + 75;
    this.len = rand.nextInt(((snakeX[0] - 25) / 25) + 1) + 1;
  }
}
