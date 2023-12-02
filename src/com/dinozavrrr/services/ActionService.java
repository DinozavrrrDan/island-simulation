package com.dinozavrrr.services;

import com.dinozavrrr.island.Location;
import com.dinozavrrr.items.animal.Actions;
import com.dinozavrrr.items.animal.Animal;

public interface ActionService {

    void doAction(Actions action, Animal animal, Location location);
}