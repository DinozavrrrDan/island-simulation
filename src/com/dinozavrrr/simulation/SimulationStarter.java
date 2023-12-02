package com.dinozavrrr.simulation;

import com.dinozavrrr.dialog.UserDialog;
import com.dinozavrrr.island.IslandController;
import com.dinozavrrr.island.IslandMap;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SimulationStarter {
    private final SimulationSettings simulationSettings;
    private final IslandController controller;
    public static ScheduledExecutorService executorService;


    public SimulationStarter() {
        UserDialog userDialog = new UserDialog();
        this.simulationSettings = userDialog.initSettings();
        IslandMap islandMap = new IslandMap(simulationSettings.getHeightMap(), simulationSettings.getWidthMap());
        this.controller = new IslandController(islandMap, simulationSettings);
        System.out.println(simulationSettings.getInitialCorePoolSize());
        executorService = Executors.newScheduledThreadPool(simulationSettings.getInitialCorePoolSize());
    }

    public void start() {
        controller.getIslandMap().init();
        controller.getIslandMap().fill(simulationSettings.getMaxIslandObjectsOnLocation());

        executorService.scheduleWithFixedDelay(controller.getIslandStatistics().createShowStatsTask(),
                100,
                100,
                TimeUnit.MILLISECONDS);

        executorService.scheduleWithFixedDelay(controller.createLifeCycle(),
                100,
                100,
                TimeUnit.MILLISECONDS);

//        executorService.scheduleWithFixedDelay(controller.getIslandMap().createPlantGrow(),
//                100,
//                100,
//                TimeUnit.MILLISECONDS);
    }

}
