package items;


import items.animal.carnivores.carnivoresMembers.Bear;
import items.animal.carnivores.carnivoresMembers.Eagle;
import items.animal.carnivores.carnivoresMembers.Fox;
import items.animal.carnivores.carnivoresMembers.Wolf;
import items.animal.carnivores.carnivoresMembers.Boa;
import items.animal.carnivores.carnivoresMembers.Hog;
import items.animal.herbivores.herbivoresMembers.Buffalo;
import items.animal.herbivores.herbivoresMembers.Caterpillar;
import items.animal.herbivores.herbivoresMembers.Deer;
import items.animal.herbivores.herbivoresMembers.Duck;
import items.animal.herbivores.herbivoresMembers.Goat;
import items.animal.herbivores.herbivoresMembers.Horse;
import items.animal.herbivores.herbivoresMembers.Mouse;
import items.animal.herbivores.herbivoresMembers.Rabbit;
import items.animal.herbivores.herbivoresMembers.Sheep;
import items.plant.plantsMembers.Grass;
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
