package com.fonov.models.island;

import com.fonov.models.abstracts.Animal;
import com.fonov.models.abstracts.Entity;
import com.fonov.models.plants.Grass;
import com.fonov.models.plants.Plant;
import com.fonov.service.IslandAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Island implements IslandAction {
    private Map<Field, List<Entity>> island;

    public Map<Field, List<Entity>> getIsland() {
        return island;
    }

    public Island(Map<Field, List<Entity>> island) {
        this.island = island;
    }

    //удаление животных, которые умирают на данном ходу

    @Override
    public void removeDeathAnimal() {
        for (Map.Entry<Field, List<Entity>> fieldListEntry : island.entrySet()) {
            var allAnimals = fieldListEntry.getValue();
            for (Entity entity : allAnimals) {
                if (entity instanceof Animal) {
                    Animal animal = (Animal) entity;
                    if (animal.getHealthPercent() <= 0) {
                        allAnimals.remove(entity);

                    }
                }
            }
        }
    }


    //остров насыщает травой

    @Override
    public void refildPlants(int maxCountOfPkantInOneFeilds) {
        for (var value : island.entrySet()) {
            var totalCountOfPlants = island
                    .values()
                    .stream()
                    .filter(entity -> entity instanceof Plant).count();
            if (totalCountOfPlants < maxCountOfPkantInOneFeilds) {
                List<Plant> plants = new ArrayList<>();
                for (int i = 0; i < maxCountOfPkantInOneFeilds - totalCountOfPlants; i++) {
                    Plant plant = new Grass();
                    plants.add(plant);
                    island.put(value.getKey(), List.of((Entity) plants));
                }
            }
        }
    }
}
