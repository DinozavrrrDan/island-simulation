package com.dinozavrrr.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.dinozavrrr.items.animal.EatingMap;
import com.dinozavrrr.services.YAMLReader;
import com.dinozavrrr.simulation.SimulationSettings;

import java.io.FileReader;
import java.io.IOException;

public class YAMLReaderImpl implements YAMLReader {
    private final ObjectMapper mapper;

    public YAMLReaderImpl() {
        this.mapper = new YAMLMapper();
    }

    @Override
    public SimulationSettings readSimulationSettings() {
        SimulationSettings simulationSettings = null;
        try {
            String pathToConfig = "src/com/dinozavrrr/models/config.yaml";
            simulationSettings = mapper.readValue(new FileReader(pathToConfig), SimulationSettings.class);
        } catch (IOException e) {
            System.out.println("error: Can not read file");
        }
        return simulationSettings;
    }

    @Override
    public EatingMap readEatingMap() {
        EatingMap eatingMap = null;
        try {
            String pathToEatingMap = "src/com/dinozavrrr/models/eating-chace-data.yaml";
            eatingMap = mapper.readValue(new FileReader(pathToEatingMap), EatingMap.class);
        } catch (IOException e) {
            System.out.println("error: Can not read file");
        }
        return eatingMap;
    }

}
