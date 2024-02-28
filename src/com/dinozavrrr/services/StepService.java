package com.dinozavrrr.services;

import com.dinozavrrr.island.IslandMap;
import com.dinozavrrr.island.Location;
import com.dinozavrrr.items.animal.Animal;

public interface StepService {
    Location stepsLeft(Animal animal, Location location, IslandMap islandMap);

    Location stepsRight(Animal animal, Location location, IslandMap islandMap);

    Location stepsUp(Animal animal, Location location, IslandMap islandMap);

    Location stepsDown(Animal animal, Location location, IslandMap islandMap);

}
