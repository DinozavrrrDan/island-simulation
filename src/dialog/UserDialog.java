package dialog;

import services.ConfigReader;
import simulation.SimulationSettings;

import java.util.Scanner;

public class UserDialog {
    public UserDialog() {}

    public SimulationSettings initSettings() {
       SimulationSettings simulationSettings;
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Island simulation");
            System.out.println("If you want to configure settings push \" \" :");
            ConfigReader configReader = new ConfigReader();
            simulationSettings = configReader.readSimulationSettings();
        }
        System.out.println("Height: " + simulationSettings.getHeightMap());
        System.out.println("Width: " + simulationSettings.getWidthMap());
        System.out.println("maxIslandObjectsOnLocation: " + simulationSettings.getMaxIslandObjectsOnLocation());
        System.out.println("simulationCycles: " + simulationSettings.getSimulationCycles());
        System.out.println("reduceHealthPercent: " + simulationSettings.getReduceHealthPercent());
        return simulationSettings;
    }
}
