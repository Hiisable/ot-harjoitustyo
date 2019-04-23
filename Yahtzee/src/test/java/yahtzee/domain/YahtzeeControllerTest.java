
package yahtzee.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class YahtzeeControllerTest {
    
    public YahtzeeControllerTest() {
    }
    
    YahtzeeController controller;
    
    @Test
    public void rollingWorks() {
        controller.roll();
        assertEquals(controller.getCurrentPlayer().getRollCount(), 1);
        for(Die die : controller.dice.getDice()) {
            assertTrue(die.getValue() > 0);
        }
        controller.roll();
        controller.roll();
        int die1 = controller.dice.getValueOfDie(0);
        int die2 = controller.dice.getValueOfDie(1);
        int die3 = controller.dice.getValueOfDie(2);
        int die4 = controller.dice.getValueOfDie(3);
        int die5 = controller.dice.getValueOfDie(4);
        controller.roll();
        assertEquals(controller.getCurrentPlayer().getRollCount(), 3);
        assertEquals(die1, controller.dice.getValueOfDie(0));
        assertEquals(die2, controller.dice.getValueOfDie(1));
        assertEquals(die3, controller.dice.getValueOfDie(2));
        assertEquals(die4, controller.dice.getValueOfDie(3));
        assertEquals(die5, controller.dice.getValueOfDie(4));                      
    }
    
    @Test
    public void gameStateCheckWorks() {
        controller.addPlayerOne("Jesus");
        controller.getCurrentPlayer().setTurnCount(15);
        assertTrue(controller.checkGameState());
        controller.newGame();
        assertFalse(controller.checkGameState());
        controller.addPlayerTwo("Satan");
        assertFalse(controller.checkGameState());
        controller.getCurrentPlayer().setTurnCount(14);
        assertFalse(controller.checkGameState());
        controller.changeTurn();
        assertFalse(controller.checkGameState());
        controller.getCurrentPlayer().setTurnCount(15);
        assertTrue(controller.checkGameState());
    }
    
    @Test
    public void scoringOnesWorks() {
        controller.roll();
        controller.scoreOnes();
        int ones = controller.scoreChecker.checkOnes(controller.getDice());
        assertEquals(ones, controller.getCurrentPlayer().getOnes());
        controller.newGame();
        controller.dice.setAllDice(1);
        controller.scoreOnes();
        controller.dice.setValueOfDie(0, 2);
        controller.dice.setValueOfDie(1, 2);
        controller.scoreOnes();
        assertEquals(5, controller.getCurrentPlayer().getOnes());
    }
    
    @Test
    public void scoringTwosWorks() {
        controller.roll();
        controller.scoreTwos();
        int twos = controller.scoreChecker.checkTwos(controller.getDice()) * 2;
        assertEquals(twos, controller.getCurrentPlayer().getTwos());
        controller.newGame();
        controller.dice.setAllDice(2);
        controller.scoreTwos();
        controller.dice.setValueOfDie(0, 1);
        controller.dice.setValueOfDie(1, 1);
        controller.scoreTwos();
        assertEquals(10, controller.getCurrentPlayer().getTwos());
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        controller = new YahtzeeController();
    }
    
    @After
    public void tearDown() {
    }
    
}
