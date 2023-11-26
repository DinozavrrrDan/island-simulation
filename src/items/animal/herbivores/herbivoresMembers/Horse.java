package items.animal.herbivores.herbivoresMembers;

import annotations.IslandObject;
import items.animal.Animal;
import items.animal.herbivores.Herbivore;

public class Horse extends Herbivore {
    public Horse() {
        super(400, 20, 4, 60, "");
    }

    @Override
    public Animal reproduce() {
        return new Horse();
    }
}
