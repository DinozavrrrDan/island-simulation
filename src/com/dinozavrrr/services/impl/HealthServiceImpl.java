package com.dinozavrrr.services.impl;

import com.dinozavrrr.items.animal.Animal;
import com.dinozavrrr.services.HealthService;
import com.dinozavrrr.simulation.SimulationSettings;

public class HealthServiceImpl implements HealthService {

    private final SimulationSettings simulationSettings;

    public HealthServiceImpl(SimulationSettings simulationSettings) {
        this.simulationSettings = simulationSettings;
    }

    @Override
    public void increaseHealth(Animal animal) {
        double healthPoints = animal.getHealthPoints() + ((animal.getEnoughFoodForFullSaturation()
                * simulationSettings.getReduceHealthPercent() / 100));
        if (healthPoints > animal.getHealthPoints()) {
            healthPoints = animal.getEnoughFoodForFullSaturation();
        }
        animal.setHealthPoints(healthPoints);
    }

    @Override
    public void reduceHealth(Animal animal) {
        double healthPoints = animal.getHealthPoints() - ((animal.getEnoughFoodForFullSaturation()
                * simulationSettings.getReduceHealthPercent() / 100));
        animal.setHealthPoints(healthPoints);
    }
}
