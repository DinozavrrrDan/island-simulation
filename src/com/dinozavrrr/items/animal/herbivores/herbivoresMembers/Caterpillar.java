package com.dinozavrrr.items.animal.herbivores.herbivoresMembers;

import com.dinozavrrr.annotations.IslandObject;
import com.dinozavrrr.items.animal.Animal;
import com.dinozavrrr.items.animal.herbivores.Herbivore;

@IslandObject(name = "caterpillar")
public class Caterpillar extends Herbivore {
    public Caterpillar(Double weight, Integer maxOnSquare, Integer speed, Double enoughFoodForFullSaturation, String unicode) {
        super(weight, maxOnSquare, speed, enoughFoodForFullSaturation, unicode);
    }

    @Override
    public Animal reproduce() {
        return null;
    }
}
