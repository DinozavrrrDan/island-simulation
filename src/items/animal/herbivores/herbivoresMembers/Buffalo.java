package items.animal.herbivores.herbivoresMembers;

import items.animal.Animal;
import items.animal.herbivores.Herbivore;

public class Buffalo extends Herbivore {
    public Buffalo() {
        super(1, 1, 1, 1, "");
    }

    @Override
    public Animal reproduce() {
        return new Buffalo();
    }
}
