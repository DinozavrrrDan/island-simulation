package items.animal.herbivores.herbivoresMembers;

import items.animal.Animal;
import items.animal.herbivores.Herbivore;

public class Rabbit extends Herbivore {
    public Rabbit() {
        super(400, 20, 4, 60, "");
    }

    @Override
    public Animal reproduce() {
        return new Rabbit();
    }
}
