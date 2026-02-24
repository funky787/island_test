package org.sadovodBase;

import java.util.ArrayList;

public class Eagle extends Predator {
    public Eagle(int x, int y, Island island) {
        super(x, y, island);
    }

    @Override
    protected void eat() {
        Location loc = island.getLocation(x, y);
        for (Animal a : new ArrayList<>(loc.getAnimals())) {
            if (!a.isAlive()) continue; // защита
            if (a instanceof Mouse || a instanceof Caterpillar ) {
                loc.removeAnimal(a);
                hunger = Math.max(0, hunger - 4);
                System.out.printf("Орел на (%d,%d) съел мышь%n", x, y);
                break;
            }
        }
    }
    @Override
    protected void reproduce() {
        Location loc = island.getLocation(x, y);
        int count = 0;
        for (Animal a : new ArrayList<>(loc.getAnimals())) {
            if (a instanceof Eagle && a != this && a.isAlive()){
                count++;
            }
        }
        if (count > 0 && Math.random() < 0.2) {
            Eagle baby = new Eagle(x, y, island);
            loc.addAnimal(baby);
            System.out.printf("На (%d,%d) родился Орел%n", x, y);
        }
    }
}


