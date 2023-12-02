package items.animal.carnivores;

import items.IslandObject;
import items.animal.Animal;

public abstract class Carnivore extends Animal {
    public Carnivore(double weight, int maxOnSquare, int speed, double enoughFoodForFullSaturation, String unicode) {
        super(weight, maxOnSquare, speed, enoughFoodForFullSaturation, unicode);
    }
}
