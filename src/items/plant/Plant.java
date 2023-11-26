package items.plant;

import items.IslandObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Plant extends IslandObject {

    private double weight;
    private int maxOnSquare;
    @Override
    public int getMaxOnSquare() {
        return super.getMaxOnSquare();
    }

    @Override
    public double getWeight() {
        return super.getWeight();
    }
}
