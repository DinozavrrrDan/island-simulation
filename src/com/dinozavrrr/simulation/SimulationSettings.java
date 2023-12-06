package com.dinozavrrr.simulation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimulationSettings {
    private int widthMap;
    private int heightMap;
    private int maxIslandObjectsOnLocation;
    private int simulationCycles;
    private int reduceHealthPercent;
    private int initialCorePoolSize;
    private int maxNumberOfTact;
}
