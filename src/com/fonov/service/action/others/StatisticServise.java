package com.fonov.service.action.others;

import com.fonov.models.island.Island;
import com.fonov.service.action.animals.EatingService;
import com.fonov.service.action.animals.MoveService;
import com.fonov.service.action.animals.ReproductuionService;


public class StatisticServise {
    private final Island island;
    private final MoveService moveService;
    private final EatingService eatatingService;
    private final ReproductuionService reproductuionService;


    public StatisticServise(Island island, MoveService moveService, EatingService eatatingService, ReproductuionService reproductuionService) {
        this.island = island;
        this.moveService = moveService;
        this.eatatingService = eatatingService;
        this.reproductuionService = reproductuionService;
    }

    public void printCountOfAnimalsOnStart() {
        System.out.println("Cоздано " + island.getCountOfNewAnimal() + " cуществ на старте ");
        System.out.println();
    }

    public void printInfoForOneDay(int i) {
        int dayNumber = i + 1;
        System.out.println("/////////////////////");
        System.out.println("День " + dayNumber);
        System.out.println();
        System.out.println(moveService.getCountOfMoving() + " животных переместились за " + dayNumber + " день.");
        System.out.println(eatatingService.getCountOfEatingEntity() + " животных, которые поели за " + dayNumber + " день.");
        System.out.println(island.getCountOfDeathAnimals() + " животных умерло за " + dayNumber + " день ");
        System.out.println(reproductuionService.getCountOfReproductionEntity() + " животных родилось за " + dayNumber + " день.");
        System.out.println();
        printCountOfAnimalsOnIsland();
    }

    public void printCountOfAnimalsOnIsland() {
        double countofAnimals = 0;
        for (var entry : island.getIsland().entrySet()) {
            countofAnimals += entry.getValue().size();
        }
        System.out.println(countofAnimals + " существ осталось на острове");
    }

}






