package simulation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SimulationSettings {
    private int widthMap;
    private int heightMap;
    private int maxIslandObjectsOnLocation;
    private int simulationCycles;
    private int reduceHealthPercent;
    private int initialCorePoolSize;
}
