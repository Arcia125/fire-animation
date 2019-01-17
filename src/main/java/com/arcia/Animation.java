package com.arcia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Animation
 */
public class Animation extends JPanel implements Runnable {
  private static final long serialVersionUID = -8369113672800677065L;
  static private final double GAME_SPEED = 1.618; // 1.618
  static private final int FIRE_SIZE = 6;
  static private final int TICKS_PER_SECOND = (int) (25 * GAME_SPEED);
  static private final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
  static private final int MAX_FRAME_SKIP = 5;

  private Thread animationThread;
  private Dimension dimension;
  private FireField fireField;

  public Animation() {
    this.dimension = this.getBounds().getSize();
    addComponentListener(new ComponentAdapter() {
      public void componentResized(ComponentEvent event) {
        dimension = getBounds().getSize();
        initFire();
      }
    });
    initFire();
    initAnimation();
  }

  private void initAnimation() {
    setSize(dimension);
    setBackground(Color.BLACK);
    setPreferredSize(dimension);
  }

  private void initFire() {
    fireField = new FireField((int) dimension.height, (int) dimension.width, FIRE_SIZE);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    fireField.draw(g);
    Toolkit.getDefaultToolkit().sync();
  }

  @Override
  public void addNotify() {
    super.addNotify();
    animationThread = new Thread(this);
    animationThread.start();
  }

  public void performUpdateCycle() {
    updateFire();
  }

  public void updateFire() {
    Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
    fireField.lightFire(mouseLocation.x, mouseLocation.y, FireField.getFIRE_COLORS().length - 1, 2);
    fireField.update();
  }

  public void run() {
    long startTime, endTime, sleepDuration, nextGameTick = System.currentTimeMillis();
    int loops = 0;
    while (true) {
      startTime = System.currentTimeMillis();
      loops = 0;
      while (startTime > nextGameTick && loops < MAX_FRAME_SKIP) {
        performUpdateCycle();
        nextGameTick += SKIP_TICKS;
        loops++;
      }
      repaint();
      endTime = System.currentTimeMillis();
      sleepDuration = Math.max(nextGameTick - endTime, 1);
      try {
        Thread.sleep(sleepDuration);
      } catch (InterruptedException e) {
        String message = String.format("Thread interrupted: %s", e.getMessage());
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }
}