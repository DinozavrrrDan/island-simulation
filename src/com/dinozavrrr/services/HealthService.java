package com.dinozavrrr.services;

import com.dinozavrrr.items.animal.Animal;

public interface HealthService {
    public void increaseHealth(Animal animal);

    public void reduceHealth(Animal animal);

}
