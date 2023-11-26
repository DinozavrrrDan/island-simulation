package items.animal;

import annotations.Property;
import items.IslandObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Animal extends IslandObject {

    public static final int BOUND = 100;

    @Property(propertyName = "weight")
    private double weight;
    @Property(propertyName = "maxOnSquare")
    private int maxOnSquare;
    @Property(propertyName = "speed")
    private int speed;
    @Property(propertyName = "enoughFoodForFullSaturation")
    private double enoughFoodForFullSaturation;
    @Property(propertyName = "unicode")
    private String unicode;
    private double healthPoints;


    protected Animal(double weight, int maxOnSquare, int speed, double healthPoints) {
        this.weight = weight;
        this.maxOnSquare = maxOnSquare;
        this.speed = speed;
        this.enoughFoodForFullSaturation = healthPoints;
        this.unicode = "";
        this.healthPoints = healthPoints;
    }

    public abstract Animal reproduce();
    public void eat(IslandObject food) {
        if (food.getWeight() >= this.getEnoughFoodForFullSaturation()) {
            this.setHealthPoints(this.getEnoughFoodForFullSaturation());
        } else {
            double hungerAfterEating = this.getHealthPoints() + food.getWeight();
            this.setHealthPoints(hungerAfterEating);
        }
    }

    public Actions chooseAction() {
        var action = Actions.values()[ThreadLocalRandom.current()
                .nextInt(Actions.values().length)];
        boolean isActiveAction = ThreadLocalRandom.current().nextInt(BOUND) < action.getActionChance();
        return isActiveAction ? action : Actions.SLEEP;
    }

    public Direction selectDirection() {
        return Direction.values()[ThreadLocalRandom.current()
                .nextInt(Direction.values().length)];
    }

    @Override
    public double getWeight() {
        return super.getWeight();
    }

    @Override
    public int getMaxOnSquare() {
        return super.getMaxOnSquare();
    }
}
