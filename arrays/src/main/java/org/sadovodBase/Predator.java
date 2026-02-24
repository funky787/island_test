package org.sadovodBase;
import java.util.Iterator;
import java.util.ArrayList;
public class Predator extends Animal {
    public Predator(int x, int y, Island island) {
        super(x, y, island);
    }
    @Override
    protected void eat() {
        Location loc = island.getLocation(x, y);
        boolean ate = false;

        for (Animal a : new ArrayList<>(loc.getAnimals())) {
            if (a instanceof Herbivore) {
                loc.removeAnimal(a);
                hunger = Math.max(0, hunger - 5);
                System.out.printf("Хищник на (%d,%d) съел травоядное%n", x, y);
                ate = true;
                break;
            }
        }

        if (!ate) {
            System.out.printf("Хищник на (%d,%d) не нашел травоядных%n", x, y);
        }
    }
    @Override
    protected void reproduce() {
        Location loc = island.getLocation(x, y);
        int count = 0;
        for (Animal a : new ArrayList<>(loc.getAnimals())) {
            if (a instanceof Predator && a != this && a.isAlive()){
                count++;
            }
        }
        if (count > 0 && Math.random() < 0.2) {
            Predator baby = new Predator(x, y, island);
            loc.addAnimal(baby);
            System.out.printf("На (%d,%d) родился Хищник%n", x, y);
        }
    }
}
