package com.fonov.service.action.animals.impl;

import com.fonov.models.abstracts.Entity;
import com.fonov.models.enums.DirectionType;
import com.fonov.models.island.Field;
import com.fonov.models.island.Island;

import java.util.Random;

public interface AnimalAction {
    void move(Island island, Field from, Field to);
    Entity multyply();
    DirectionType chooseDirection(Random random);
    void eat(Entity entity);
    void decreaseHealthPercent(int decreaseFor);

}
