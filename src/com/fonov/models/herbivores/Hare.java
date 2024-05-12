package com.fonov.models.herbivores;

import com.fonov.models.abstracts.Entity;

public class Hare extends  Herbivore{
    public Hare(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }
    public Hare(Entity entity) {
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(), entity.getKgToFullEating());
    }
}
