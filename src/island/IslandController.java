package island;

import items.IslandStatistics;
import items.animal.Actions;
import items.animal.Animal;
import lombok.Getter;
import lombok.Setter;
import services.ActionService;
import services.HealthService;
import services.impl.ActionServiceImpl;
import services.impl.HealthServiceImpl;
import simulation.SimulationSettings;
import simulation.SimulationStarter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class IslandController {
    private final IslandMap islandMap;
    private final SimulationSettings simulationSettings;
    private final ExecutorService locationRunExecutor;
    private final ActionService actionService;
    private final IslandStatistics islandStatistics;
    private final HealthService healthService;

    public static final AtomicInteger TACT_NUMBER = new AtomicInteger(0);

    public IslandController(IslandMap islandMap, SimulationSettings simulationSettings) {
        this.islandMap = islandMap;
        this.simulationSettings = simulationSettings;
        this.islandStatistics = new IslandStatistics(islandMap);
        this.locationRunExecutor = Executors.newWorkStealingPool();
        this.healthService = new HealthServiceImpl(simulationSettings);
        this.actionService = new ActionServiceImpl(islandMap, healthService);
    }

    public Runnable createLifeCycle() {
        return () -> {
            for (int coordinateY = 0; coordinateY < islandMap.getHeight(); coordinateY++) {
                for (int coordinateX = 0; coordinateX < islandMap.getWidth(); coordinateX++) {

                    Location location = islandMap.getLocations()[coordinateY][coordinateX];
                    locationRunExecutor.submit(createLocationTask(location));

                }
                int currentTact = TACT_NUMBER.getAndIncrement();

                if (isEndLifeCycle(currentTact)) {
                    stopSimulation();
                }
            }
        };

    }

    private boolean isEndLifeCycle(int currentTact) {
        return currentTact >= simulationSettings.getMaxNumberOfTact();
    }

    private void stopSimulation() {
        SimulationStarter.executorService.shutdown();
    }

    private Runnable createLocationTask(Location location) {
        return () -> {
            List<Animal> animals = new CopyOnWriteArrayList<>(location.getAnimals());
            for (Animal animal : animals) {
                if (!animal.isAlive()) {
                    location.removeIslandObject(animal);
                    continue;
                }
                Actions actions = animal.chooseAction();
                doAction(actions, animal, location);
            }
        };

    }

    private void doAction(Actions action, Animal animal, Location location) {
        switch (action) {
            case MOVE -> actionService.doMove(animal, location);
            case EAT -> actionService.doEat(animal, location);
            case REPRODUCE -> actionService.doReproduce(animal, location);
            case SLEEP -> actionService.doSleep(animal);
        }
        healthService.reduceHealth(animal);
    }

}
