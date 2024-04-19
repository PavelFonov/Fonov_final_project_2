package com.fonov.service;

import com.fonov.models.abstracts.Animal;
import com.fonov.models.abstracts.Entity;
import com.fonov.models.enums.DirectionType;
import com.fonov.models.island.Field;
import com.fonov.models.island.Island;

public interface MoveService {
    void move(Animal animalToMove, Field from, DirectionType direction, int speed);
}
