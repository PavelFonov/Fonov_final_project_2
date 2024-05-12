package com.fonov.service.action.animals;

import com.fonov.config.AnimalConfig;
import com.fonov.models.abstracts.Animal;
import com.fonov.models.abstracts.Entity;
import com.fonov.models.island.Field;
import com.fonov.models.island.Island;

import java.util.List;
import java.util.Map;

public class DicreaseHelthService {
    private final Island island;
    private final AnimalConfig animalConfig;

    public DicreaseHelthService(Island island, AnimalConfig animalConfig) {
        this.island = island;
        this.animalConfig = animalConfig;
    }

    public void decreaseHelthAnimals() {
        for (Map.Entry<Field, List<Entity>> fieldListEntry : island.getIsland().entrySet()) {
            var allAnimals = fieldListEntry.getValue();
            for (Entity entity : allAnimals) {
                if (entity instanceof Animal animal) {
                    if (!animal.isEaten()) {
                        animal.decreaseHealthPercent(animalConfig.getPercentToRemove());
                    } else {
                        animal.setEaten(false);
                    }
                }
            }
        }
    }
}

