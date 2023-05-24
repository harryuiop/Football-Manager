package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.LOGIC.Athlete;
import main.LOGIC.Item;
import main.LOGIC.Player;
import main.LOGIC.Team;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class TeamTests {

	private Team team;
    private Athlete athlete1;
    private Athlete athlete2;
    private Athlete athlete3;
    private Athlete athlete4;
    private Athlete athlete5;
    private Athlete athlete6;
    private Athlete athlete7;
    private Athlete athlete8;


    @BeforeEach
    public void setUp() {
        team = new Team();
        athlete1 = new Athlete(50, 40, 1, 1, "John");
        athlete2 = new Athlete(60, 80, 1, 1, "Harry");
        athlete3 = new Athlete(70, 30, 1, 1, "Callum");
        athlete4 = new Athlete(70, 30, 1, 1, "Callum");
        athlete5 = new Athlete(70, 30, 1, 1, "James");
        athlete6 = new Athlete(70, 30, 1, 1, "Leon");
        athlete7 = new Athlete(70, 30, 1, 1, "Liam");
        athlete8 = new Athlete(70, 30, 1, 1, "Ben");

        team.addStartingPlayer(athlete1);
        team.addStartingPlayer(athlete2);
        team.addStartingPlayer(athlete3);
        team.addStartingPlayer(athlete4);
        team.addReservePlayer(athlete5);
        team.addReservePlayer(athlete6);
        team.addReservePlayer(athlete7);
        team.addReservePlayer(athlete8);
    }

    @Test
    public void testMakeSubstituion() {
        team.makeSubstituion(athlete1, athlete3);

        Assert.assertFalse(team.getStartingName().contains(athlete1));
        Assert.assertTrue(team.getStartingName().contains(athlete3));
        Assert.assertFalse(team.getReserveName().contains(athlete3));
        Assert.assertTrue(team.getReserveName().contains(athlete1));
    }

    @Test
    public void testStartingTeamHealthy() {
        Assert.assertTrue(team.startingTeamHealthy(team));
        athlete1.setInjuryStatus(true);
        Assert.assertFalse(team.startingTeamHealthy(team));
    }

    @Test
    public void testReserveTeamHealthy() {
        Assert.assertTrue(team.reserveTeamHealthy(team));
        athlete5.setInjuryStatus(true);
        Assert.assertFalse(team.reserveTeamHealthy(team));
    }
    
    @Test
    public void testHowManyInjured() {
        athlete1.setInjuryStatus(true);
        athlete2.setInjuryStatus(true);
        athlete3.setInjuryStatus(true);

        int injuredCount = team.howManyInjured(team.getStartingName());

        Assertions.assertEquals(3, injuredCount);
    }

    
    @Test
    public void testRemoveReservePlayer() {
        int initialSize = team.getReserveName().size();
        int indexToRemove = 1;

        team.removeReservePlayer(indexToRemove);

        Assertions.assertEquals(initialSize - 1, team.getReserveName().size());
        Assertions.assertFalse(team.getReserveName().contains(athlete6));
    }
}


