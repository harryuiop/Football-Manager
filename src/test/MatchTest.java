package test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.GameEnviroment;
import main.Match;
import main.Athlete;

import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {
    private Match match;
    private GameEnviroment game;

    @BeforeEach
    public void setUp() {
        match = new Match();
        game = new GameEnviroment();
    }

    @Test
    public void testMatchUpPlayerWins() {
        Athlete playerAthlete = new Athlete(70, 30, 1, 1, "Ben");
        Athlete opponentAthlete = new Athlete(70, 30, 1, 1, "Liam");

        String result = match.matchUp(game, null, null, playerAthlete, opponentAthlete, "player");

        assertEquals("Won", result);
        assertEquals(1, match.getPlayersScore());
        assertEquals(0, match.getOpposingScore());
        assertEquals(100, playerAthlete.getStamina());
    }


	@Test
	public void testMatchUpOpponentWins() {
	    Athlete playerAthlete = new Athlete(990, 990, 1, 1, "Leon");
	    Athlete opponentAthlete = new Athlete(70, 30, 1, 1, "James");
	
	    String result = match.matchUp(game, null, null, playerAthlete, opponentAthlete, "player");
	
	    assertEquals("Lost", result);
	    assertEquals(0, match.getPlayersScore());
	    assertEquals(1, match.getOpposingScore());
	    assertEquals(90, playerAthlete.getStamina());
	}

    @Test
    public void testMatchUpDraw() {
        Athlete playerAthlete = new Athlete(70, 30, 1, 1, "Callum");
        Athlete opponentAthlete = new Athlete(70, 30, 1, 1, "Callum");

        String result = match.matchUp(game, null, null, playerAthlete, opponentAthlete, "player");

        assertEquals("Draw", result);
        assertEquals(0, match.getPlayersScore());
        assertEquals(0, match.getOpposingScore());
        assertEquals(100, playerAthlete.getStamina());
    }

    @Test
    public void testWinnerStringPlayerWins() {
        match.setPlayersScore(2);
        match.setOpposingScore(1);

        String result = match.winnerString();

        assertEquals("You Win: 2-1", result);
    }

    @Test
    public void testWinnerStringOpponentWins() {
        match.setPlayersScore(1);
        match.setOpposingScore(3);

        String result = match.winnerString();

        assertEquals("You Lose: 1-3", result);
    }

    @Test
    public void testWinnerStringDraw() {
        match.setPlayersScore(2);
        match.setOpposingScore(2);

        String result = match.winnerString();

        assertEquals("Draw: 2-2", result);
    }
}
