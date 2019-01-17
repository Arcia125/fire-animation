package com.arcia;

/**
 * Effect
 */
public class Force {
  public Vector changeVector;
  public Vector accellerationVector;

  public Force() {
    this.changeVector = new Vector(new double[] { 0 });
    this.accellerationVector = new Vector(new double[] { 0 });
  }

  public Force(Vector changeVector, Vector accellerationVector) {
    assert (changeVector.length() == accellerationVector.length());
    this.changeVector = changeVector;
    this.accellerationVector = accellerationVector;
  }

  public void setAccellerationVector(Vector accellerationVector) {
    this.accellerationVector = accellerationVector;
  }

  public void adjustAccellerationVector(Vector other) {
    this.setAccellerationVector(accellerationVector.add(other));
  }

  public void update() {
    changeVector = changeVector.add(accellerationVector);
  }

  public Vector apply(Vector subjectVector) {
    return subjectVector.add(changeVector);
  }

}