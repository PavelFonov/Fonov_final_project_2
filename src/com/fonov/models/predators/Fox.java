package com.fonov.models.predators;

import com.fonov.models.abstracts.Entity;

public class Fox extends Predator{

    public Fox(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }

    public Fox(Entity entity) {
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(), entity.getKgToFullEating());
    }
}
