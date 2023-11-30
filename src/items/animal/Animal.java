package items.animal;

import annotations.Parent;
import annotations.Property;
import items.IslandObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@Parent
@AllArgsConstructor
@NoArgsConstructor
public abstract class Animal extends IslandObject {

    public static final int BOUND = 100;

    @Property(propertyName = "weight", priority = 0, type = "Double")
    private Double weight;
    @Property(propertyName = "maxOnSquare", priority = 1, type = "Integer")
    private Integer maxOnSquare;
    @Property(propertyName = "speed", priority = 2, type = "Integer")
    private Integer speed;
    @Property(propertyName = "enoughFoodForFullSaturation", priority = 3, type = "Double")
    private Double enoughFoodForFullSaturation;
    @Property(propertyName = "unicode", priority = 4, type = "String")
    private String unicode;
    @JsonIgnore
    private Double healthPoints;


    protected Animal(Double weight, Integer maxOnSquare, Integer speed, Double healthPoints, String unicode) {
        this.weight = weight;
        this.maxOnSquare = maxOnSquare;
        this.speed = speed;
        this.enoughFoodForFullSaturation = healthPoints;
        this.unicode = unicode;
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
