package com.dinozavrrr.items.animal.carnivores.carnivoresMembers;

import com.dinozavrrr.annotations.IslandObject;
import com.dinozavrrr.items.animal.Animal;
import com.dinozavrrr.items.animal.carnivores.Carnivore;

@IslandObject(name = "boa")
public class Boa extends Carnivore {

    public Boa(Double weight, Integer maxOnSquare, Integer speed, Double enoughFoodForFullSaturation, String unicode) {
        super(weight, maxOnSquare, speed, enoughFoodForFullSaturation, unicode);
    }

}
