package org.sadovodBase;

public class Main {
    public static void main(String[] args) {
        Island island = new Island(100, 20);


        for (int i = 0; i < 500; i++) {
            int x = randX(island);
            int y = randY(island);
            island.getLocation(x, y).addPlant(new Plant(5));
        }


        for (int i = 0; i < 10; i++) island.getLocation(randX(island), randY(island)).addAnimal(new Hare(randX(island), randY(island), island));
        for (int i = 0; i < 10; i++) island.getLocation(randX(island), randY(island)).addAnimal(new Deer(randX(island), randY(island), island));
        for (int i = 0; i < 10; i++) island.getLocation(randX(island), randY(island)).addAnimal(new Mouse(randX(island), randY(island), island));
        for (int i = 0; i < 10; i++) island.getLocation(randX(island), randY(island)).addAnimal(new Goat(randX(island), randY(island), island));
        for (int i = 0; i < 10; i++) island.getLocation(randX(island), randY(island)).addAnimal(new Sheep(randX(island), randY(island), island));
        for (int i = 0; i < 10; i++) island.getLocation(randX(island), randY(island)).addAnimal(new Pig(randX(island), randY(island), island));
        for (int i = 0; i < 10; i++) island.getLocation(randX(island), randY(island)).addAnimal(new Bull(randX(island), randY(island), island));
        for (int i = 0; i < 10; i++) island.getLocation(randX(island), randY(island)).addAnimal(new Horse(randX(island), randY(island), island));
        for (int i = 0; i < 10; i++) island.getLocation(randX(island), randY(island)).addAnimal(new Duck(randX(island), randY(island), island));
        for (int i = 0; i < 10; i++) island.getLocation(randX(island), randY(island)).addAnimal(new Caterpillar(randX(island), randY(island), island));




        for (int i = 0; i < 5; i++) island.getLocation(randX(island), randY(island)).addAnimal(new Wolf(randX(island), randY(island), island));
        for (int i = 0; i < 3; i++) island.getLocation(randX(island), randY(island)).addAnimal(new Bear(randX(island), randY(island), island));
        for (int i = 0; i < 5; i++) island.getLocation(randX(island), randY(island)).addAnimal(new Eagle(randX(island), randY(island), island));
        for (int i = 0; i < 5; i++) island.getLocation(randX(island), randY(island)).addAnimal(new Fox(randX(island), randY(island), island));
        for (int i = 0; i < 5; i++) island.getLocation(randX(island), randY(island)).addAnimal(new Snake(randX(island), randY(island), island));


        for (int t = 0; t < 10; t++) {
            System.out.println("\n=== Шаг " + (t + 1) + " ===");
            island.step();
            island.printMap();
        }
    }

    private static int randX(Island island) {
        return (int)(Math.random() * island.getWidth());
    }

    private static int randY(Island island) {
        return (int)(Math.random() * island.getHeight());
    }
}