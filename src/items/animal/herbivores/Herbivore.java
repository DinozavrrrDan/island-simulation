package items.animal.herbivores;

import items.animal.Animal;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Herbivore extends Animal {
    public Herbivore(double weight, int maxOnSquare, int speed, double enoughFoodForFullSaturation) {
        super(weight, maxOnSquare, speed, enoughFoodForFullSaturation);
    }
}
