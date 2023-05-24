package test;
import main.Player;
import main.Item;
import main.Team;
import main.Athlete;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
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

    

    @Before
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
        // Make a substitution in the team
        team.makeSubstituion(athlete1, athlete3);

        // Assert that the substitution was made correctly
        Assert.assertFalse(team.getStartingName().contains(athlete1));
        Assert.assertTrue(team.getStartingName().contains(athlete3));
        Assert.assertFalse(team.getReserveName().contains(athlete3));
        Assert.assertTrue(team.getReserveName().contains(athlete1));
    }

    @Test
    public void testStartingTeamHealthy() {
        // Test when all starting players are healthy
        Assert.assertTrue(team.startingTeamHealthy(team));

        // Test when one of the starting players is injured
        athlete1.setInjuryStatus(true);
        Assert.assertFalse(team.startingTeamHealthy(team));
    }

    @Test
    public void testReserveTeamHealthy() {
        // Test when all reserve players are healthy
        Assert.assertTrue(team.reserveTeamHealthy(team));

        // Test when one of the reserve players is injured
        athlete3.setInjuryStatus(true);
        Assert.assertFalse(team.reserveTeamHealthy(team));
    }

}
