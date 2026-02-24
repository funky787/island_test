package org.sadovodBase;
import java.util.ArrayList;

public class Wolf extends Predator{
    public Wolf(int x, int y, Island island) {
        super(x, y, island);

    }
    @Override
    protected void eat(){
        Location loc = island.getLocation(x, y);
        for (Animal a : new ArrayList<>(loc.getAnimals()) ){
            if (a instanceof Herbivore){
                loc.removeAnimal(a);
                hunger = Math.max(0, hunger - 5);
                System.out.printf("Волк на (%d,%d) схавал %s%n", x, y, a.getClass().getSimpleName());
                break;
            }
        }
    }
    @Override
    protected void reproduce() {
        Location loc = island.getLocation(x, y);
        int count = 0;
        for (Animal a : new ArrayList<>(loc.getAnimals())) {
            if (a instanceof Wolf && a != this && a.isAlive()){
                count++;
            }
        }
        if (count > 0 && Math.random() < 0.2) {
            Wolf baby = new Wolf(x, y, island);
            loc.addAnimal(baby);
            System.out.printf("На (%d,%d) родился Волк%n", x, y);
        }
    }

}
