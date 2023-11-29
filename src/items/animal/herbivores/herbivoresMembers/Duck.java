package items.animal.herbivores.herbivoresMembers;

import annotations.IslandObject;
import items.animal.Animal;
import items.animal.herbivores.Herbivore;


@IslandObject(name = "duck")
public class Duck extends Herbivore {
    public Duck(double weight, int maxOnSquare, int speed, double enoughFoodForFullSaturation, String unicode) {
        super(weight, maxOnSquare, speed, enoughFoodForFullSaturation, unicode);
    }

    @Override
    public Animal reproduce() {
        return null;
    }
}
