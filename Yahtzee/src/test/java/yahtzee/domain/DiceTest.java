
package yahtzee.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DiceTest {
    
    public DiceTest() {
    }
    
    Dice dice;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dice = new Dice();
    }
    
    @Test
    public void rollingWorks() {
        dice.rollDice();
        for (int i = 0; i < 5; i++) {
            assertTrue(dice.getValueOfDie(i) != 0 && dice.getValueOfDie(i) < 7);
        }
    }
    
    @Test
    public void selectingWorks() {
        dice.selectDie(1);
        dice.selectDie(4);
        assertTrue(dice.getSelectOfDie(1));
        assertTrue(dice.getSelectOfDie(4));
        assertFalse(dice.getSelectOfDie(2));
        assertFalse(dice.getSelectOfDie(3));
        assertFalse(dice.getSelectOfDie(0));
    }
    
    @Test
    public void rollingWorksCorrectlyWhenSelected() {
        dice.selectDie(2);
        dice.selectDie(3);
        dice.rollDice();
        assertEquals(0, dice.getValueOfDie(2));
        assertEquals(0, dice.getValueOfDie(3));
        assertTrue(dice.getValueOfDie(1) != 0 && dice.getValueOfDie(1) < 7);
        assertTrue(dice.getValueOfDie(4) != 0 && dice.getValueOfDie(1) < 7);
        assertTrue(dice.getValueOfDie(0) != 0 && dice.getValueOfDie(1) < 7);
    }
    
    @After
    public void tearDown() {
    }

}
