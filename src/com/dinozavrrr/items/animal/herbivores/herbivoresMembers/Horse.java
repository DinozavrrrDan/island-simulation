package com.dinozavrrr.items.animal.herbivores.herbivoresMembers;

import com.dinozavrrr.annotations.IslandObject;
import com.dinozavrrr.items.animal.Animal;
import com.dinozavrrr.items.animal.herbivores.Herbivore;

@IslandObject(name = "horse")
public class Horse extends Herbivore {
    public Horse(Double weight, Integer maxOnSquare, Integer speed, Double enoughFoodForFullSaturation, String unicode) {
        super(weight, maxOnSquare, speed, enoughFoodForFullSaturation, unicode);
    }

}
