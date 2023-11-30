package items.animal.carnivores.carnivoresMembers;

import annotations.IslandObject;
import items.animal.Animal;
import items.animal.carnivores.Carnivore;

@IslandObject(name = "hog")
public class Hog extends Carnivore {
    public Hog(Double weight, Integer maxOnSquare, Integer speed, Double enoughFoodForFullSaturation, String unicode) {
        super(weight, maxOnSquare, speed, enoughFoodForFullSaturation, unicode);
    }

    @Override
    public Animal reproduce() {
        return null;
    }
}
