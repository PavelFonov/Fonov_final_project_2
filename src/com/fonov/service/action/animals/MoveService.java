package com.fonov.service.action.animals;

import com.fonov.models.abstracts.Animal;
import com.fonov.models.abstracts.Entity;
import com.fonov.models.enums.DirectionType;
import com.fonov.models.island.Field;
import com.fonov.models.island.Island;

import java.util.*;

public class MoveService {
    private final int countOfAttemptToMove = 3;
    private final Island island;
    Random random;
    private static double countOfMoving = 0;

    public MoveService(Island island, Random random) {
        this.island = island;
        this.random = random;
    }

    public void moveAnimals() {
        countOfMoving = 0;
        Map<Field, List<Entity>> copyIsland = copyIsland();
        for (var fieldListEntry : copyIsland.entrySet()) {
            Field field = fieldListEntry.getKey();
            List<Animal> entities = getAnimalsFromField(fieldListEntry);
            for (Animal animalToMove : entities) {
                int x = field.getX();
                int y = field.getY();
                Field newField = getRandomNewField(animalToMove, x, y);
                for (int i = 0; i < countOfAttemptToMove; i++) {
                    if (checkMaxCountOnField(newField, animalToMove)) {
                        animalToMove.move(island, getNewField(x, y), newField);
                        countOfMoving +=1;
                        break;
                    } else {
                        newField = getRandomNewField(animalToMove, x, y);
                    }
                }
            }
        }
    }

    private static List<Animal> getAnimalsFromField(Map.Entry<Field, List<Entity>> fieldListEntry) {
        return fieldListEntry.getValue()
                .stream()
                .filter(el -> el instanceof Animal)
                .map(el -> (Animal) el)
                .toList();
    }

    private Map<Field, List<Entity>> copyIsland() {
        Map<Field, List<Entity>> copyIsland = new HashMap<>();
        for (var entry : island.getIsland().entrySet()) {
            copyIsland.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
        return copyIsland;
    }

    private Field getRandomNewField(Animal animalToMove, int x, int y) {
        int newX = x;
        int newY = y;
        for (int i = 1; i < animalToMove.getSpeed() + 1; i++) {
            var direction = animalToMove.chooseDirection(random);
            if (direction.equals(DirectionType.UP) || direction.equals(DirectionType.DOWN)) {
                newY += direction.getDirectionDigit();
                if ((newY < 0)) {
                    newY = 0;
                }
                if ((newY >= island.getHeight())) {
                    newY = island.getHeight() - 1;
                }
            }
            if (direction.equals(DirectionType.LEFT) || direction.equals(DirectionType.RIGHT)) {
                newX += direction.getDirectionDigit();
                if ((newX < 0)) {
                    newX = 0;
                }
                if ((newX >= island.getWidth())) {
                    newX = island.getWidth() - 1;
                }
            }
        }
        return getNewField(newX, newY);
    }

    private Field getNewField(int newX, int newY) {
        for (Field field : island.getIsland().keySet()) {
            if (field.getX() == newX && field.getY() == newY) {
                return field;
            }
        }
        return null;
    }

    private boolean checkMaxCountOnField(Field newField, Animal animalToMove) {
        int countAnimalsThisTypeOnField = (int) island.getIsland().get(newField).stream()
                .filter(el -> el.getClass().equals(animalToMove.getClass()))
                .count();
        return !(countAnimalsThisTypeOnField >= animalToMove.getMaxCountOnField());
    }
    public double getCountOfMoving() {
        return countOfMoving;
    }
}
