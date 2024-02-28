package com.dinozavrrr.items.animal.herbivores.herbivoresMembers;

import com.dinozavrrr.annotations.IslandObject;
import com.dinozavrrr.items.animal.Animal;
import com.dinozavrrr.items.animal.herbivores.Herbivore;

@IslandObject(name = "buffalo")
public class Buffalo extends Herbivore {
    public Buffalo(Double weight, Integer maxOnSquare, Integer speed, Double enoughFoodForFullSaturation, String unicode) {
        super(weight, maxOnSquare, speed, enoughFoodForFullSaturation, unicode);
    }

}
