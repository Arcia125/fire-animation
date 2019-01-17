package com.arcia;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Wind
 */
public class Wind extends Force {
  public Wind() {
    super();
  }

  @Override
  public void update() {
    var currentXSpeed = changeVector.get(0);
    // normal
    var minX = -.04;
    var maxX = .04;
    var minXAcc = -.0015;
    var maxXAcc = .001;
    // fast
    // var minX = -.4;
    // var maxX = .4;
    // var minXAcc = -.15;
    // var maxXAcc = .1;
    // ridiculous
    // var minX = -400;
    // var maxX = 400;
    // var minXAcc = -.2;
    // var maxXAcc = .2;
    double lowerBound = currentXSpeed > minX ? minXAcc : 0;
    double upperBound = currentXSpeed > maxX ? 0 : maxXAcc;
    var adjustment = new Vector(new double[] {
        Math.max(Math.min(ThreadLocalRandom.current().nextDouble(lowerBound, upperBound), maxXAcc), minXAcc) });
    adjustAccellerationVector(adjustment);
    super.update();
  }

  public int getForce(Vector vector) {
    return (int) apply(vector).get(0);
  }
}