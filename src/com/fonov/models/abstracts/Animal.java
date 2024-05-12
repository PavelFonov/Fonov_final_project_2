package com.fonov.models.abstracts;

import com.fonov.models.enums.DirectionType;
import com.fonov.models.island.Field;
import com.fonov.models.island.Island;
import com.fonov.service.action.animals.MakeClassByReflection;
import com.fonov.service.action.animals.impl.AnimalAction;

import java.util.Random;

public abstract class Animal extends Entity implements AnimalAction {

    private boolean isEaten;

    protected Animal(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        super(weight, maxCountOnField, speed, kgToFullEating);
        isEaten = false;
    }

    public boolean isEaten() {
        return isEaten;
    }

    public void setEaten(boolean eaten) {
        isEaten = eaten;
    }


    @Override
    public void move(Island island, Field from, Field to) {
        island.getIsland().get(to).add(this);
        island.getIsland().get(from).remove(this);

    }

    @Override
    public Entity multyply() {
        return new MakeClassByReflection().makeClassByEntity(this);
    }

    @Override
    public DirectionType chooseDirection(Random random) {
        return DirectionType.values()[random.nextInt(DirectionType.values().length)];
    }

    @Override
    public void eat(Entity prey) {
        prey.setHealthPercent(0);
        Double profit = prey.getWeight();
        if (isProfitMoreNeedMealForHunter(this, profit)) {
            this.setHealthPercent(100);
        } else {
            setNewHelthPersentForHunter(this, profit);
        }
        this.setEaten(true);
    }

    @Override
    public void decreaseHealthPercent(int decreaseFor) {
        this.healthPercent -= decreaseFor;
    }


    private static boolean isProfitMoreNeedMealForHunter(Entity entityHunter, Double profit) {
        return (entityHunter.getKgToFullEating()) - (entityHunter.getHealthPercent() / 100.0) * (entityHunter.getKgToFullEating()) <= profit;
    }

    private static void setNewHelthPersentForHunter(Entity entityHunter, Double profit) {
        entityHunter.setHealthPercent((int) ((((entityHunter.getHealthPercent() / 100.0) * (entityHunter.getKgToFullEating()) + profit) / entityHunter.getKgToFullEating()) * 100.0));
    }

}
