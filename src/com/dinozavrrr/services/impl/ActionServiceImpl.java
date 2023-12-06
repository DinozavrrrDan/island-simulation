package com.dinozavrrr.services.impl;

import com.dinozavrrr.island.IslandMap;
import com.dinozavrrr.island.Location;
import com.dinozavrrr.items.IslandObject;
import com.dinozavrrr.items.IslandObjectType;
import com.dinozavrrr.items.IslandObjectsFactory;
import com.dinozavrrr.items.animal.Actions;
import com.dinozavrrr.items.animal.Animal;
import com.dinozavrrr.items.animal.Direction;
import com.dinozavrrr.items.animal.EatingMap;
import com.dinozavrrr.services.ActionService;
import com.dinozavrrr.services.HealthService;
import com.dinozavrrr.services.StepService;
import com.dinozavrrr.services.YAMLReader;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class ActionServiceImpl implements ActionService {

    private final StepService stepService;
    private final IslandMap islandMap;
    private final EatingMap eatingMap;
    private final IslandObjectsFactory islandObjectsFactory;
    private final HealthService healthService;

    public ActionServiceImpl(IslandMap islandMap, HealthService healthService) {
        this.healthService = healthService;
        this.stepService = new StepServiceImpl();
        this.islandMap = islandMap;
        YAMLReader yamlReader = new YAMLReaderImpl();
        this.eatingMap = yamlReader.readEatingMap();
        this.islandObjectsFactory = new IslandObjectsFactory();
    }

    @Override
    public void doAction(Actions action, Animal animal, Location location) {
        switch (action) {
            case MOVE -> doMove(animal, location);
            case EAT -> doEat(animal, location);
            case REPRODUCE -> doReproduce(animal, location);
            case SLEEP -> doSleep(animal);
        }
        healthService.reduceHealth(animal);
    }


    private void doMove(Animal animal, Location location) {
        int stepsCount = ThreadLocalRandom.current().nextInt(animal.getSpeed() + 1);

        while (stepsCount > 0) {
            Direction direction = animal.selectDirection();
            switch (direction) {
                case DOWN -> location = stepService.stepsDown(animal, location, islandMap);
                case UP -> location = stepService.stepsUp(animal, location, islandMap);
                case RIGHT -> location = stepService.stepsRight(animal, location, islandMap);
                case LEFT -> location = stepService.stepsLeft(animal, location, islandMap);
            }
            stepsCount--;
        }
    }

    private void doEat(Animal animal, Location location) {
        List<IslandObject> islandObjects = location.getIslandObjects();
        List<IslandObject> foodIslandObjects = islandObjects.stream()
                .filter(foodIslandObject ->
                        !isEqualIslandObject(foodIslandObject, animal))
                .toList();

        if (!foodIslandObjects.isEmpty()) {
            IslandObject food = foodIslandObjects.get(ThreadLocalRandom.current().nextInt(foodIslandObjects.size()));

            if (isEaten(animal, food)) {
                animal.eat(food);
                location.removeIslandObject(food);
            }
        }
    }

    private void doReproduce(Animal animal, Location location) {
        String animalAsString = getSimpleClassName(animal);
        if (location.getIslandObjetsCount().get(animalAsString) >= animal.getMaxOnSquare()) {
            return;
        }

        if (getCountAnimalOnLocation(animal, location) > 1) {
            location.addIslandObject(islandObjectsFactory.createIslandObject(IslandObjectType.valueOf(animalAsString)));
        }
    }

    private void doSleep(Animal animal) {
        healthService.increaseHealth(animal);
    }


    private boolean isEqualIslandObject(IslandObject islandObject, IslandObject eaIslandObject) {
        return islandObject.getClass().getSimpleName().equals(eaIslandObject.getClass().getSimpleName());
    }

    public boolean isEaten(Animal animal, IslandObject food) {
        int chanceOfEatingFood = getEatableChanceIndex(animal, food);
        return ThreadLocalRandom.current().nextInt(100) < chanceOfEatingFood;
    }

    private int getEatableChanceIndex(Animal animal, IslandObject food) {
        Map<String, Integer> map = eatingMap
                .getEatableIndexes()
                .get(getSimpleClassName(animal));

        return map.get(food.getClass().getSimpleName());
    }

    private String getSimpleClassName(Animal animal) {
        return animal.getClass().getSimpleName();
    }

    private long getCountAnimalOnLocation(Animal animal, Location location) {
        return location.getAnimals().stream()
                .filter(animalType -> isEqualIslandObject(animal, animalType))
                .count();
    }
}
