package org.sadovodBase;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class IslandTest {

    @Test
    void constructor_createsGridWithCorrectSizeAndNonNullLocations() {
        Island island = new Island(3, 2);

        assertEquals(3, island.getWidth());
        assertEquals(2, island.getHeight());

        for (int y = 0; y < island.getHeight(); y++) {
            for (int x = 0; x < island.getWidth(); x++) {
                assertNotNull(island.getLocation(x, y),
                        "Location should not be null at (" + x + "," + y + ")");
            }
        }
    }

    @Test
    void getLocation_returnsSameInstanceForSameCoordinates() {
        Island island = new Island(2, 2);
        Location a = island.getLocation(1, 1);
        Location b = island.getLocation(1, 1);
        assertSame(a, b);
    }

    @Test
    void getLocation_outOfBounds_throwsIllegalArgumentException() {
        Island island = new Island(2, 2);

        IllegalArgumentException ex1 =
                assertThrows(IllegalArgumentException.class, () -> island.getLocation(-1, 0));
        assertTrue(ex1.getMessage().contains("вне карты"));

        assertThrows(IllegalArgumentException.class, () -> island.getLocation(0, -1));
        assertThrows(IllegalArgumentException.class, () -> island.getLocation(2, 0));
        assertThrows(IllegalArgumentException.class, () -> island.getLocation(0, 2));
    }
}