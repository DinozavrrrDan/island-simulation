package simulation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimulationSettings {
    private int widthMap = 100;
    private int heightMap = 200;
    private int maxIslandObjectsOnLocation = 100;
    private int simulationCycles = 100;
}
