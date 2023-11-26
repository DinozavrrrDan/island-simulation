package items.animal.herbivores.herbivoresMembers;

import items.animal.Animal;
import items.animal.herbivores.Herbivore;

public class Mouse extends Herbivore {
    public Mouse() {
        super(400, 20, 4, 60, "");
    }

    @Override
    public Animal reproduce() {
        return new Mouse();
    }
}
