package items.animal.carnivores.carnivoresMembers;

import items.animal.Animal;
import items.animal.carnivores.Carnivore;

public class Eagle extends Carnivore {
    public Eagle() {
        super(1, 1, 1, 1);
    }

    @Override
    public Animal reproduce() {
        return new Eagle();
    }
}
