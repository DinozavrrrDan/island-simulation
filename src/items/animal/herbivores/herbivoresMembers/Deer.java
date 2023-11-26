package items.animal.herbivores.herbivoresMembers;

import annotations.IslandObject;
import items.animal.Animal;
import items.animal.herbivores.Herbivore;

import javax.swing.*;

@IslandObject(name = "deer")
public class Deer extends Herbivore {

    public Deer(double weight, int maxOnSquare, int speed, double enoughFoodForFullSaturation, String unicode) {
        super(weight, maxOnSquare, speed, enoughFoodForFullSaturation, unicode);
    }

    @Override
    public Animal reproduce() {
        return new Deer(1.0, 1, 1, 1.0, "");
    }
}
