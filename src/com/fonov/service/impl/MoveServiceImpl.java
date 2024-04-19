package com.fonov.service.impl;

import com.fonov.models.abstracts.Animal;
import com.fonov.models.abstracts.Entity;
import com.fonov.models.enums.DirectionType;
import com.fonov.models.island.Field;
import com.fonov.models.island.Island;
import com.fonov.service.MoveService;

public class MoveServiceImpl implements MoveService {
    private  final Island island;

    public MoveServiceImpl(Island island) {
        this.island = island;
    }

    @Override
    public void move(Animal animalToMove, Field from, DirectionType direction, int speed) {
        //0.0 -> RIGHT, DOWN
        //TODO MOVE ENTITY FROM 1 FIELD TO ANOTHER
    }
}
