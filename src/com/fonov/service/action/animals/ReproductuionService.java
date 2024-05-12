package com.fonov.service.action.animals;

import com.fonov.config.AnimalConfig;
import com.fonov.config.EntityCharacteristicConfig;
import com.fonov.models.abstracts.Animal;
import com.fonov.models.abstracts.Entity;
import com.fonov.models.enums.EntityType;
import com.fonov.models.island.Field;
import com.fonov.models.island.Island;

import java.util.List;
import java.util.Map;

public class ReproductuionService {
    private final Island island;
    private final AnimalConfig animalConfig;
    private final EntityCharacteristicConfig entityCharacteristicConfig;
    private Double countOfReproductionEntity = 0.0;

    public ReproductuionService(Island island, AnimalConfig animalConfig, EntityCharacteristicConfig entityCharacteristicConfig) {
        this.island = island;
        this.animalConfig = animalConfig;
        this.entityCharacteristicConfig = entityCharacteristicConfig;

    }

    public void multiplyAmimals() {
        countOfReproductionEntity = 0.0;
        for (var fieldListEntry : island.getIsland().entrySet()) {
            List<Animal> animals = getAnimalsFromField(fieldListEntry);
            for (var entityType : EntityType.values()) {
                int countOfAnimalsOfOneTypeInField = getAnimalsCountThisType(entityType, animals);
                if (countOfAnimalsOfOneTypeInField > 0) {
                    Entity entityMother = getEntityMother(entityType, entityCharacteristicConfig);
                    int countOfBabyThisTypeOnThisField = getCountOfBabyThisTypeOnThisField(entityMother, countOfAnimalsOfOneTypeInField, animalConfig);
                    for (int i = 0; i < countOfBabyThisTypeOnThisField; i++) {
                        addBabyOnField(fieldListEntry, (Animal) entityMother);
                        countOfReproductionEntity += 1;
                    }
                }

            }
        }
    }

    private static int getCountOfBabyThisTypeOnThisField(Entity entityMother, int countOfAnimalsOfOneTypeInField, AnimalConfig animalConfig) {
        return (Math.min(countOfCoupleInField(countOfAnimalsOfOneTypeInField), maxProbablyCountOfBabyThisTypeOnThisField(entityMother, countOfAnimalsOfOneTypeInField))) * animalConfig.getCountOfBabyAnimals();
    }

    private void addBabyOnField(Map.Entry<Field, List<Entity>> fieldListEntry, Animal entityMother) {
        fieldListEntry.getValue().add(entityMother.multyply());
    }

    private static int maxProbablyCountOfBabyThisTypeOnThisField(Entity entityMother, int countOfAnimalsOfOneTypeInField) {
        return entityMother.getMaxCountOnField() - countOfAnimalsOfOneTypeInField;
    }

    private static int countOfCoupleInField(int countOfAnimalsOfOneTypeInField) {
        return countOfAnimalsOfOneTypeInField / 2;
    }

    private static Entity getEntityMother(EntityType entityType, EntityCharacteristicConfig entityCharacteristicConfig) {
        return entityCharacteristicConfig.getEntityMapConfig().get(entityType);
    }

    private static int getAnimalsCountThisType(EntityType entityType, List<Animal> entities) {
        return (int) entities.stream()
                .filter(el -> el.getClass().equals(entityType.getClazz()))
                .count();
    }

    private static List<Animal> getAnimalsFromField(Map.Entry<Field, List<Entity>> fieldListEntry) {
        return fieldListEntry.getValue()
                .stream()
                .filter(el -> el instanceof Animal)
                .map(el -> (Animal) el)
                .toList();
    }

    public Double getCountOfReproductionEntity() {
        return countOfReproductionEntity;
    }


}
