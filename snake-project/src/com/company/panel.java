package com.company;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.InputStream;

public class panel extends JPanel implements KeyListener, ActionListener {
  private ImageIcon title;
  private ImageIcon body;
  private ImageIcon up;
  private ImageIcon down;
  private ImageIcon left;
  private ImageIcon right;
  private ImageIcon food;
  private Snake snake;
  private int score;
  private Food snakeFood;
  private boolean isStarted;
  private boolean isFailed;
  private Timer timer;

  public panel() throws LineUnavailableException {
    this.title = new ImageIcon("title.jpg");
    this.body = new ImageIcon("body.png");
    this.up = new ImageIcon("up.png");
    this.down = new ImageIcon("down.png");
    this.left = new ImageIcon("left.png");
    this.right = new ImageIcon("right.png");
    this.food = new ImageIcon("food.png");
    this.snake = new Snake();
    this.snakeFood = new Food();
    this.isStarted = false;
    this.isFailed = false;
    this.score = 0;
    this.setFocusable(true);
    this.addKeyListener(this);
    this.timer = new Timer(100, this);
    this.timer.start();
    playBGM();
  }

  private void playBGM() {
    try {
    Clip bgm = AudioSystem.getClip();
    InputStream is = this.getClass().getClassLoader().getResourceAsStream("")
    }catch (LineUnavailableException e) {
      e.printStackTrace();
    }
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.setBackground(Color.WHITE);
    title.paintIcon(this, g, 25, 11);

    g.fillRect(25, 75, 850, 600);
    g.setColor(Color.WHITE);
    g.drawString("Score: " + this.score, 750, 50);

    if (snake.getDirection() == Direction.RIGHT) {
      right.paintIcon(this, g, snake.getHeadX(), snake.getHeadY());
    } else if (snake.getDirection() == Direction.LEFT) {
      left.paintIcon(this, g, snake.getHeadX(), snake.getHeadY());
    } else if (snake.getDirection() == Direction.UP) {
      up.paintIcon(this, g, snake.getHeadX(), snake.getHeadY());
    } else if (snake.getDirection() == Direction.DOWN) {
      down.paintIcon(this, g, snake.getHeadX(), snake.getHeadY());
    }
    g.setColor(Color.WHITE);
    g.setFont(new Font("arial", Font.BOLD, 40));

    for (int i = 1; i < snake.getLen(); ++i) {
      body.paintIcon(this, g, snake.getBodyX(i), snake.getBodyY(i));
    }

    food.paintIcon(this, g, snakeFood.getFoodX(), snakeFood.getFoodY());

    if (!this.isStarted) {
      g.drawString("Press Space To Start", 250, 500);
    }
    if (this.isFailed) {
      g.setColor(Color.RED);
      g.drawString("Failed: Press Space To Restart", 200, 500);
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {}

  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_SPACE) {
      if (this.isFailed) {
        this.isFailed = false;
        this.snake.initSnake();
        this.score = 0;
      } else {
        this.isStarted = !this.isStarted;
      }
      repaint();
    } else if (keyCode == KeyEvent.VK_LEFT) {
      this.snake.setDirection(2);
    } else if (keyCode == KeyEvent.VK_RIGHT) {
      this.snake.setDirection(3);
    } else if (keyCode == KeyEvent.VK_UP) {
      this.snake.setDirection(0);
    } else if (keyCode == KeyEvent.VK_DOWN) {
      this.snake.setDirection(1);
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {}

  @Override
  public void actionPerformed(ActionEvent e) {
    if (isStarted && !isFailed) {
      snake.moveSnake();
      if (eaten()) {
        this.snake.incrementLen();
        this.snakeFood = new Food();
        score++;
      }
      setFailed();
      repaint();
    }

    timer.start();
  }

  public boolean eaten() {
    if (this.snake.getHeadX() == this.snakeFood.getFoodX()
        && this.snake.getHeadY() == this.snakeFood.getFoodY()) {
      return true;
    }
    return false;
  }

  public void setFailed() {
    for (int i = 1; i < this.snake.getLen(); ++i) {
      if (this.snake.getHeadX() == this.snake.getBodyX(i)
          && this.snake.getHeadY() == this.snake.getBodyY(i)) {
        this.isFailed = true;
      }
    }
  }
}
