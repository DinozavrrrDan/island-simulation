package services.impl;

import island.IslandMap;
import island.Location;
import items.animal.Animal;
import services.StepService;

public class StepServiceImpl implements StepService {
    public Location stepsLeft(Animal animal, Location location, IslandMap islandMap) {
        return canStepLeft(location) ?
                updateLocation(animal, location, location.getCoordinateY(), location.getCoordinateX() - 1, islandMap) :
                location;
    }

    public Location stepsRight(Animal animal, Location location, IslandMap islandMap) {
        return canStepRight(location, islandMap) ?
                updateLocation(animal, location, location.getCoordinateY(), location.getCoordinateX() + 1, islandMap) :
                location;
    }

    public Location stepsUp(Animal animal, Location location, IslandMap islandMap) {
        return canStepUp(location) ?
                updateLocation(animal, location, location.getCoordinateY() - 1, location.getCoordinateX(), islandMap) :
                location;
    }

    public Location stepsDown(Animal animal, Location location, IslandMap islandMap) {
        return canStepDown(location, islandMap) ?
                updateLocation(animal, location, location.getCoordinateY() + 1, location.getCoordinateX(), islandMap) :
                location;
    }

    private static boolean canStepUp(Location location) {
        return location.getCoordinateY() > 0;
    }

    private static boolean canStepRight(Location location, IslandMap islandMap) {
        return location.getCoordinateY() < islandMap.getWidth() - 1;
    }

    private static boolean canStepDown(Location location, IslandMap islandMap) {
        return location.getCoordinateY() < islandMap.getHeight() - 1;
    }

    private static boolean canStepLeft(Location location) {
        return location.getCoordinateX() > 0;
    }

    private Location updateLocation(Animal animal, Location location, int currentY, int currentX, IslandMap islandMap) {
        Location newLocation = islandMap.getLocations()[currentY][currentX];

        if (cantStep(animal, location)) {
            return location;
        }

        newLocation.addIslandObject(animal);
        location.removeIslandObject(animal);
        return newLocation;
    }

    private boolean cantStep(Animal animal, Location location) {
        String animalAsString = animal.getClass().getSimpleName();
        return location.getIslandObjetsCount().get(animalAsString) >= animal.getMaxOnSquare();
    }
}
