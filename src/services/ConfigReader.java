package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import simulation.SimulationSettings;

import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;

public class ConfigReader {
    private final ObjectMapper mapper;

    public ConfigReader() {
        this.mapper = new YAMLMapper();
    }

    public SimulationSettings readSimulationSettings(){
        SimulationSettings simulationSettings = null;
        try {
            String pathToConfig = "src/models/config.yaml";
            simulationSettings = mapper.readValue(new FileReader(pathToConfig), SimulationSettings.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Set : " + simulationSettings);
        return simulationSettings;
    }

}
