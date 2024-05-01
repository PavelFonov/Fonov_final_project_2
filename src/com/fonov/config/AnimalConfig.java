package com.fonov.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AnimalConfig {
    private int percentToRemove;
    public AnimalConfig(String pathToPropertiesFile) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToPropertiesFile))) {
            Properties properties = new Properties();
            properties.load(bufferedReader);
            this.percentToRemove = Integer.parseInt(properties.getProperty("animals.percentToRemove"));

        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
