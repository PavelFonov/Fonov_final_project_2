package com.fonov.models.herbivores;

import com.fonov.models.herbivores.Herbivore;

public class Mouse extends Herbivore {
    protected Mouse(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }
}
