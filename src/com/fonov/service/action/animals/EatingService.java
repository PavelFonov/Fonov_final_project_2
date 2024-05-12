package com.fonov.service.action.animals;

import com.fonov.config.PossibilityOfEatingConfig;
import com.fonov.models.abstracts.Animal;
import com.fonov.models.abstracts.Entity;
import com.fonov.models.island.Island;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class EatingService {
    private static final int MaxProbablyInPercent = 100;
    private final Island island;
    private final Random random;
    private final PossibilityOfEatingConfig possibilityOfEatingConfig;
    private double countOfEatingEntity = 0.0;


    public EatingService(Island island, Random random, PossibilityOfEatingConfig possibilityOfEatingConfig) {
        this.island = island;
        this.random = random;
        this.possibilityOfEatingConfig = possibilityOfEatingConfig;
    }

    public void eatAnimals() {
        countOfEatingEntity = 0.0;
        for (var fieldListEntry : island.getIsland().entrySet()) {
            List<Entity> entitiesOnField = fieldListEntry.getValue();
            for (Entity entityHunter : entitiesOnField) {
                if ((entityHunter instanceof Animal) && (isHungry(entityHunter))) {
                    List<Entity> entitiesPrey = new ArrayList<>();
                    for (Entity entityPrey : entitiesOnField) {
                        if (isNotTribesman(entityHunter, entityPrey) && isAlive(entityPrey) && isHunterCanEatThisPrey(entityHunter, entityPrey)) {
                            entitiesPrey.add(entityPrey);
                        }
                    }
                    if (!entitiesPrey.isEmpty()) {
                        Entity randomEntityForEating = getRandomEntityForEating(entitiesPrey);
                        if (isRandomCanEatingTrue(entityHunter, randomEntityForEating)) {
                            ((Animal) entityHunter).eat(randomEntityForEating);
                            countOfEatingEntity += 1;
                        }
                    }
                }
            }
        }
    }



    private static boolean isAlive(Entity entity) {
        return entity.getHealthPercent() > 0;
    }

    private static boolean isHungry(Entity entityHunter) {
        return entityHunter.getHealthPercent() < 100;
    }


    private static boolean isNotTribesman(Entity entityHunter, Entity entityPrey) {
        return !(entityPrey.getClass().equals(entityHunter.getClass()));

    }

    private boolean isHunterCanEatThisPrey(Entity entityHunter, Entity entityPrey) {
        return getProbabalityOfEating(entityHunter, entityPrey) != 0;
    }

    private Entity getRandomEntityForEating(List<Entity> entitiesPrey) {
        return entitiesPrey.get(random.nextInt(entitiesPrey.size()));
    }

    private boolean isRandomCanEatingTrue(Entity entityHunter, Entity randomEntityForEating) {
        return getProbabalityOfEating(entityHunter, randomEntityForEating) > random.nextInt(MaxProbablyInPercent);
    }

    private Integer getProbabalityOfEating(Entity entityHunter, Entity randomEntityForEating) {
        return possibilityOfEatingConfig.getPossibilityOfEating().get(getClassClassHashMap(entityHunter, randomEntityForEating));
    }

    private static HashMap<Class, Class> getClassClassHashMap(Entity entity, Entity entity1) {
        HashMap<Class, Class> temporaryHashMap = new HashMap<>();
        temporaryHashMap.put(entity.getClass(), entity1.getClass());
        return temporaryHashMap;
    }
    public double getCountOfEatingEntity() {
        return countOfEatingEntity;
    }

}
