package com.arcia;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

/**
 * FireField
 */
public class FireField {

  // classic flame
  private static final Color[] FIRE_COLORS = ColorSchemes.CLASSIC;

  private static final int ROWS_TO_BURN = 2;
  private static final int ROW_BURN_INTENSITY = Math.max(FIRE_COLORS.length, 0);

  private Wind wind = new Wind();

  private FirePixel[][] field;
  private int height, width, fireSize;

  public FireField(int height, int width, int fireSize) {
    this.height = height;
    this.width = width;
    this.fireSize = fireSize;
    initField();
  }

  private void initField() {
    int widthInPixels = width / fireSize;
    int heightInPixels = height / fireSize;
    field = new FirePixel[widthInPixels][heightInPixels];
    for (int i = 0; i < widthInPixels; i++) {
      field[i] = new FirePixel[heightInPixels];
      for (int j = 0; j < heightInPixels; j++) {
        boolean shouldBurnPixel = heightInPixels - ROWS_TO_BURN < j;
        int intensity = shouldBurnPixel ? ROW_BURN_INTENSITY : 0;
        int x = i * fireSize;
        int y = j * fireSize;
        field[i][j] = new FirePixel(x, y, intensity, fireSize);
      }
    }
  }

  /**
   * @return the fIRE_COLORS
   */
  public static Color[] getFIRE_COLORS() {
    return FIRE_COLORS;
  }

  /**
   * finds the pixel at the given x, y coordinates
   */
  public FirePixel getPixel(int x, int y) {
    int pixelX = x / fireSize;
    int pixelY = y / fireSize;
    if (pixelX >= 0 && field.length > pixelX) {
      if (pixelY >= 0 && field[pixelX].length > pixelY) {
        return field[pixelX][pixelY];
      }
    }
    return null;
  }

  private void ignitePixel(int x, int y, int intensity) {
    FirePixel pixel = getPixel(x, y);
    if (pixel != null) {
      pixel.intensity = intensity;
    }
  }

  public void lightFire(int x, int y, int intensity, int pixelCount) {
    int[][] directions = new int[][] { { 1, 0 }, { 1, -1 }, { 0, 1 }, { -1, 1 }, { 1, 1 }, { -1, 0 }, { -1, 1 },
        { 0, -1 }, { 1, -1 }, { -1, -1 } };
    for (int i = 0; i < pixelCount; i++) {
      for (int j = 0; j < pixelCount; j++) {
        for (int[] dirs : directions) {
          int xOffset = i * dirs[0] * fireSize;
          int yOffset = j * dirs[1] * fireSize;
          ignitePixel(x + xOffset, y + yOffset,
              ThreadLocalRandom.current().nextInt((int) Math.round(intensity * .8), intensity + 4));
        }
      }
    }
  }

  private void coolFireNaturally(FirePixel firePixel) {
    firePixel.intensity = ThreadLocalRandom.current().nextDouble() > .0175 ? Math.max(firePixel.intensity - 1, 0)
        : firePixel.intensity;
    // firePixel.intensity = Math.max(firePixel.intensity - 1, 0);
  }

  private void spreadFire(FirePixel firePixel) {
    if (firePixel.intensity > 1) {
      var rand = ThreadLocalRandom.current();
      for (int i = 0; i < rand.nextInt(4); i++) {
        int dx = rand.nextDouble(1) > .15 ? (int) (rand.nextDouble(-1.0, 1.0) * firePixel.size) : 0;
        var dxVector = new Vector(new double[] { dx });
        dx = dx + wind.getForce(dxVector);
        int dy = rand.nextInt(-2, 1) * firePixel.size;
        int newFireX = firePixel.x + dx;
        int newFireY = firePixel.y + dy;
        FirePixel neighbor = getPixel(newFireX, newFireY);
        if (neighbor != null && (neighbor.x != firePixel.x || neighbor.y != firePixel.y)) {
          if (neighbor.intensity > firePixel.intensity) {
            if (firePixel.y < neighbor.y) {
              firePixel.intensity = neighbor.intensity;
            }
          } else {
            if (neighbor.y < firePixel.y) {
              int intensityChange = firePixel.intensity > 1 && rand.nextDouble(1) > .15 ? 1 : 0;
              neighbor.intensity = firePixel.intensity + intensityChange;
            }
          }
        }
      }
    }
  }

  private void updateFirePixels() {
    int rowCount = field.length > 0 ? field[0].length : 0;
    for (FirePixel[] column : field) {
      int j = 0;
      for (FirePixel firePixel : column) {

        // burns the bottom rows
        if (rowCount - j <= ROWS_TO_BURN) {
          firePixel.intensity = ThreadLocalRandom.current().nextInt((int) (ROW_BURN_INTENSITY * .8),
              ROW_BURN_INTENSITY + 1);
        }

        coolFireNaturally(firePixel);
        spreadFire(firePixel);
        j++;
      }
    }
  }

  public void update() {
    wind.update();
    updateFirePixels();
  }

  public void draw(Graphics g) {
    for (FirePixel[] column : field) {
      for (FirePixel pixel : column) {
        int colorIndex = Math.max(Math.min(pixel.intensity, FIRE_COLORS.length - 1), 0);
        Color color = FIRE_COLORS[colorIndex];
        g.setColor(color);
        g.fillRect(pixel.x, pixel.y, pixel.size, pixel.size);
      }
    }
  }
}