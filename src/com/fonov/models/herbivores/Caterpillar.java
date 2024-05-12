package com.fonov.models.herbivores;
import com.fonov.models.abstracts.Entity;

public class Caterpillar extends  Herbivore{
    public Caterpillar(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }
    public Caterpillar(Entity entity) {
        super(entity.getWeight(), entity.getMaxCountOnField(), entity.getSpeed(), entity.getKgToFullEating());
    }
}
