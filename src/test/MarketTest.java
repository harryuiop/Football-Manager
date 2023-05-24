package test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Item;
import main.Market;
import main.Player;
import main.Team;

import static org.junit.jupiter.api.Assertions.*;

public class MarketTest {
    private Market market;

    @BeforeEach
    public void setUp() {
        market = new Market();
        market.createItems();
    }

    @Test
    public void testRotateMarketItems() {
        assertEquals(3, market.getCatalog().size());
        market.rotateMarketItems();
        assertEquals(3, market.getCatalog().size());

        for (int i = 0; i < market.getCatalog().size(); i++) {
            for (int j = i + 1; j < market.getCatalog().size(); j++) {
                assertNotEquals(market.getCatalog().get(i), market.getCatalog().get(j));
            }
        }
    }

    @Test
    public void testInitialMarketItems() {
        assertEquals(3, market.getCatalog().size());
    }

    @Test
    public void testAddItemToUnseenItems() {
        Item newItem = new Item("Test Item", 5, 5, 5, 1, 100);
        market.addItemToUnseenItems(newItem);
        assertTrue(market.getUnseenItems().contains(newItem));
    }

    @Test
    public void testBuyItemAndMoneyUpdater() {
        Player player = new Player();
        Team team = new Team();
        player.setMoneyBalance(200);
        Item item = market.getCatalog().get(0);
        boolean bought = market.BuyItemAndMoneyUpdater(player, item, team);
        assertTrue(bought);
        assertEquals(200 - item.getItemPrice(), player.getMoneyBalance());
        assertTrue(player.getInventory().contains(item));
        assertFalse(market.getCatalog().contains(item));
    }
}
