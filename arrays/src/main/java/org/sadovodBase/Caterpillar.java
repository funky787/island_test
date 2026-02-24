package org.sadovodBase;

import java.util.ArrayList;

public class Caterpillar extends Herbivore{
    public Caterpillar(int x, int y, Island island){
        super(x, y, island);

    }
    @Override
    protected void eat(){
        Location loc = island.getLocation(x, y);
        if (!loc.getPlants().isEmpty()){
            Plant plant = loc.getPlants().remove(0);
            hunger = Math.max(0, hunger - plant.getGolod());
            System.out.printf("Гуссеница на (%d,%d) съел растение%n", x, y);

        }
    }
    @Override
    protected void reproduce() {
        Location loc = island.getLocation(x, y);
        int count = 0;
        for (Animal a : new ArrayList<>(loc.getAnimals())) {
            if (a instanceof Caterpillar && a != this && a.isAlive()){
                count++;
            }
        }
        if (count > 0 && Math.random() < 0.2) {
            Caterpillar baby = new Caterpillar(x, y, island);
            loc.addAnimal(baby);
            System.out.printf("На (%d,%d) родилась Гусеница%n", x, y);
        }
    }
}
