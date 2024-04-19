package com.fonov.models.enums;

import com.fonov.models.herbivores.Mouse;
import com.fonov.models.plants.Grass;
import com.fonov.models.plants.Plant;
import com.fonov.models.predators.Wolf;

public enum EntityType {
    GRASS("grass", Grass.class),
    WOLF("wolf", Wolf.class),
    MOUSE("mouse", Mouse.class);
    private String type;
    private Class clazz;

    EntityType(String type, Class clazz) {
        this.type = type;
        this.clazz = clazz;
    }
}
