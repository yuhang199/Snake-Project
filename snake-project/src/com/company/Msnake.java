package com.company;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;

public class Msnake {

  public static void main(String[] args) throws LineUnavailableException {
    JFrame frame = new JFrame();
    frame.setBounds(10, 10, 900, 720);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new panel());

    frame.setVisible(true);
  }
}
