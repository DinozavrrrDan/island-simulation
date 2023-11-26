package items.animal.herbivores.herbivoresMembers;

import annotations.IslandObject;
import items.animal.Animal;
import items.animal.herbivores.Herbivore;

@IslandObject(name = "deer")
public class Deer extends Herbivore {

    public Deer() {
        super(300, 20, 4, 50);
    }

    @Override
    public Animal reproduce() {
        return new Deer();
    }
}
