package org.sadovodBase;

import java.util.ArrayList;

public class Duck extends Predator{
    public Duck(int x, int y, Island island) {
        super(x, y, island);
    }
    @Override
    protected void eat(){
        Location loc = island.getLocation(x, y);
        for (Animal a : new ArrayList<>(loc.getAnimals()) ){
            if (a instanceof Caterpillar){
                loc.removeAnimal(a);
                hunger = Math.max(0, hunger - 4);
                System.out.printf("Утка на (%d,%d) схавал %s%n", x, y, a.getClass().getSimpleName());
                break;
            }
        }
    }
    @Override
    protected void reproduce() {
        Location loc = island.getLocation(x, y);
        int count = 0;
        for (Animal a : new ArrayList<>(loc.getAnimals())) {
            if (a instanceof Duck && a != this && a.isAlive()){
                count++;
            }
        }
        if (count > 0 && Math.random() < 0.2) {
            Duck baby = new Duck(x, y, island);
            loc.addAnimal(baby);
            System.out.printf("На (%d,%d) родилась Утка%n", x, y);
        }
    }
}
