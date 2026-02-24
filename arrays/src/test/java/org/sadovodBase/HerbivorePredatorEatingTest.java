package org.sadovodBase;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class HerbivorePredatorEatingTest {

    @Test
    void herbivore_eatsPlant_and_decreasesHunger_and_removesPlant() {
        Island island = new Island(1, 1);
        Location loc = island.getLocation(0, 0);

        loc.addPlant(new Plant(3));
        assertEquals(1, loc.getPlants().size());

        Hare hare = new Hare(0, 0, island);

        int before = hare.hunger;
        hare.eat();

        assertEquals(0, loc.getPlants().size());
        assertTrue(hare.hunger <= before, "Hunger should not increase after eating");
    }

    @Test
    void predator_eatsHerbivore_and_removesItFromLocation() {
        Island island = new Island(1, 1);
        Location loc = island.getLocation(0, 0);

        Hare prey = new Hare(0, 0, island);
        Wolf predator = new Wolf(0, 0, island);

        assertTrue(loc.getAnimals().contains(prey));
        int before = predator.hunger;

        predator.eat();

        assertFalse(loc.getAnimals().contains(prey), "Prey should be removed after being eaten");
        assertTrue(predator.hunger <= before, "Predator hunger should not increase after eating");
    }

    @Test
    void predator_doesNotEatPredator_whenNoHerbivorePresent() {
        Island island = new Island(1, 1);
        Location loc = island.getLocation(0, 0);

        Wolf w1 = new Wolf(0, 0, island);
        Wolf w2 = new Wolf(0, 0, island);

        int countBefore = loc.getAnimals().size();
        w1.eat();
        int countAfter = loc.getAnimals().size();

        assertEquals(countBefore, countAfter,
                "Predator should not remove other predators when hunting herbivores only");
    }

    @Test
    void reproduce_withNoPartner_createsNoBaby_deterministically() {
        Island island = new Island(1, 1);
        Location loc = island.getLocation(0, 0);

        Hare lone = new Hare(0, 0, island);
        int before = loc.getAnimals().size();


        lone.reproduce();

        assertEquals(before, loc.getAnimals().size());
    }
}