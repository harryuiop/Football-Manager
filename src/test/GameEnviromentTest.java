package test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.LOGIC.GameEnviroment;
import main.LOGIC.Team;

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
    public void ChooseValidNameTest() {
        String name = "My Team";
        boolean result = game.chooseTeamName(new Team(), name);
        Assertions.assertTrue(result);
    }

    @Test
    public void ChooseInvalidNameTest() {
        String name = "Invalid Name1";
        boolean result = game.chooseTeamName(new Team(), name);
        Assertions.assertFalse(result);
    }
}
