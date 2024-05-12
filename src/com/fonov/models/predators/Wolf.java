package com.fonov.models.predators;


import com.fonov.models.abstracts.Entity;

public class Wolf extends Predator {
    public Wolf(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Wolf(Entity entity) {
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(), entity.getKgToFullEating());
    }
}
