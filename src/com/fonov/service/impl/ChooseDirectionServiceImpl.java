package com.fonov.service.impl;

import com.fonov.models.enums.DirectionType;

import java.util.Random;

public class ChooseDirectionServiceImpl {
    private  final Random random;

    public ChooseDirectionServiceImpl(Random random) {
        this.random = random;
    }

    public DirectionType chooseDirection(){

        random.nextInt(4);
        return  DirectionType.values()[random.nextInt(DirectionType.values().length)];
    }
}
