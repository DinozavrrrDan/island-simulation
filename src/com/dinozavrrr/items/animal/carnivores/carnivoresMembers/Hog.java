package com.dinozavrrr.items.animal.carnivores.carnivoresMembers;

import com.dinozavrrr.annotations.IslandObject;
import com.dinozavrrr.items.animal.Animal;
import com.dinozavrrr.items.animal.carnivores.Carnivore;

@IslandObject(name = "hog")
public class Hog extends Carnivore {
    public Hog(Double weight, Integer maxOnSquare, Integer speed, Double enoughFoodForFullSaturation, String unicode) {
        super(weight, maxOnSquare, speed, enoughFoodForFullSaturation, unicode);
    }

}
