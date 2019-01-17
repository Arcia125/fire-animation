package com.arcia;

/**
 * Vector
 */
public class Vector {

  private final int n;
  private double[] data;

  public Vector(int n) {
    this.n = n;
    this.data = new double[n];
  }

  public Vector(double[] data) {
    n = data.length;
    this.data = data.clone();
    this.data = new double[n];
    for (int i = 0; i < n; i++) {
      set(i, data[i]);
    }
  }

  public int length() {
    return n;
  }

  public void set(int i, double value) {
    data[i] = value;
  }

  public double get(int i) {
    return data[i];
  }

  private void assertSameLengths(Vector other) throws IllegalArgumentException {
    if (length() != other.length()) {
      throw new IllegalArgumentException("Vector#dot failed, Vector other must be the same length.");
    }
  }

  public double dot(Vector other) throws IllegalArgumentException {
    assertSameLengths(other);
    double sum = 0.0;
    for (int i = 0; i < n; i++) {
      sum += (get(i) * other.get(i));
    }
    return sum;
  }

  // Euclidean norm
  public double magnitude() {
    return Math.sqrt(dot(this));
  }

  public double distanceTo(Vector other) throws IllegalArgumentException {
    assertSameLengths(other);
    return minus(other).magnitude();
  }

  public Vector add(Vector other) throws IllegalArgumentException {
    assertSameLengths(other);
    var vector = new Vector(n);
    for (int i = 0; i < n; i++) {
      vector.set(i, get(i) + other.get(i));
    }
    return vector;
  }

  public Vector minus(Vector other) throws IllegalArgumentException {
    assertSameLengths(other);
    var vector = new Vector(n);
    for (int i = 0; i < n; i++) {
      vector.set(i, get(i) - other.get(i));
    }
    return vector;
  }

  public Vector scale(double factor) {
    var vector = new Vector(n);
    for (int i = 0; i < n; i++) {
      vector.set(i, data[i] * factor);
    }
    return vector;
  }

  public Vector direction() throws ArithmeticException {
    if (magnitude() == 0.0) {
      throw new ArithmeticException("zero-vector has no direction");
    }
    return scale(1.0 / magnitude());
  }

  public String toString() {
    var s = new StringBuilder();
    s.append('(');
    for (int i = 0; i < n; i++) {
      s.append(data[i]);
      if (i < n - 1)
        s.append(", ");
    }
    s.append(')');
    return s.toString();
  }
}