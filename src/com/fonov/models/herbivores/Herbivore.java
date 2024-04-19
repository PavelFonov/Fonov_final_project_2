package com.fonov.models.herbivores;

import com.fonov.models.abstracts.Animal;

//травоядный
public abstract class Herbivore extends Animal {
    protected Herbivore(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
    }
}
