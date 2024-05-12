package com.fonov.service.action.animals;

import com.fonov.models.abstracts.Entity;
import com.fonov.consts.ENUMS;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MakeClassByReflection {

    public Entity makeClassByEntity(Entity entity){
        Entity entityByEntity;
        double weight = entity.getWeight();
        int speed = entity.getSpeed();
        int maxCountOnField = entity.getMaxCountOnField();
        double kgToFullEating = entity.getKgToFullEating();

        Constructor<?> constructor;
        try {
            constructor = entity.getClass().getConstructor(Double.class, Integer.class, Integer.class, Double.class);
        } catch (NoSuchMethodException e) {
            System.out.println(ENUMS.NOT_FIND_CONSTRUCTOR_ON_FILLING_ENTITY_ON_FIELD);
            throw new RuntimeException(e);
        }
        try {
        entityByEntity = (Entity) constructor.newInstance(weight, maxCountOnField, speed, kgToFullEating);
        return entityByEntity;
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            System.out.println(ENUMS.NOT_CREATE_ENTITY_ON_FIELD);
            throw new RuntimeException(e);
        }
    }


    }


