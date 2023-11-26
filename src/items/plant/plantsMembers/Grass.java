package items.plant.plantsMembers;

import items.plant.Plant;

public class Grass extends Plant {
    private final double weight = 1;
    private final int maxOnSquare = 200;
    @Override
    public int getMaxOnSquare() {
        return maxOnSquare;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}

