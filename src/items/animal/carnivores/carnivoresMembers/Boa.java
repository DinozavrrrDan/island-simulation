package items.animal.carnivores.carnivoresMembers;

import annotations.IslandObject;
import items.animal.Animal;
import items.animal.carnivores.Carnivore;

@IslandObject(name = "boa")
public class Boa extends Carnivore {

    public Boa(double weight, int maxOnSquare, int speed, double enoughFoodForFullSaturation, String unicode) {
        super(weight, maxOnSquare, speed, enoughFoodForFullSaturation, unicode);
    }

    @Override
    public Animal reproduce() {
        return null;
    }
}
