package org.sadovodBase;

import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionalIslandSimulationTest {

    private static String captureStdout(Runnable r) {
        PrintStream old = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(baos, true, StandardCharsets.UTF_8));
            r.run();
        } finally {
            System.setOut(old);
        }
        return baos.toString(StandardCharsets.UTF_8);
    }

    @Test
    void step_on1x1Island_runsAnimalStep_andPrintsStats() {
        Island island = new Island(1, 1);
        Location loc = island.getLocation(0, 0);

        loc.addPlant(new Plant(2));
        new Hare(0, 0, island);

        String out = captureStdout(island::step);

        assertTrue(out.contains("Стата:"), "Expected stats output from Island.step()");
    }

    @Test
    void printMap_rendersBearEmojiWhenOnlyBearsInCell() {
        Island island = new Island(1, 1);
        new Bear(0, 0, island);

        String out = captureStdout(island::printMap);

        assertTrue(out.contains("\uD83D\uDC3B") || out.contains("🐻"),
                "Expected bear emoji in map output");
    }
}