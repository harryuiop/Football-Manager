package test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.GameEnviroment;
import main.Team;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

public class GameEnviromentTest {
    private GameEnviroment game;

    @BeforeEach
    public void setUp() {
        game = new GameEnviroment();
    }

    @Test
    public void ChooseTeamNameValidNameTest() {
        String name = "My Team";
        boolean result = game.chooseTeamName(new Team(), name);
        Assertions.assertTrue(result);
    }

    @Test
    public void ChooseTeamNameInvalidNameTest() {
        String name = "Invalid Name1";
        boolean result = game.chooseTeamName(new Team(), name);
        Assertions.assertFalse(result);
    }
}
