package com.fonov.models.herbivores;

import com.fonov.models.abstracts.Entity;
import com.fonov.models.predators.Predator;

public class Buffalo extends Predator {
    public Buffalo(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }
    public Buffalo(Entity entity) {
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(), entity.getKgToFullEating());
    }
}
