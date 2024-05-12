package com.fonov.models.predators;

import com.fonov.models.abstracts.Entity;

public class Eagle extends Predator{

    public Eagle(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }
    public Eagle(Entity entity) {
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(), entity.getKgToFullEating());
    }
}
