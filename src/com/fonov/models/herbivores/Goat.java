package com.fonov.models.herbivores;

import com.fonov.models.abstracts.Entity;
import com.fonov.models.predators.Predator;

public class Goat extends Predator {
    public Goat(Entity entity) {
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(), entity.getKgToFullEating());
    }

    public Goat(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }
}
