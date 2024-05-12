package com.fonov.models.enums;

import com.fonov.models.herbivores.*;
import com.fonov.models.plants.Grass;
import com.fonov.models.predators.*;

public enum EntityType {

    WOLF("wolf", Wolf.class),
    SNAKE("snake", Snake.class),
    FOX("fox", Fox.class),
    BEAR("bear", Bear.class),
    EAGLE("eagle", Eagle.class),
    HORSE("horse", Horse.class),
    DEER("deer", Deer.class),
    HARE("hare", Hare.class),
    MOUSE("mouse", Mouse.class),
    GOAT("goat", Goat.class),
    SHEEP("sheep", Sheep.class),
    WILDBOAR("wildBoar", WildBoar.class),
    BUFFALO("buffalo", Buffalo.class),
    DUCK("duck", Duck.class),
    CATTERPILLAR("caterpillar", Caterpillar.class),
    GRASS("grass", Grass.class);

    private String type;
    private Class clazz;

    EntityType(String type, Class clazz) {
        this.type = type;
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }

    public String getType() {
        return type;
    }
}
