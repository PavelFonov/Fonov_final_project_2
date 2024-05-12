package com.fonov.models.island;

import com.fonov.models.abstracts.Animal;
import com.fonov.models.abstracts.Entity;
import com.fonov.models.plants.Plant;
import com.fonov.service.action.island.impl.IslandAction;

import java.util.List;
import java.util.Map;

public class Island implements IslandAction {
    private Double countOfNewAnimal;
    private final int width;
    private final int height;
    private final int daysOfLife;
    private double countOfDeathAnimals = 0.0;

    private final Map<Field, List<Entity>> island;

    public Island(Map<Field, List<Entity>> island, int width, int height, int daysOfLife, double countOfNewAnimal) {
        this.width = width;
        this.height = height;
        this.daysOfLife = daysOfLife;
        this.island = island;
        this.countOfNewAnimal = countOfNewAnimal;
    }

    public Map<Field, List<Entity>> getIsland() {
        return island;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDaysOfLife() {
        return daysOfLife;
    }

    public double getCountOfDeathAnimals() {
        return countOfDeathAnimals;
    }

    //удаление животных, которые умирают на данном ходу
    @Override
    public void removeDeathAnimal() {
        for (var fieldListEntry : island.entrySet()) {
            List<Entity> entities = fieldListEntry.getValue();
            int entitiesSize = entities.size();
            entities.removeIf(el -> (el.getHealthPercent() <= 0) && (el instanceof Animal));
            int newEntitiesSize = entities.size();
            countOfDeathAnimals += entitiesSize - newEntitiesSize;
        }
    }

    //восстановление травы на данном ходу
    @Override
    public void refildPlants() {
        for (Map.Entry<Field, List<Entity>> fieldListEntry : island.entrySet()) {
            var allPlants = fieldListEntry.getValue();
            for (Entity entity : allPlants) {
                if (entity instanceof Plant) {
                    entity.setHealthPercent(100);
                }
            }
        }
    }
    public Double getCountOfNewAnimal() {
        return countOfNewAnimal;
    }
}



