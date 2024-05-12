package com.fonov.models.plants;

import com.fonov.models.abstracts.Entity;

public class Plant  extends Entity {
    protected Plant(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
        }

}
