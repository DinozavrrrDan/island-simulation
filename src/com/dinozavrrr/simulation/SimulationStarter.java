package com.dinozavrrr.simulation;

import com.dinozavrrr.dialog.UserDialog;
import com.dinozavrrr.island.IslandController;
import com.dinozavrrr.island.IslandMap;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SimulationStarter {
    public static final int INITIAL_DELAY = 100;
    public static final int DELAY = 100;
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
                INITIAL_DELAY,
                DELAY,
                TimeUnit.MILLISECONDS);

        executorService.scheduleWithFixedDelay(controller.createLifeCycle(),
                INITIAL_DELAY,
                DELAY,
                TimeUnit.MILLISECONDS);

        executorService.scheduleWithFixedDelay(controller.getIslandMap().createPlantGrow(),
                INITIAL_DELAY,
                DELAY,
                TimeUnit.MILLISECONDS);
    }

}
