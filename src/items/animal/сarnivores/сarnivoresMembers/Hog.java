package items.animal.сarnivores.сarnivoresMembers;

import items.animal.Animal;
import items.animal.сarnivores.Carnivore;

public class Hog extends Carnivore {
    public Hog() {
        super(1, 1, 1, 1);
    }

    @Override
    public Animal reproduce() {
        return new Hog();
    }
}
