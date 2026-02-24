package org.sadovodBase;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LocationTest {

    @Test
    void addPlant_addsToList() {
        Location loc = new Location();
        assertTrue(loc.getPlants().isEmpty());

        Plant p = new Plant(3);
        loc.addPlant(p);

        assertEquals(1, loc.getPlants().size());
        assertSame(p, loc.getPlants().get(0));
    }

    @Test
    void addAndRemoveAnimal_updatesList() {
        Island island = new Island(1, 1);
        Location loc = island.getLocation(0, 0);

        Animal a = new TestAnimal(0, 0, island);

        assertEquals(1, loc.getAnimals().size());
        assertSame(a, loc.getAnimals().get(0));

        loc.removeAnimal(a);
        assertTrue(loc.getAnimals().isEmpty());
    }

    static class TestAnimal extends Animal {
        TestAnimal(int x, int y, Island island) {
            super(x, y, island);
        }

        @Override
        protected void eat() {
        }

        @Override
        protected void reproduce() {
        }

        @Override
        protected void move() {
        }
    }
}