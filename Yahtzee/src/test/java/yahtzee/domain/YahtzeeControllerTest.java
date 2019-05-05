
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
        controller.getCurrentPlayer().setTurnCount(16);
        assertTrue(controller.checkGameState());
        controller.newGame();
        assertFalse(controller.checkGameState());
        controller.addPlayerTwo("Satan");
        assertFalse(controller.checkGameState());
        controller.getCurrentPlayer().setTurnCount(15);
        assertFalse(controller.checkGameState());
        controller.changeTurn();
        assertFalse(controller.checkGameState());
        controller.getCurrentPlayer().setTurnCount(16);
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
    
    @Test
    public void scoringThreesWorks() {
        controller.roll();
        controller.scoreThrees();
        int threes = controller.scoreChecker.checkThrees(controller.getDice()) * 3;
        assertEquals(threes, controller.getCurrentPlayer().getThrees());
        controller.newGame();
        controller.dice.setAllDice(3);
        controller.dice.setValueOfDie(0, 1);
        controller.scoreThrees();
        controller.dice.setValueOfDie(0, 3);
        controller.scoreThrees();
        assertEquals(12, controller.getCurrentPlayer().getThrees());
    }
    
    @Test
    public void scoringFoursWorks() {
        controller.roll();
        controller.scoreFours();
        int fours = controller.scoreChecker.checkFours(controller.getDice()) * 4;
        assertEquals(fours, controller.getCurrentPlayer().getFours());
        controller.newGame();
        controller.dice.setAllDice(4);
        controller.dice.setValueOfDie(0, 1);
        controller.scoreFours();
        controller.dice.setValueOfDie(0, 4);
        controller.scoreFours();
        assertEquals(16, controller.getCurrentPlayer().getFours());
    }
    
    @Test
    public void scoringFivesWorks() {
        controller.roll();
        controller.scoreFives();
        int fives = controller.scoreChecker.checkFives(controller.getDice()) * 5;
        assertEquals(fives, controller.getCurrentPlayer().getFives());
        controller.newGame();
        controller.dice.setAllDice(5);
        controller.dice.setValueOfDie(1, 4);
        controller.dice.setValueOfDie(4, 3);
        controller.scoreFives();
        controller.dice.setValueOfDie(1, 5);
        controller.scoreFives();
        assertEquals(15, controller.getCurrentPlayer().getFives());
    }
    
    @Test
    public void scoringSixesWorks() {
        controller.roll();
        controller.scoreSixes();
        int sixes = controller.scoreChecker.checkSixes(controller.getDice()) * 6;
        assertEquals(sixes, controller.getCurrentPlayer().getSixes());
        controller.newGame();
        controller.dice.setAllDice(6);
        controller.dice.setValueOfDie(1, 1);
        controller.dice.setValueOfDie(4, 5);
        controller.scoreSixes();
        controller.dice.setValueOfDie(1, 6);
        controller.scoreSixes();
        assertEquals(18, controller.getCurrentPlayer().getSixes());
    }
    
    @Test
    public void scoringSmallStraightWorks() {
        controller.dice.setValueOfDie(0, 1);
        controller.dice.setValueOfDie(1, 2);
        controller.dice.setValueOfDie(2, 3);
        controller.dice.setValueOfDie(3, 4);
        controller.dice.setValueOfDie(4, 5);
        controller.scoreSmallStraight();
        assertTrue(controller.checkScoreStatus(6));
        assertEquals(15, controller.getCurrentPlayer().getSmallStraight());
        controller.newGame();
        assertFalse(controller.checkScoreStatus(6));
        controller.dice.setAllDice(6);
        controller.scoreSmallStraight();
        assertTrue(controller.checkScoreStatus(6));
        assertEquals(0, controller.getCurrentPlayer().getSmallStraight());
    }
    
    @Test
    public void scoringLargeStraightWorks() {
        controller.dice.setValueOfDie(0, 2);
        controller.dice.setValueOfDie(1, 3);
        controller.dice.setValueOfDie(2, 4);
        controller.dice.setValueOfDie(3, 5);
        controller.dice.setValueOfDie(4, 6);
        controller.scoreLargeStraight();
        assertTrue(controller.checkScoreStatus(7));
        assertEquals(20, controller.getCurrentPlayer().getLargeStraight());
        controller.newGame();
        assertFalse(controller.checkScoreStatus(7));
        controller.dice.setAllDice(6);
        controller.scoreLargeStraight();
        assertTrue(controller.checkScoreStatus(7));
        assertEquals(0, controller.getCurrentPlayer().getLargeStraight());
    }
    
    @Test
    public void scoringPairWorks() {
        controller.dice.setAllDice(1);
        controller.dice.setValueOfDie(0, 4);
        controller.dice.setValueOfDie(1, 4);
        controller.dice.setValueOfDie(2, 6);
        controller.dice.setValueOfDie(3, 6);
        controller.scoreTwoOfAKind();
        assertTrue(controller.checkScoreStatus(8));
        assertEquals(12, controller.getCurrentPlayer().getPair());
        controller.newGame();
        assertFalse(controller.checkScoreStatus(8));
        controller.dice.setAllDice(1);
        controller.dice.setValueOfDie(0, 4);
        controller.dice.setValueOfDie(1, 4);
        controller.scoreTwoOfAKind();
        assertTrue(controller.checkScoreStatus(8));
        controller.dice.setValueOfDie(2, 6);
        controller.dice.setValueOfDie(3, 6);
        controller.scoreTwoOfAKind();
        assertTrue(controller.checkScoreStatus(8));
        assertEquals(8, controller.getCurrentPlayer().getPair());      
    }
    
    @Test
    public void scoringTwoPairsWorks() {
        controller.dice.setValueOfDie(0, 4);
        controller.dice.setValueOfDie(1, 4);
        controller.dice.setValueOfDie(2, 6);
        controller.dice.setValueOfDie(3, 6);
        controller.dice.setValueOfDie(4, 5);
        controller.scoreTwoPairs();
        assertTrue(controller.checkScoreStatus(9));
        assertEquals(20, controller.getCurrentPlayer().getTwoPairs());
        controller.dice.setValueOfDie(1, 5);
        controller.scoreTwoPairs();
        assertEquals(20, controller.getCurrentPlayer().getTwoPairs());
        controller.newGame();
        assertFalse(controller.checkScoreStatus(9));
        controller.dice.setValueOfDie(0, 4);
        controller.dice.setValueOfDie(1, 4);
        controller.dice.setValueOfDie(2, 4);
        controller.dice.setValueOfDie(3, 6);
        controller.dice.setValueOfDie(4, 5);
        controller.scoreTwoPairs();
        assertTrue(controller.checkScoreStatus(9));
        assertEquals(0, controller.getCurrentPlayer().getTwoPairs());
    }
    
    @Test
    public void scoringThreeOfAKindWorks() {
        controller.dice.setValueOfDie(0, 4);
        controller.dice.setValueOfDie(1, 5);
        controller.dice.setValueOfDie(2, 5);
        controller.dice.setValueOfDie(3, 5);
        controller.dice.setValueOfDie(4, 6);
        controller.scoreThreeOfAKind();
        assertTrue(controller.checkScoreStatus(10));
        assertEquals(15, controller.getCurrentPlayer().getThreeOfAKind());
        controller.dice.setValueOfDie(0, 6);
        controller.dice.setValueOfDie(1, 6);
        controller.scoreThreeOfAKind();
        assertTrue(controller.checkScoreStatus(10));
        assertEquals(15, controller.getCurrentPlayer().getThreeOfAKind());
        controller.newGame();
        assertFalse(controller.checkScoreStatus(10));
        controller.dice.setValueOfDie(0, 4);
        controller.dice.setValueOfDie(1, 4);
        controller.dice.setValueOfDie(2, 5);
        controller.dice.setValueOfDie(3, 6);
        controller.dice.setValueOfDie(4, 5);
        controller.scoreThreeOfAKind();
        assertTrue(controller.checkScoreStatus(10));
        assertEquals(0, controller.getCurrentPlayer().getThreeOfAKind());
    }
    
    @Test
    public void scoringFourOfAKindWorks() {
        controller.dice.setAllDice(4);
        controller.scoreFourOfAKind();
        assertTrue(controller.checkScoreStatus(11));
        assertEquals(16, controller.getCurrentPlayer().getFourOfAKind());
        controller.dice.setAllDice(6);
        controller.scoreFourOfAKind();
        assertEquals(16, controller.getCurrentPlayer().getFourOfAKind());
        controller.newGame();
        assertFalse(controller.checkScoreStatus(11));
        controller.dice.setAllDice(4);
        controller.dice.setValueOfDie(0, 6);
        controller.dice.setValueOfDie(1, 6);
        controller.scoreFourOfAKind();
        assertTrue(controller.checkScoreStatus(11));
        assertEquals(0, controller.getCurrentPlayer().getFourOfAKind());
    }
    
    @Test
    public void scoringFullHouseWorks() {
        controller.dice.setAllDice(4);
        controller.dice.setValueOfDie(0, 5);
        controller.dice.setValueOfDie(1, 5);
        controller.scoreFullHouse();
        assertTrue(controller.checkScoreStatus(12));
        assertEquals(22, controller.getCurrentPlayer().getFullHouse());
        controller.dice.setValueOfDie(2, 5);
        controller.scoreFullHouse();
        assertEquals(22, controller.getCurrentPlayer().getFullHouse());
        controller.newGame();
        assertFalse(controller.checkScoreStatus(12));
        controller.dice.setAllDice(4);
        controller.dice.setValueOfDie(0, 5);
        controller.scoreFullHouse();
        assertTrue(controller.checkScoreStatus(12));
        assertEquals(0, controller.getCurrentPlayer().getFullHouse());
    }
    
    @Test
    public void scoringChanceWorks() {
        controller.dice.setValueOfDie(0, 5);
        controller.dice.setValueOfDie(1, 3);
        controller.dice.setValueOfDie(2, 4);
        controller.dice.setValueOfDie(3, 5);
        controller.dice.setValueOfDie(4, 6);
        controller.scoreChance();
        assertTrue(controller.checkScoreStatus(13));
        assertEquals(23, controller.getCurrentPlayer().getChance());
        controller.dice.setAllDice(6);
        controller.scoreChance();
        assertEquals(23, controller.getCurrentPlayer().getChance());     
    }
    
    @Test
    public void scoringYahtzeeWorks() {
        for(int i = 1; i <= 6; i++) {
            controller.newGame();
            controller.dice.setAllDice(i);
            controller.scoreYahtzee();
            assertTrue(controller.checkScoreStatus(14));
            assertEquals(50, controller.getCurrentPlayer().getYahtzee());
        }
        controller.newGame();
        assertFalse(controller.checkScoreStatus(14));
        controller.dice.setAllDice(1);
        controller.dice.setValueOfDie(0, 2);
        controller.scoreYahtzee();
        assertEquals(0, controller.getCurrentPlayer().getYahtzee());
    }
    
    @Test
    public void declaringWinnerWorks() {
        controller.addPlayerOne("Saatana");
        controller.addPlayerTwo("Jeesus");
        assertEquals("Saatana", controller.getPlayerOneName());
        assertEquals("Jeesus", controller.getPlayerTwoName());
        controller.dice.setAllDice(1);
        controller.scoreYahtzee();
        controller.changeTurn();
        controller.dice.setAllDice(6);
        controller.dice.setValueOfDie(0, 1);
        controller.dice.setValueOfDie(1, 1);
        controller.scoreThreeOfAKind();
        assertEquals(controller.getPlayerOne(), controller.getWinner());
        controller.newGame();
        controller.addPlayerOne("Saatana");
        controller.addPlayerTwo("Cthulhu");
        assertEquals("Saatana", controller.getPlayerOneName());
        assertEquals("Cthulhu", controller.getPlayerTwoName());
        controller.dice.setAllDice(6);
        controller.dice.setValueOfDie(0, 1);
        controller.dice.setValueOfDie(1, 1);
        controller.scoreThreeOfAKind();
        controller.changeTurn();
        controller.dice.setAllDice(6);
        controller.scoreChance();
        assertEquals(controller.getPlayerTwo(), controller.getWinner());
        controller.newGame();
        assertEquals(null, controller.getWinner());
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
