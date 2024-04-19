package com.fonov.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fonov.models.abstracts.Animal;
import com.fonov.models.abstracts.Entity;

import java.util.HashMap;

public class PossibilityOfEatingConfig {
    private HashMap<HashMap<Entity, Entity>,Long> possibilityOfEating;

    public PossibilityOfEatingConfig(ObjectMapper objectMapper, String pathToJson) {
        //TODO заполняем possibilityOfEating
        this.possibilityOfEating = possibilityOfEating;
    }
    //((wolf, mouse) = 80)
    //((mouse, wolf) = 0)
    //Animal не подходит, так как есть трава

    // TO DO: подумать как не переносить ручками
}
