package items.animal.herbivores;

import items.IslandObject;
import items.animal.Animal;
import items.animal.herbivores.herbivoresMembers.Deer;
import lombok.AllArgsConstructor;


public abstract class Herbivore extends Animal {
    protected Herbivore(Double weight, Integer maxOnSquare, Integer speed, Double enoughFoodForFullSaturation, String unicode) {
        super(weight, maxOnSquare, speed, enoughFoodForFullSaturation, unicode);
    }

}
