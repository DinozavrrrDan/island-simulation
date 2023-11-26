package items.animal.herbivores.herbivoresMembers;

import items.animal.Animal;
import items.animal.herbivores.Herbivore;

public class Sheep extends Herbivore {

    public Sheep() {
        super(70, 140, 3, 15, "");
    }

    @Override
    public Animal reproduce() {
        return null;
    }
}
