package com.chaffinch.lab1.utils;

import java.util.Objects;

public class Vector3D {
    private double xCoordinate, yCoordinate, zCoordinate;

    public Vector3D(double xCoordinate, double yCoordinate, double zCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
    }

    public Vector3D() {
        this.xCoordinate = 0;
        this.yCoordinate = 0;
        this.zCoordinate = 0;
    }

    public Vector3D(Point3D point1, Point3D point2) {
        this.xCoordinate = point1.getXCoordinate() - point2.getXCoordinate();
        this.yCoordinate = point1.getYCoordinate() - point2.getYCoordinate();
        this.zCoordinate = point1.getZCoordinate() - point2.getZCoordinate();
    }

    public double length() {
        return Math.sqrt(Math.pow(xCoordinate, 2) + Math.pow(yCoordinate, 2) + Math.pow(zCoordinate, 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3D vector3D = (Vector3D) o;
        return Double.compare(xCoordinate, vector3D.xCoordinate) == 0 && Double.compare(yCoordinate, vector3D.yCoordinate) == 0 && Double.compare(zCoordinate, vector3D.zCoordinate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate, zCoordinate);
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
    public String toString() {
        return "{X: " + xCoordinate +
                ", Y: " + yCoordinate +
                ", Z: " + zCoordinate +
                '}';
    }
}
