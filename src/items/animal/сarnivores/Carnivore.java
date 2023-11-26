package items.animal.сarnivores;

import items.animal.Animal;

public abstract class Carnivore extends Animal {
    public Carnivore(double weight, int maxOnSquare, int speed, double enoughFoodForFullSaturation) {
        super(weight, maxOnSquare, speed, enoughFoodForFullSaturation);
    }
}
