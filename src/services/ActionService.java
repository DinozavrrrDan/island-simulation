package services;

import island.Location;
import items.animal.Animal;

public interface ActionService {
    void doMove(Animal animal, Location location);
    void doEat(Animal animal, Location location);
    void doReproduce(Animal animal, Location location);
    void doSleep(Animal animal);
}
