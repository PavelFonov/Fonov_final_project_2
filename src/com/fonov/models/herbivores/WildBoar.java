package com.fonov.models.herbivores;

import com.fonov.models.abstracts.Entity;

public class WildBoar extends Herbivore{
    public WildBoar(Entity entity) {
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(), entity.getKgToFullEating());
    }

    public WildBoar(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }
}
