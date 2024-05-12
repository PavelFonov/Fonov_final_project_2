package com.fonov.models.predators;

import com.fonov.models.abstracts.Entity;

public class Snake extends Predator{

    public Snake(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }
    public Snake(Entity entity) {
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(), entity.getKgToFullEating());
    }
}
