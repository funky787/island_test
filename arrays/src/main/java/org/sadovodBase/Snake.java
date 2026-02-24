package org.sadovodBase;

import java.util.ArrayList;

public class Snake extends Predator{
    public Snake(int x, int y, Island island){
        super(x, y, island);
    }
    @Override
    protected void eat(){
        Location loc = island.getLocation(x, y);
        for (Animal a : new ArrayList<>(loc.getAnimals()) ){
            if (a instanceof Mouse){
                loc.removeAnimal(a);
                hunger = Math.max(0, hunger - 4);
                System.out.printf("Удав на (%d,%d) схавал %s%n", x, y, a.getClass().getSimpleName());
                break;
            }
        }
    }
    @Override
    protected void reproduce() {
        Location loc = island.getLocation(x, y);
        int count = 0;
        for (Animal a : new ArrayList<>(loc.getAnimals())) {
            if (a instanceof Snake && a != this && a.isAlive()){
                count++;
            }
        }
        if (count > 0 && Math.random() < 0.2) {
            Snake baby = new Snake(x, y, island);
            loc.addAnimal(baby);
            System.out.printf("На (%d,%d) родился Удав%n", x, y);
        }
    }
}
