package items.animal.herbivores.herbivoresMembers;

import items.animal.Animal;
import items.animal.herbivores.Herbivore;

public class Mouse extends Herbivore {
    @Override
    public Animal reproduce() {
        return new Mouse();
    }
}
