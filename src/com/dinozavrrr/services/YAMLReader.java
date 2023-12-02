package com.dinozavrrr.services;

import com.dinozavrrr.items.animal.EatingMap;
import com.dinozavrrr.simulation.SimulationSettings;

public interface YAMLReader {
    public SimulationSettings readSimulationSettings();

    public EatingMap readEatingMap();

}
