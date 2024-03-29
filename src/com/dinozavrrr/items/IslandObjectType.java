package com.dinozavrrr.items;


import com.dinozavrrr.items.animal.carnivores.carnivoresMembers.*;
import com.dinozavrrr.items.animal.herbivores.herbivoresMembers.*;
import com.dinozavrrr.items.plant.plantsMembers.Grass;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum IslandObjectType {
    WOLF(Wolf.class),
    BEAR(Bear.class),
    BOA(Boa.class),
    EAGLE(Eagle.class),
    FOX(Fox.class),
    HOG(Hog.class),
    BUFFALO(Buffalo.class),
    CATERPILLAR(Caterpillar.class),
    DEER(Deer.class),
    DUCK(Duck.class),
    GOAT(Goat.class),
    HORSE(Horse.class),
    MOUSE(Mouse.class),
    RABBIT(Rabbit.class),
    SHEEP(Sheep.class),
    GRASS(Grass.class);
    private final Class aClass;
}
