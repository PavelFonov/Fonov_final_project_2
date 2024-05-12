package com.fonov.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fonov.models.abstracts.Entity;
import com.fonov.consts.ENUMS;
import com.fonov.models.enums.EntityType;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class EntityCharacteristicConfig {

    private Map<EntityType, Entity> entityMapConfig;

    public Map<EntityType, Entity> getEntityMapConfig() {
        return entityMapConfig;
    }

    public EntityCharacteristicConfig(ObjectMapper objectMapper, String pathToJson) {
        // код, который парсит json в entityMapConfig
        File dataFromJason = new File(pathToJson);
        entityMapConfig = new HashMap<>();
        for (EntityType entityTypeValue : EntityType.values()) {
            try {
                JsonNode objectFromJson = objectMapper.readTree(dataFromJason).get(entityTypeValue.getType());
                double weight = objectFromJson.get("weight").asDouble();
                int speed = objectFromJson.get("speed").asInt();
                int maxCountOnField = objectFromJson.get("maxCountOnField").asInt();
                double kgToFullEating = objectFromJson.get("kgToFullEating").asDouble();

                Constructor<?> constructor = entityTypeValue.getClazz().getConstructor(Double.class, Integer.class, Integer.class, Double.class);
                Entity entity = (Entity) constructor.newInstance(weight, maxCountOnField, speed, kgToFullEating);
                entityMapConfig.put(entityTypeValue, entity);
            } catch (IOException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException e) {
                System.err.println(ENUMS.ERROR_READING_FROM_JSON_FILE);
                throw new RuntimeException(e);
            }

        }
    }
}



















//        //заглушка
//        entityMapConfig.put(EntityType.GRASS, new Entity(10.0, 100,null, null));
//        entityMapConfig.put(EntityType.WOLF, new Entity(100.0, 10,1, 10.0));
//        this.entityMapConfig = entityMapConfig;




