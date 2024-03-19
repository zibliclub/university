package com.chaffinch.lab1.utils;

import java.util.Objects;

public class Point3D {
    private double xCoordinate, yCoordinate, zCoordinate;

    public Point3D(double xCoordinate, double yCoordinate, double zCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
    }

    public Point3D() {
        this.xCoordinate = 0;
        this.yCoordinate = 0;
        this.zCoordinate = 0;
    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public double getZCoordinate() {
        return zCoordinate;
    }

    public void setZCoordinate(double zCoordinate) {
        this.zCoordinate = zCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return Double.compare(xCoordinate, point3D.xCoordinate) == 0 &&
                Double.compare(yCoordinate, point3D.yCoordinate) == 0 &&
                Double.compare(zCoordinate, point3D.zCoordinate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate, zCoordinate);
    }

    @Override
    public String toString() {
        return "{X: " + xCoordinate +
                ", Y: " + yCoordinate +
                ", Z: " + zCoordinate +
                '}';
    }
}
