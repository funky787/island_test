package org.sadovodBase;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalClampAndLifecycleTest {

    @Test
    void constructor_clampsCoordinatesAndRegistersInCorrectCell() {
        Island island = new Island(2, 2);

        Animal a = new ExposingAnimal(999, -5, island); 

        Location expected = island.getLocation(1, 0);
        assertTrue(expected.getAnimals().contains(a));
    }

    @Test
    void step_increasesHunger_and_diesAfterThreshold() {
        Island island = new Island(1, 1);
        ExposingAnimal a = new ExposingAnimal(0, 0, island);


        for (int i = 0; i < 6; i++) {
            a.step();
        }

        assertFalse(a.isAlive());
        assertTrue(island.getLocation(0, 0).getAnimals().isEmpty(),
                "Dead animal must be removed from location");
    }

    @Test
    void clampX_and_clampY_keepCoordinatesInsideIsland() {
        Island island = new Island(3, 4);
        ExposingAnimal a = new ExposingAnimal(0, 0, island);

        assertEquals(0, a.callClampX(-100));
        assertEquals(2, a.callClampX(100));
        assertEquals(0, a.callClampY(-1));
        assertEquals(3, a.callClampY(999));
    }

    static class ExposingAnimal extends Animal {
        ExposingAnimal(int x, int y, Island island) { super(x, y, island); }
        @Override protected void eat() {}
        @Override protected void reproduce() {}
        @Override protected void move() {}

        int callClampX(int x) { return clampX(x); }
        int callClampY(int y) { return clampY(y); }
    }

}
