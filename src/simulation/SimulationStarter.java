package simulation;

import dialog.UserDialog;
import island.IslandController;
import island.IslandMap;
import island.Location;
import items.animal.Actions;
import items.animal.Animal;
import items.animal.Direction;
import simulation.service.StepService;
import simulation.service.StepServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;

public class SimulationStarter {
    public static final int POOL_SIZE = 3;
    private final SimulationSettings simulationSettings;
    private final IslandMap islandMap;
    private final IslandController controller;

    private static ScheduledExecutorService executorService;
    private final StepService stepService;

    private final UserDialog userDialog;

    public SimulationStarter() {
        this.stepService = new StepServiceImpl();
        this.simulationSettings = new SimulationSettings();
        this.userDialog = new UserDialog(simulationSettings);
        this.islandMap = new IslandMap(simulationSettings.getHeightMap(), simulationSettings.getWidthMap());
        this.controller = new IslandController(islandMap, null, simulationSettings);

        executorService = Executors.newScheduledThreadPool(POOL_SIZE);
    }

    public void start() {
        userDialog.initSettings();
        controller.getMap().init();
        controller.getMap().fill(simulationSettings.getMaxIslandObjectsOnLocation());

        for (int coordinateY = 0; coordinateY < islandMap.getHeight(); coordinateY++) {
            for (int coordinateX = 0; coordinateX < islandMap.getWidth(); coordinateX++) {
                Location location = islandMap.getLocations()[coordinateY][coordinateX];

                List<Animal> animals = new ArrayList<>(location.getAnimals());
                for (Animal animal : animals) {
                    if (isDead(animal)) {
                        location.removeIslandObject(animal);
                        continue;
                    }
                    Actions action = animal.chooseAction();
                    doAction(action, animal, location);
                }
            }
        }

        System.out.println("s");
    }

    private void doAction(Actions action, Animal animal, Location location){
        switch(action) {
            case MOVE -> doMove(animal, location);
//            case EAT -> doEat(animal, location);
//            case REPRODUCE -> doReproduce(animal, location);
//            case SLEEP -> doSleep(animal, location);
        }
        reduceHealth(animal);
    }

    private void doMove (Animal animal, Location location){
        int stepsCount = ThreadLocalRandom.current().nextInt(animal.getSpeed() + 1);

        while (stepsCount > 0){
            Direction direction = animal.selectDirection();
            switch (direction) {
                case DOWN -> location = stepService.stepsDown(animal , location, islandMap);
                case UP -> location = stepService.stepsUp(animal , location, islandMap);
                case RIGHT -> location =  stepService.stepsRight(animal , location, islandMap);
                case LEFT -> location =  stepService.stepsLeft(animal , location, islandMap);
            }
        }

    }



    private void reduceHealth(Animal animal) {
        double healthPoints = animal.getHealthPoints() - ((animal.getEnoughFoodForFullSaturation() * simulationSettings.getReduceHealthPercent())/ 100);
        animal.setHealthPoints(healthPoints);
    }

    private  boolean isDead(Animal animal){
        return animal.getHealthPoints() < 0;
    }
}
