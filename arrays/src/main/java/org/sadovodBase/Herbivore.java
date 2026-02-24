package org.sadovodBase;

import java.util.ArrayList;

public class Herbivore extends Animal {
    public Herbivore(int x, int y, Island island) {
        super(x, y, island);

    }

    @Override
    protected void eat(){
        Location loc = island.getLocation(x, y);
        if (!loc.getPlants().isEmpty()){
            Plant plant = loc.getPlants().remove(0);
            hunger = Math.max(0, hunger - plant.getGolod());
            System.out.printf("Травоядное на (%d,%d) съело растение%n", x, y);

        }
    }
    @Override
    protected void reproduce() {
        Location loc = island.getLocation(x, y);
        int count = 0;
        for (Animal a : new ArrayList<>(loc.getAnimals())) {
            if (a instanceof Herbivore && a != this && a.isAlive()){
                count++;
            }
        }
        if (count > 0 && Math.random() < 0.2) {
            Herbivore baby = new Herbivore(x, y, island);
            loc.addAnimal(baby);
            System.out.printf("На (%d,%d) родился Травоядное%n", x, y);
        }
    }

}
