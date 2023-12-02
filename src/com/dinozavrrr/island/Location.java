package com.dinozavrrr.island;

import com.dinozavrrr.items.IslandObject;
import com.dinozavrrr.items.animal.Animal;
import com.dinozavrrr.items.plant.Plant;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Location {
    private final int coordinateX;
    private final int coordinateY;
    private final List<IslandObject> islandObjects;
    private final Map<String, Integer> islandObjetsCount;

    public Location(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.islandObjects = new ArrayList<>();
        this.islandObjetsCount = new HashMap<>();
    }

    public void addIslandObject(IslandObject islandObject) {
        islandObjects.add(islandObject);
    }

    public void removeIslandObject(IslandObject islandObject) {
        islandObjects.remove(islandObject);


    }

    private void addToStatistics(IslandObject islandObject) {
        var islandObjectAsString = getIslandObjectName(islandObject);
        islandObjetsCount.merge(islandObjectAsString, 1, (oldValue, newValue) -> oldValue + 1);
    }


    private void removeFromStatistics(IslandObject islandObject) {
        var islandObjectAsString = getIslandObjectName(islandObject);
        islandObjetsCount.merge(islandObjectAsString, 1, (oldValue, newValue) -> {
            int newCount = oldValue - 1;
            if (newCount <= 0) {
                return null;
            }
            return newCount;
        });
    }


    private String getIslandObjectName(IslandObject islandObject) {
        return islandObject.getClass().getSimpleName();
    }

    public List<Animal> getAnimals() {
        return islandObjects.stream()
                .filter(Animal.class::isInstance)
                .map(Animal.class::cast)
                .toList();
    }

    public List<Plant> getPlants() {
        return islandObjects.stream()
                .filter(Plant.class::isInstance)
                .map(Plant.class::cast)
                .toList();
    }
}
