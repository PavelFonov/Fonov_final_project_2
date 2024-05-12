package com.fonov.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static com.fonov.consts.ENUMS.NOT_FIND_PRORPERTY_FILE;

public class AnimalConfig {

    private int percentToRemove;
    private int countOfBabyAnimals;
    public AnimalConfig( Properties properties, String pathToPropertiesFile) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToPropertiesFile))) {
            properties.load(bufferedReader);
            this.percentToRemove = Integer.parseInt(properties.getProperty("animals.percentToRemove"));
            this.countOfBabyAnimals = Integer.parseInt(properties.getProperty("animals.countOfBabyAnimals"));

        } catch (IOException e) {
            System.err.println(NOT_FIND_PRORPERTY_FILE);
            throw new RuntimeException(e);
        }
    }

    public void setPercentToRemove(int percentToRemove) {
        this.percentToRemove = percentToRemove;
    }

    public void setCountOfBabyAnimals(int countOfBabyAnimals) {
        this.countOfBabyAnimals = countOfBabyAnimals;
    }

    public int getPercentToRemove() {
        return percentToRemove;
    }

    public int getCountOfBabyAnimals() {
        return countOfBabyAnimals;
    }
}
