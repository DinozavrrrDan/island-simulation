package items.animal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Actions {
    MOVE(90),
    EAT(100),
    REPRODUCE(50),
    SLEEP(30);

    private final int actionChance;
}
