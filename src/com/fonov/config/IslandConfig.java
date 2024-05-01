package com.fonov.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class IslandConfig {


    private int width;
    private int height;
    private int daysOfLife;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDaysOfLife() {
        return daysOfLife;
    }



    public IslandConfig(String pathToPropertiesFile) {

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToPropertiesFile))){
            Properties properties = new Properties();
            properties.load(bufferedReader);
            this.daysOfLife = Integer.parseInt(properties.getProperty("island.daysOfLife"));
            this.width = Integer.parseInt(properties.getProperty("island.width"));
            this.height = Integer.parseInt(properties.getProperty("island.height"));

        }catch(IOException e){
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setDaysOfLife(int daysOfLife) {
        this.daysOfLife = daysOfLife;
    }
}
