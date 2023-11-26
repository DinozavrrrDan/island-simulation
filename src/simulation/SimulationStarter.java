package simulation;

import dialog.UserDialog;
import island.IslandController;
import island.IslandMap;

public class SimulationStarter {
    private final SimulationSettings simulationSettings;
    private final IslandMap islandMap;
    private final IslandController controller;

    private final UserDialog userDialog;

    public SimulationStarter() {
        this.simulationSettings = new SimulationSettings();
        this.userDialog = new UserDialog(simulationSettings);
        this.islandMap = new IslandMap(simulationSettings.getHeightMap(), simulationSettings.getWidthMap());
        this.controller = new IslandController(islandMap, null, simulationSettings);
    }

    public void start() {
        controller.getMap().init();
        controller.getMap().fill(simulationSettings.getMaxIslandObjectsOnLocation());
        System.out.println("s");
    }
}
