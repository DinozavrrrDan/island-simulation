package items.animal.carnivores;

import items.animal.Animal;

public abstract class Carnivore extends Animal {
    public Carnivore(double weight, int maxOnSquare, int speed, double enoughFoodForFullSaturation) {
        super(weight, maxOnSquare, speed, enoughFoodForFullSaturation, "Add unicode to pred");
    }
}
