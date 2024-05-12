package com.fonov.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fonov.consts.ENUMS;
import com.fonov.models.PossibilityOfEatingFromJson;
import com.fonov.models.enums.EntityType;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class PossibilityOfEatingConfig {
    private HashMap<HashMap<Class, Class>, Integer> possibilityOfEating;

    public HashMap<HashMap<Class, Class>, Integer> getPossibilityOfEating() {
        return possibilityOfEating;
    }

    public PossibilityOfEatingConfig(ObjectMapper objectMapper, String pathToJson) {
        File dataFromJason = new File(pathToJson);
        possibilityOfEating = new HashMap<>();
        PossibilityOfEatingFromJson[] possibilityOfEatingFromJsons = getTextFromJsonToTemporaryClass(objectMapper, dataFromJason);
        createMapPossibilityJSON(possibilityOfEatingFromJsons);
    }

    private void createMapPossibilityJSON(PossibilityOfEatingFromJson[] possibilityOfEatingFromJsons) {
        for (var el : possibilityOfEatingFromJsons) {
            HashMap<Class, Class> coupleOfPossiblyEating = new HashMap<>();
            Class from = null;
            Class to = null;
            for (EntityType entityTypeValue : EntityType.values()) {
                if (isEntityTypeValue(entityTypeValue, el.getFrom())) {
                    from = entityTypeValue.getClazz();
                }
                if (isEntityTypeValue(entityTypeValue, el.getTo())) {
                    to = entityTypeValue.getClazz();
                }
            }
            coupleOfPossiblyEating.put(from, to);
            possibilityOfEating.put(coupleOfPossiblyEating, el.getPrecent());
        }
    }

    private static boolean isEntityTypeValue(EntityType entityTypeValue, String el) {
        return entityTypeValue.getType().equalsIgnoreCase(el);
    }

    private static PossibilityOfEatingFromJson[] getTextFromJsonToTemporaryClass(ObjectMapper objectMapper, File dataFromJason) {
        PossibilityOfEatingFromJson[] possibilityOfEatingFromJsons;
        try {
            possibilityOfEatingFromJsons = objectMapper.readValue(dataFromJason, PossibilityOfEatingFromJson[].class);
        } catch (IOException e) {
            System.err.println(ENUMS.ERROR_READING_FROM_JSON_FILE);
            throw new RuntimeException(e);
        }
        return possibilityOfEatingFromJsons;
    }
}
