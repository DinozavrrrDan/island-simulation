package dialog;

import simulation.SimulationSettings;

import java.util.Scanner;

public class UserDialog {
    private final SimulationSettings simulationSettings;

    public UserDialog(SimulationSettings simulationSettings) {
        this.simulationSettings = simulationSettings;
    }

    public void initSettings() {
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("Island simulation");
            System.out.println("Current settings:");
            System.out.println("Height: " + simulationSettings.getHeightMap());
            System.out.println("Width: " + simulationSettings.getWidthMap());
        }
    }
}
