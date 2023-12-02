package services;

import items.animal.EatingMap;
import simulation.SimulationSettings;

public interface YAMLReader {
    public SimulationSettings readSimulationSettings();
    public EatingMap readEatingMap();

}
