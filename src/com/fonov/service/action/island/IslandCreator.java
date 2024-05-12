package com.fonov.service.action.island;

import com.fonov.config.EntityCharacteristicConfig;
import com.fonov.config.IslandConfig;
import com.fonov.models.abstracts.Entity;
import com.fonov.models.enums.EntityType;
import com.fonov.models.island.Field;
import com.fonov.models.island.Island;
import com.fonov.models.plants.Plant;
import com.fonov.service.action.animals.MakeClassByReflection;

import java.util.*;

public class IslandCreator {


    private  Double countOfNewAnimal = 0.0;
    private IslandConfig islandConfig;
    private EntityCharacteristicConfig entityCharacteristicConfig;
    private MakeClassByReflection makeClassByReflection;
    private Random random;
    public Island createIsland(IslandConfig islandConfig, EntityCharacteristicConfig entityCharacteristicConfig, MakeClassByReflection makeClassByReflection, Random random) {
        this.islandConfig = islandConfig;
        this.entityCharacteristicConfig = entityCharacteristicConfig;
        this.makeClassByReflection = makeClassByReflection;
        this.random = random;
        Map<Field, List<Entity>> island = new HashMap<>();
        for (int i = 0; i < islandConfig.getWidth(); i++) {
            for (int j = 0; j < islandConfig.getHeight(); j++) {
                Field field = new Field(i, j);
                ArrayList<Entity> entityesOnField = createAnimalsOnField();
                island.put(field, entityesOnField);
            }
        }
        return new Island(island, islandConfig.getWidth(), islandConfig.getHeight(), islandConfig.getDaysOfLife(),countOfNewAnimal);
    }

    private ArrayList<Entity> createAnimalsOnField() {
        ArrayList<Entity>  entityesOnField = new ArrayList<>();
        for(var entry: entityCharacteristicConfig.getEntityMapConfig().entrySet()){
            int maxCountOfAnimalsOnFiled = (entry.getValue().getMaxCountOnField());
            int randomInteger = random.nextInt(maxCountOfAnimalsOnFiled);
            if(isPlant(entry)){
                randomInteger = 0;
            }
           for (int i = randomInteger; i < maxCountOfAnimalsOnFiled; i++) {
                    Entity entity = makeClassByReflection.makeClassByEntity(entry.getValue());
                    entityesOnField.add(entity);
                    countOfNewAnimal += 1;
            }
        }
        return entityesOnField;
    }

    private static boolean isPlant(Map.Entry<EntityType, Entity> entry) {
        return entry.getValue() instanceof Plant;
    }


}
