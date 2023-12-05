package com.dinozavrrr.items.animal.carnivores.carnivoresMembers;

import com.dinozavrrr.annotations.IslandObject;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.dinozavrrr.items.animal.Animal;
import com.dinozavrrr.items.animal.carnivores.Carnivore;

@IslandObject(name = "wolf")
@JsonDeserialize(as = Wolf.class)
public class Wolf extends Carnivore {
    public Wolf(Double weight, Integer maxOnSquare, Integer speed, Double enoughFoodForFullSaturation, String unicode) {
        super(weight, maxOnSquare, speed, enoughFoodForFullSaturation, unicode);
    }

}
