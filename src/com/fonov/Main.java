package com.fonov;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fonov.config.*;
import com.fonov.models.island.Island;
import com.fonov.service.action.others.SimulationService;
import com.fonov.service.action.others.StatisticServise;
import com.fonov.service.action.animals.MakeClassByReflection;
import com.fonov.service.action.animals.ReproductuionService;
import com.fonov.service.action.animals.EatingService;
import com.fonov.service.action.animals.DicreaseHelthService;
import com.fonov.service.action.animals.MoveService;
import com.fonov.service.action.island.IslandCreator;

import java.util.Properties;
import java.util.Random;

import static com.fonov.consts.Consts.*;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        Properties properties = new Properties();
        ObjectMapper objectMapper = new ObjectMapper();
        MakeClassByReflection makeClassByReflection = new MakeClassByReflection();

        //Создание  и загрузка дефолтных настроек
        IslandConfig islandConfig = new IslandConfig(properties, PATH_TO_ISLAND_SETTINGS);
        AnimalConfig animalConfig = new AnimalConfig(properties, PATH_TO_ISLAND_SETTINGS);
        EntityCharacteristicConfig entityCharacteristicConfig = new EntityCharacteristicConfig(objectMapper, PATH_TO_ENTITY_CHARACTERISTICS);
        PossibilityOfEatingConfig possibilityOfEatingConfig = new PossibilityOfEatingConfig(objectMapper, PATH_TO_POSSIBIBLITY);
        UpdaterStartSettings updaterStartSettings = new UpdaterStartSettings(islandConfig, entityCharacteristicConfig, animalConfig);

        //Создание острова и загрузка сервисов
        updaterStartSettings.updeteConfig();
        Island island = new IslandCreator().createIsland(islandConfig, entityCharacteristicConfig, makeClassByReflection, random);
        MoveService moveService = new MoveService(island, random);
        EatingService eatatingService = new EatingService(island, random, possibilityOfEatingConfig);
        ReproductuionService reproductuionService = new ReproductuionService(island, animalConfig, entityCharacteristicConfig);
        DicreaseHelthService dicreaseHelthService = new DicreaseHelthService(island, animalConfig);
        StatisticServise statisticServise = new StatisticServise(island, moveService, eatatingService, reproductuionService);
        SimulationService simulationService = new SimulationService(island, moveService, eatatingService, reproductuionService,dicreaseHelthService,statisticServise);

        simulationService.simulationStart();

    }

}

