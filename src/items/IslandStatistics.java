package items;

import island.IslandController;
import island.IslandMap;
import island.Location;
import simulation.SimulationSettings;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IslandStatistics {

    private final IslandMap islandMap;

    public IslandStatistics(IslandMap islandMap) {
        this.islandMap = islandMap;
    }

    public Runnable createShowStatsTask() {
        return () -> {
            System.out.println("createShowStatsTask");
            printStats(collectStatistics());
        };
    }

    private Map<String, Integer> collectStatistics() {
        System.out.println("collectStatistics");
        Map<String, Integer> islandObjectsStatistics = new ConcurrentHashMap<>();

        for (int y = 0; y < islandMap.getWidth(); y++) {
            for (int x = 0; x < islandMap.getHeight(); x++) {
                System.out.println("islandObjectsStatistics1");
                System.out.println(islandObjectsStatistics);
                islandMap.getLocations()[y][x]
                        .getIslandObjects()
                        .forEach(islandObject -> islandObjectsStatistics
                                .merge(islandObject.getUnicode(), 1, (oldValue, newValue) -> oldValue + 1));
            }
            System.out.println("islandObjectsStatistics2");
        }
        return islandObjectsStatistics;
    }

    private void printStats(Map<String, Integer> islandObjectsStatistics) {
        System.out.println("printStats");
        System.out.println();
        System.out.println(MessageFormat.format("*** Tact {0} ***", IslandController.TACT_NUMBER));
        islandObjectsStatistics
                .forEach((key, value) -> System.out.println(MessageFormat.format("{0} - {1}", key, value)));
        System.out.println('\n');
    }

}
