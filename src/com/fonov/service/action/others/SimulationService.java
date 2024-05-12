package com.fonov.service.action.others;

import com.fonov.models.island.Island;
import com.fonov.service.action.animals.DicreaseHelthService;
import com.fonov.service.action.animals.EatingService;
import com.fonov.service.action.animals.MoveService;
import com.fonov.service.action.animals.ReproductuionService;

public class SimulationService {

    Island island;
    MoveService moveService;
    EatingService eatatingService;
    ReproductuionService reproductuionService;
    DicreaseHelthService dicreaseHelthService;
    StatisticServise statisticServise;

    public SimulationService(Island island, MoveService moveService, EatingService eatatingService, ReproductuionService reproductuionService, DicreaseHelthService dicreaseHelthService, StatisticServise statisticServise) {

        this.island = island;
        this.moveService = moveService;
        this.eatatingService = eatatingService;
        this.reproductuionService = reproductuionService;
        this.dicreaseHelthService = dicreaseHelthService;
        this.statisticServise = statisticServise;
    }

    public void simulationStart(){
        statisticServise.printCountOfAnimalsOnStart();
        for (int i = 0; i < island.getDaysOfLife(); i++) {
            moveService.moveAnimals();
            eatatingService.eatAnimals();
            island.removeDeathAnimal();
            island.refildPlants();
            reproductuionService.multiplyAmimals();
            dicreaseHelthService.decreaseHelthAnimals();
            statisticServise.printInfoForOneDay(i);
        }
    }



}
