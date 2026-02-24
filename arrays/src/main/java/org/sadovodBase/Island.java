package org.sadovodBase;

import java.util.ArrayList;

public class Island {
    private int width, height;
    private Location[][] map;

    public Island(int width, int height) {
        this.width = width;
        this.height = height;

        map = new Location[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                map[y][x] = new Location();
            }
        }
    }

    public Location getLocation(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IllegalArgumentException("Корды вне карты: x=" + x + ", y=" + y);
        }
        return map[y][x];
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public void step() {
        int totalAnimals = 0;
        int totalPlants = 0;
        int totalHares = 0;
        int totalDeers = 0;
        int totalWolves = 0;
        int totalBears = 0;
        int totalMouses = 0;
        int totalEagles = 0;
        int totalFoxes = 0;
        int totalGoats = 0;
        int totalSheeps = 0;
        int totalPigs = 0;
        int totalSnakes = 0;
        int totalBulls = 0;
        int totalHorses = 0;
        int totalDucks = 0;
        int totalCaterpillars = 0;





        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Location loc = map[y][x];
                totalAnimals += loc.getAnimals().size();
                totalPlants += loc.getPlants().size();

                for (var a : new ArrayList<>(loc.getAnimals())) {
                    a.step();
                    if (a instanceof Herbivore) totalHares++;
                    if (a instanceof Predator) totalDeers++;
                    if (a instanceof Herbivore) totalWolves++;
                    if (a instanceof Predator) totalBears++;
                    if (a instanceof Herbivore) totalMouses++;
                    if (a instanceof Predator) totalEagles++;
                    if (a instanceof Predator) totalFoxes++;
                    if (a instanceof Herbivore) totalGoats++;
                    if (a instanceof Herbivore) totalSheeps++;
                    if (a instanceof Herbivore) totalPigs++;
                    if (a instanceof Predator) totalSnakes++;
                    if (a instanceof Herbivore) totalBulls++;
                    if (a instanceof Herbivore) totalHorses++;
                    if (a instanceof Predator) totalDucks++;
                    if (a instanceof Herbivore) totalCaterpillars++;

                }
            }
        }

        System.out.printf(
                "Стата: животных = %d (Зайцев = %d, Лосей = %d, Волков = %d, Медведей = %d, Мышей = %d, Орлов = %d, Лис = %d, Коз = %d, Овец = %d, Кабанов = %d, Удавов = %d, Буйволы = %d, Лошадей = %d, Утки = %d, Гуссеница = %d), растений = %d%n",
                totalAnimals, totalHares, totalDeers, totalWolves, totalBears, totalMouses, totalEagles, totalFoxes, totalGoats, totalSheeps, totalPigs, totalSnakes, totalBulls, totalHorses, totalDucks, totalCaterpillars, totalPlants
        );
    }

    public void printMap() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Location loc = map[y][x];

                if (!loc.getAnimals().isEmpty()) {
                    if (loc.getAnimals().stream().allMatch(a -> a instanceof Bear)) {
                        System.out.printf("\uD83D\uDC3B");
                    } else if (loc.getAnimals().stream().allMatch(a -> a instanceof Wolf)) {
                        System.out.printf("\uD83D\uDC3A");
                    } else if (loc.getAnimals().stream().allMatch(a -> a instanceof Hare)) {
                        System.out.printf("\uD83D\uDC07");

                    } else if (loc.getAnimals().stream().allMatch(a -> a instanceof Deer)) {
                        System.out.printf("\uD83E\uDD8C");
                    } else if (loc.getAnimals().stream().allMatch(a -> a instanceof Mouse)) {
                        System.out.printf("\uD83D\uDC01");
                    } else if (loc.getAnimals().stream().allMatch(a -> a instanceof Eagle)) {
                        System.out.printf("\uD83E\uDD85");
                    } else if (loc.getAnimals().stream().allMatch(a -> a instanceof Fox)) {
                        System.out.printf("\uD83E\uDD8A");
                    } else if (loc.getAnimals().stream().allMatch(a -> a instanceof Goat)) {
                        System.out.printf("\uD83D\uDC10");
                    } else if (loc.getAnimals().stream().allMatch(a -> a instanceof Sheep)) {
                        System.out.printf("\uD83D\uDC11");
                    } else if (loc.getAnimals().stream().allMatch(a -> a instanceof Pig)) {
                        System.out.printf("\uD83D\uDC17");
                    } else if (loc.getAnimals().stream().allMatch(a -> a instanceof Snake)) {
                        System.out.printf("\uD83D\uDC0D");
                    } else if (loc.getAnimals().stream().allMatch(a -> a instanceof Bull)) {
                        System.out.printf("\uD83D\uDC03");
                    } else if (loc.getAnimals().stream().allMatch(a -> a instanceof Horse)) {
                        System.out.printf("\uD83D\uDC0E");
                    } else if (loc.getAnimals().stream().allMatch(a -> a instanceof Duck)){
                        System.out.printf("\uD83E\uDD86");
                    } else if (loc.getAnimals().stream().allMatch(a -> a instanceof Caterpillar)){
                        System.out.printf("\uD83D\uDC1B");
                    }
                    else {
                        System.out.printf("A");
                    }
                } else if (!loc.getPlants().isEmpty()) {
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}