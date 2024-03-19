package com.chaffinch.lab1.utils;

public class Vector3DProcessor {
    public static Vector3D sum(Vector3D vector1, Vector3D vector2) {
        return new Vector3D(
                vector1.getXCoordinate() + vector2.getXCoordinate(),
                vector1.getYCoordinate() + vector2.getYCoordinate(),
                vector1.getZCoordinate() + vector2.getZCoordinate()
        );
    }

    public static Vector3D difference(Vector3D vector1, Vector3D vector2) {

        return new Vector3D(
                vector1.getXCoordinate() - vector2.getXCoordinate(),
                vector1.getYCoordinate() - vector2.getYCoordinate(),
                vector1.getZCoordinate() - vector2.getZCoordinate()
        );
    }

    public static double scalar(Vector3D vector1, Vector3D vector2) {
        return
                vector1.getXCoordinate() * vector2.getXCoordinate() +
                vector1.getYCoordinate() * vector2.getYCoordinate() +
                vector1.getZCoordinate() * vector2.getZCoordinate();
    }

    public static Vector3D vector(Vector3D vector1, Vector3D vector2) {
        double xCoordinate = Determinant.secondOrder(
                vector1.getYCoordinate(), vector1.getZCoordinate(),
                vector2.getYCoordinate(), vector2.getZCoordinate()
        );

        double yCoordinate = - Determinant.secondOrder(
                vector1.getXCoordinate(), vector1.getZCoordinate(),
                vector2.getXCoordinate(), vector2.getZCoordinate()
        );

        double zCoordinate = Determinant.secondOrder(
                vector1.getXCoordinate(), vector1.getYCoordinate(),
                vector2.getXCoordinate(), vector2.getYCoordinate()
        );

        return new Vector3D(xCoordinate, yCoordinate, zCoordinate);
    }

    public static boolean collinear(Vector3D vector1, Vector3D vector2) {
        double ratio1 = vector1.getXCoordinate() / vector2.getXCoordinate();
        double ratio2 = vector1.getYCoordinate() / vector2.getYCoordinate();
        double ratio3 = vector1.getZCoordinate() / vector2.getZCoordinate();

        return ratio1 == ratio2 && ratio1 == ratio3;
    }
}
