package com.fonov.models.predators;

//хищник

import com.fonov.models.abstracts.Animal;

public abstract class Predator extends Animal {
    protected Predator(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }
}
