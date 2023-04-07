package test;
import main.Player;
import main.Item;
import main.Athlete;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class PlayerTests {
	
	@Test
	public void useItemTest () {
		Player testPlayer = new Player();
		
		int defenceIncreaseValue = 10;
		Item testItem = new Item(defenceIncreaseValue, 0, 0);
		
		int initalDefence = 50;
		Athlete testAthlete = new Athlete(initalDefence, 50, 50);
		
		assertEquals(initalDefence, testAthlete.getDefence());
		testPlayer.useItem(testAthlete, testItem);
		assertEquals(initalDefence + defenceIncreaseValue, testAthlete.getDefence());
		
		
	}

}
