package com.fonov;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fonov.config.EntityCharacteristicConfig;
import com.fonov.config.FieldSizeConfig;
import com.fonov.config.PossibilityOfEatingConfig;
import com.fonov.models.abstracts.Animal;
import com.fonov.models.abstracts.Entity;
import com.fonov.models.enums.EntityType;
import com.fonov.models.island.Field;
import com.fonov.models.island.Island;
import com.fonov.models.plants.Grass;
import com.fonov.models.predators.Wolf;
import com.fonov.service.MoveService;
import com.fonov.service.impl.ChooseDirectionServiceImpl;
import com.fonov.service.impl.MoveServiceImpl;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        ObjectMapper objectMapper = new ObjectMapper();
        EntityCharacteristicConfig entityCharacteristicConfig = new EntityCharacteristicConfig(objectMapper, "entity_characteristic.json");
        PossibilityOfEatingConfig possibilityOfEatingConfig = new PossibilityOfEatingConfig(objectMapper, "resourses/possibility_of_eating.json");
        FieldSizeConfig fieldSizeConfig = new FieldSizeConfig(100, 20);

        Island island = createIsland(fieldSizeConfig);
        MoveService moveService = new MoveServiceImpl(island);

        ChooseDirectionServiceImpl chooseDirectionServiceImpl = new ChooseDirectionServiceImpl(random);


        int maxPlantsOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.GRASS);
        //int maxWolfOnField = getMaxCountOnField(entityCharacteristicConfig, EntityType.WOLF);

        // fill plants
        island.getIsland().values().forEach(value -> IntStream.range(0, random.nextInt(maxPlantsOnField))
                .mapToObj(i -> createGrass(entityCharacteristicConfig))
                .forEach(value::add));
        // fill woolf
        island.getIsland().values().forEach(value -> IntStream.range(0, random.nextInt(maxPlantsOnField))
                .mapToObj(i -> createWolf(entityCharacteristicConfig))
                .forEach(value::add));

        System.out.println(island);

        //move wolf

        for (Map.Entry<Field, List<Entity>> fieldListEntry : island.getIsland().entrySet()) {
            Field field = fieldListEntry.getKey();
            List<Animal> entities = fieldListEntry.getValue()
                    .stream()
                    .filter(el -> el instanceof Animal)
                    .map(el -> (Animal) el)
                    .toList();
            for (Animal animal : entities) {
                //Придумать, как заменить  EntityType.WOLF)
                int speed = getSpeed(entityCharacteristicConfig, EntityType.WOLF);
                var directionToMove = chooseDirectionServiceImpl.chooseDirection();
                moveService.move(animal, field, directionToMove, speed);
            }
        }


    }

    // оптимизировать код ниже
    private static Grass createGrass(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Grass(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.GRASS));
    }

    private static Wolf createWolf(EntityCharacteristicConfig entityCharacteristicConfig) {
        return new Wolf(entityCharacteristicConfig.getEntityMapConfig().get(EntityType.WOLF));
    }

    private static Integer getMaxCountOnField(EntityCharacteristicConfig entityCharacteristicConfig, EntityType entityType) {
        return entityCharacteristicConfig
                .getEntityMapConfig()
                .get(entityType)
                .getMaxCountOnField();
    }

    private static Integer getSpeed(EntityCharacteristicConfig entityCharacteristicConfig, EntityType entityType) {
        return entityCharacteristicConfig
                .getEntityMapConfig()
                .get(entityType)
                .getSpeed();
    }

    private static Island createIsland(FieldSizeConfig fieldSizeConfig) {
        Map<Field, List<Entity>> island = new HashMap<>();
        for (int i = 0; i < fieldSizeConfig.getWidth(); i++) {
            for (int j = 0; j < fieldSizeConfig.getHeight(); j++) {
                Field field = new Field(i, j);
                island.put(field, new ArrayList<>());
            }
        }
        return new Island(island);
    }
}

