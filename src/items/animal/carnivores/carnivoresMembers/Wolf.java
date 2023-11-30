package items.animal.carnivores.carnivoresMembers;

import annotations.IslandObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import items.animal.Animal;
import items.animal.carnivores.Carnivore;

@IslandObject(name = "wolf")
@JsonDeserialize(as=Wolf.class)
public class Wolf extends Carnivore {
    public Wolf(Double weight, Integer maxOnSquare, Integer speed, Double enoughFoodForFullSaturation, String unicode) {
        super(weight, maxOnSquare, speed, enoughFoodForFullSaturation, unicode);
    }

    @Override
    public Animal reproduce() {
        return null;
    }
}
