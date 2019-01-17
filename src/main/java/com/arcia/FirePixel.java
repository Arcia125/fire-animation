package com.arcia;

/**
 * FirePixel
 */
public class FirePixel extends Pixel {
  public int intensity, size;

  public FirePixel(int x, int y, int intensity, int size) {
    super(x, y);
    this.intensity = intensity;
    this.size = size;
  }
}