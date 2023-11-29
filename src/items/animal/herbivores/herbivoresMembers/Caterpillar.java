package items.animal.herbivores.herbivoresMembers;

import annotations.IslandObject;
import items.animal.Animal;
import items.animal.herbivores.Herbivore;

@IslandObject(name = "caterpillar")
public class Caterpillar extends Herbivore {
    public Caterpillar(double weight, int maxOnSquare, int speed, double enoughFoodForFullSaturation, String unicode) {
        super(weight, maxOnSquare, speed, enoughFoodForFullSaturation, unicode);
    }
    @Override
    public Animal reproduce() {
        return null;
    }
}
