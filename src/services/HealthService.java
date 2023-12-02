package services;

import items.animal.Animal;

public interface HealthService {
    public void increaseHealth(Animal animal);
    public   void reduceHealth(Animal animal);
}
