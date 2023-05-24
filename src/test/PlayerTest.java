package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.LOGIC.Athlete;
import main.LOGIC.Item;
import main.LOGIC.Player;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private Player player;
    private Athlete ath;
    private Item item1;
    private Item item2;

    @BeforeEach
    public void setUp() {
        player = new Player();
        ath = new Athlete(10, 40, 1, 1, "John");
        item1 = new Item("Second Teir Boots", 6, 5, 0, 2, 50);
        item2 = new Item("First Teir Boots", 3, 2, 0, 1, 10);
    }

    @Test
    public void testUseItem() {
        player.useItem(ath, item1);
        assertEquals(15, ath.getOffence());
    }

    @Test
    public void testAddItemToInventory() {
        player.addItemToInventory(item1);
        assertEquals(1, player.getInventory().size());
        assertTrue(player.getInventory().contains(item1));
    }

    @Test
    public void testSellItem() {
        player.addItemToInventory(item1);
        player.addItemToInventory(item2);
        player.sellItem(item1, 0);
        assertEquals(1, player.getInventory().size());
        assertFalse(player.getInventory().contains(item1));
        assertEquals(item2.getSellBackPriceprivate(), player.getMoneyBalance());
    }

    @Test
    public void testRemoveItem() {
        player.addItemToInventory(item1);
        player.addItemToInventory(item2);
        player.removeItem(0);
        assertEquals(1, player.getInventory().size());
        assertFalse(player.getInventory().contains(item1));
    }

    @Test
    public void testGetInventory() {
        ArrayList<Item> inventory = new ArrayList<>();
        inventory.add(item1);
        player.setInventory(inventory);
        assertEquals(inventory, player.getInventory());
    }

    @Test
    public void testGetMoneyBalance() {
        player.setMoneyBalance(100);
        assertEquals(100, player.getMoneyBalance());
    }

    @Test
    public void testSetMoneyBalance() {
        player.setMoneyBalance(100);
        assertEquals(100, player.getMoneyBalance());
    }
}
