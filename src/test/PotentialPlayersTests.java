package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Athlete;
import main.PotentialPlayers;

import java.util.ArrayList;

class PotentialPlayersTests {

    private PotentialPlayers potentialPlayers;

    @BeforeEach
    void setUp() {
        potentialPlayers = new PotentialPlayers();
    }

    @Test
    void testCreatePlayers() {
        int numWeeks = 3;
        potentialPlayers.createPlayers(numWeeks);

        ArrayList<Athlete> allPlayers = potentialPlayers.getAllPlayers();

        // Check if the total number of players created is correct
        int expectedPlayerCount = numWeeks * 2 * 6; // 2 teams per week, 6 players per team
        Assertions.assertEquals(expectedPlayerCount, allPlayers.size());

        // Validate that all players have been created with valid attributes
        for (Athlete ath : allPlayers) {
            Assertions.assertTrue(ath.getOffence() >= 0 && ath.getOffence() <= 100);
            Assertions.assertTrue(ath.getDefence() >= 0 && ath.getDefence() <= 100);
            Assertions.assertTrue(ath.getPosition(ath) == 1 || ath.getPosition(ath) == 2);
            Assertions.assertTrue(ath.getRarity() >= 1 && ath.getRarity() <= 3);
            Assertions.assertNotNull(ath.getName(ath));
        }
    }

    @Test
    void testNameGenerator() {
    	ArrayList<String> copyBeforeRemoval = new ArrayList<String>();
    	copyBeforeRemoval.addAll(potentialPlayers.getNames());
        String name = potentialPlayers.nameGenerator();
        // Validate that a name is generated and it is not empty
        Assertions.assertNotNull(name);
        Assertions.assertFalse(name.isEmpty());

        // Validate that the generated name is removed from the names list
        ArrayList<String> names = potentialPlayers.getNames();
        Assertions.assertFalse(names.contains(name));
    }

    // Additional tests for getters and setters

    @Test
    void testGetAllPlayers() {
        ArrayList<Athlete> allPlayers = new ArrayList<>();
        allPlayers.add(new Athlete(80, 50, 1, 2, "John"));
        allPlayers.add(new Athlete(60, 30, 2, 1, "Michael"));

        potentialPlayers.setAllPlayers(allPlayers);

        Assertions.assertEquals(allPlayers, potentialPlayers.getAllPlayers());
    }

    @Test
    void testSetAllPlayers() {
        ArrayList<Athlete> allPlayers = new ArrayList<>();
        allPlayers.add(new Athlete(80, 50, 1, 2, "John"));
        allPlayers.add(new Athlete(60, 30, 2, 1, "Michael"));

        potentialPlayers.setAllPlayers(allPlayers);

        Assertions.assertEquals(allPlayers, potentialPlayers.getAllPlayers());
    }
}
