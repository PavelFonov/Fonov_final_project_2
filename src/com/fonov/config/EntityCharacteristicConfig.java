package com.fonov.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fonov.models.abstracts.Entity;
import com.fonov.models.enums.EntityType;

import java.util.HashMap;
import java.util.Map;

public class EntityCharacteristicConfig {
    private Map<EntityType, Entity> entityMapConfig;

    public Map<EntityType, Entity> getEntityMapConfig() {
        return entityMapConfig;
    }

    public EntityCharacteristicConfig(ObjectMapper objectMapper, String pathToJson) {
        //TODO код, который парсит json в entityMapConfig

        HashMap<EntityType, Entity> entityMapConfig = new HashMap<>();

        //заглушка
        entityMapConfig.put(EntityType.GRASS, new Entity(10.0, 100,null, null));
        entityMapConfig.put(EntityType.WOLF, new Entity(100.0, 10,1, 10.0));
        this.entityMapConfig = entityMapConfig;
    }
}
