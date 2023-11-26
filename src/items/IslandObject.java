package items;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class IslandObject {
    private double weight;
    private int maxOnSquare;
    private String unicode;
}
