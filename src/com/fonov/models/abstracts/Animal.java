package com.fonov.models.abstracts;

import com.fonov.service.AnimalAction;

public abstract class Animal extends Entity  implements AnimalAction {

    public int getHealthPercent() {
        return healthPercent;
    }

    public boolean isMovedInThisLap() {
        return isMovedInThisLap;
    }

    private int healthPercent;

    private  boolean isMovedInThisLap;

    protected Animal(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
        this.healthPercent = 100;
        isMovedInThisLap = false;
    }

    @Override
    public void move() {

    }

    @Override
    public void multyply() {

    }

    @Override
    public void chooseDirection() {

    }

    public void decreaseHealthPercent(int decreaseFor){
        this.healthPercent -= decreaseFor;
    }
}
