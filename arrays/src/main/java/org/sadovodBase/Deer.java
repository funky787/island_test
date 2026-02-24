package org.sadovodBase;

import java.util.ArrayList;

public class Deer extends Herbivore{
    public Deer(int x, int y, Island island) {
        super(x, y, island);
    }
    @Override
    protected void eat(){
        Location loc = island.getLocation(x, y);
        if (!loc.getPlants().isEmpty()){
            Plant plant = loc.getPlants().remove(0);
            hunger = Math.max(0, hunger - plant.getGolod());
            System.out.printf("Лось на (%d,%d) съел растение%n", x, y);

        }
    }
    @Override
    protected void reproduce() {
        Location loc = island.getLocation(x, y);
        int count = 0;
        for (Animal a : new ArrayList<>(loc.getAnimals())) {
            if (a instanceof Deer && a != this && a.isAlive()){
                count++;
            }
        }
        if (count > 0 && Math.random() < 0.2) {
            Deer baby = new Deer (x, y, island);
            loc.addAnimal(baby);
            System.out.printf("На (%d,%d) родился Лось%n", x, y);
        }
    }


}
