package services;

import island.IslandMap;
import island.Location;
import items.animal.Animal;

public interface StepService {
    Location stepsLeft(Animal animal, Location location, IslandMap islandMap);

    Location stepsRight(Animal animal, Location location, IslandMap islandMap);

    Location stepsUp(Animal animal, Location location, IslandMap islandMap);

    Location stepsDown(Animal animal, Location location, IslandMap islandMap);

}
