package com.fonov.models.herbivores;

import com.fonov.models.abstracts.Entity;

public class Sheep extends Herbivore{
    public Sheep(Entity entity) {
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(), entity.getKgToFullEating());
    }

    public Sheep(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }
}
