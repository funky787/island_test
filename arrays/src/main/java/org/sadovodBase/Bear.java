package org.sadovodBase;
import java.util.ArrayList;


public class Bear extends Predator{
    public Bear(int x, int y, Island island) {
        super(x, y, island);
    }
    @Override
    public void eat(){
        Location loc = island.getLocation(x, y);
        for(Animal a : new ArrayList<>(loc.getAnimals())){
            if ((a instanceof Herbivore) || (a instanceof Predator && !(a instanceof Bear))){
                loc.removeAnimal(a);
                hunger = Math.max(0, hunger - 7);
                System.out.printf("Медведь на (%d,%d) схавал %s%n", x, y, a.getClass().getSimpleName());
                break;
            }
        }
    }
    @Override
    protected void reproduce() {
        Location loc = island.getLocation(x, y);
        int count = 0;
        for (Animal a : new ArrayList<>(loc.getAnimals())) {
            if (a instanceof Bear && a != this && a.isAlive()){
                count++;
            }
        }
        if (count > 0 && Math.random() < 0.2) {
           Bear baby = new Bear(x, y, island);
            loc.addAnimal(baby);
            System.out.printf("На (%d,%d) родился Медведь%n", x, y);
        }
    }
}
