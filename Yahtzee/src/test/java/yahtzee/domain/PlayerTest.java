
package yahtzee.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PlayerTest {
    
    public PlayerTest() {
    }
    
    Player player;
    
    
    @Test
    public void addingScoreWorks() {
        player.addScore(1, 10, true);
        player.setTwos(10);
        assertEquals(player.getSpecificScore(1), player.getTwos());
        assertTrue(player.checkIfScored(1));
    }
    
    @Test
    public void addingBonusWorks() {
        player.setOnes(5);
        player.setTwos(8);
        player.setSixes(24);
        player.setFives(20);
        player.setFours(16);
        player.addScore(0, 5, true);
        player.addScore (1, 8, true);
        player.addScore(5, 24, true);
        player.addScore(4, 20, true);
        player.addScore(3, 16, true);
        assertEquals(player.getSpecificScore(0), player.getOnes());
        assertEquals(player.getSpecificScore(1), player.getTwos());
        assertEquals(player.getSpecificScore(5), player.getSixes());
        assertEquals(player.getSpecificScore(4), player.getFives());
        assertEquals(player.getSpecificScore(3), player.getFours());
        assertEquals(35, player.getBonus());
        assertEquals(73, player.getUpperScore());
        assertEquals(player.getScore(), player.getUpperScore());
    }
    
    @Test
    public void cantScoreMultipleTimes() {
        assertFalse(player.checkIfScored(5));
        player.addScore(5, 18, true);
        player.addScore(5, 24, true);
        assertEquals(18, player.getSpecificScore(5));
        assertTrue(player.checkIfScored(5));
    }
    
    @Test
    public void upperScoreAndTotalScoreAreSeparated() {
        player.addScore(4, 25, true);
        assertEquals(player.getScore(), player.getUpperScore());
        player.addScore(14, 50, false);
        assertEquals(player.getScore(), 75);
        assertEquals(player.getUpperScore(), 25);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        player = new Player();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
