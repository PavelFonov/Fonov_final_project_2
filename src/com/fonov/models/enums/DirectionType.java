package com.fonov.models.enums;

public enum DirectionType {
    LEFT(-1),
    RIGHT(1),
    UP(-1),
    DOWN(1);
    private int directionNumber;

    DirectionType(int directionNumber) {
        this.directionNumber = directionNumber;
    }

    public int getDirectionDigit() {
        return directionNumber;
    }
}
