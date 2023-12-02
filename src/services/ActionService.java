package services;

import island.Location;
import items.animal.Actions;
import items.animal.Animal;

public interface ActionService {

    void doAction(Actions action, Animal animal, Location location);
}