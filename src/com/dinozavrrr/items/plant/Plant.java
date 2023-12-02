package com.dinozavrrr.items.plant;

import com.dinozavrrr.items.IslandObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class Plant extends IslandObject {

    private Double weight;
    private Integer maxOnSquare;

    public Plant(Double weight, Integer maxOnSquare) {
        this.weight = weight;
        this.maxOnSquare = maxOnSquare;
    }
}
