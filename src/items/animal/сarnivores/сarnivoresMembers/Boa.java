package items.animal.сarnivores.сarnivoresMembers;

import items.animal.Animal;
import items.animal.сarnivores.Carnivore;

public class Boa extends Carnivore {

    public Boa() {
        super(1, 1, 1, 1);
    }

    @Override
    public Animal reproduce() {
        return new Boa();
    }
}
