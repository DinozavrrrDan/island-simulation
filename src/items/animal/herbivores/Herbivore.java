package items.animal.herbivores;

import items.animal.Animal;


public abstract class Herbivore extends Animal {
    protected Herbivore(Double weight, Integer maxOnSquare, Integer speed, Double enoughFoodForFullSaturation, String unicode) {
        super(weight, maxOnSquare, speed, enoughFoodForFullSaturation, unicode);
    }

}
