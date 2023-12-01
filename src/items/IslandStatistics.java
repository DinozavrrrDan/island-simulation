package items;

import island.IslandMap;
import island.Location;
import simulation.SimulationSettings;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IslandStatistics {

    private final SimulationSettings simulationSettings;
    private final IslandMap islandMap;

    public IslandStatistics(SimulationSettings simulationSettings, IslandMap islandMap) {
        this.simulationSettings = simulationSettings;
        this.islandMap = islandMap;
    }

    public Runnable createShowStatsTask(){
        return () -> printStats(collectStatistics());
    }

    private Map<String, Integer> collectStatistics() {
        Map<String, Integer> islandObjectsStatistics = new ConcurrentHashMap<>();

        for (int y = 0; y < islandMap.getWidth(); y++) {
            for (int x = 0; x < islandMap.getHeight(); x++) {
                Location location = islandMap.getLocations()[y][x];

                List<IslandObject> islandObjects = location.getIslandObjects();

                for (IslandObject islandObject : islandObjects) {
                    String islandObjectString = islandObject.getClass().getSimpleName();
                    String unicodeSymbol = "";

                    islandObjectsStatistics.merge(unicodeSymbol, 1, (oldValue, newValue) -> oldValue + 1);
                }

            }
        }
        return islandObjectsStatistics;
    }

    private void printStats(Map<String, Integer> islandObjectsStatistics) {

        System.out.println();

        islandObjectsStatistics.forEach((key, value) -> System.out.println(MessageFormat.format("", key, value)));
    }

}
