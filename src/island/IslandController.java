package island;

import items.animal.EatingMap;
import lombok.Getter;
import lombok.Setter;
import simulation.SimulationSettings;

@Getter
@Setter
public class IslandController {
    private IslandMap map;
    private EatingMap eatingMap;
    private final SimulationSettings simulationSettings;

    public IslandController(IslandMap map, EatingMap eatingMap, SimulationSettings simulationSettings) {
        this.map = map;
        this.eatingMap = eatingMap;
        this.simulationSettings = simulationSettings;
    }


}
