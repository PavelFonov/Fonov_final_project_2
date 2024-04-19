package com.fonov.models.abstracts;

import com.fonov.service.AnimalAction;

public abstract class Animal extends Entity  implements AnimalAction {

    private  boolean isMovedInThisLap = false;

    protected Animal(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
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
}
