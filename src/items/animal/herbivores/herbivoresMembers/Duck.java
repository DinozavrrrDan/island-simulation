package items.animal.herbivores.herbivoresMembers;

import items.animal.Animal;
import items.animal.herbivores.Herbivore;

public class Duck extends Herbivore {
    @Override
    public Animal reproduce() {
        return new Duck();
    }
}
