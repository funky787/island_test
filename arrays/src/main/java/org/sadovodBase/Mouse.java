package org.sadovodBase;


import java.util.ArrayList;

public class Mouse extends Herbivore{
    public Mouse (int x, int y, Island island){
        super(x, y, island);
    }
    @Override
    protected void eat(){
        Location loc = island.getLocation(x, y);
        if (!loc.getPlants().isEmpty()){
            Plant plant = loc.getPlants().remove(0);
            hunger = Math.max(0, hunger - plant.getGolod());
            System.out.printf("Мышь на (%d,%d) съел растение%n", x, y);

        }
    }
    @Override
    protected void reproduce() {
        Location loc = island.getLocation(x, y);
        int count = 0;
        for (Animal a : new ArrayList<>(loc.getAnimals())) {
            if (a instanceof Mouse && a != this && a.isAlive()){
                count++;
            }
        }
        if (count > 0 && Math.random() < 0.2) {
            Mouse baby = new Mouse(x, y, island);
            loc.addAnimal(baby);
            System.out.printf("На (%d,%d) родилась Мышь%n", x, y);
        }
    }
}
