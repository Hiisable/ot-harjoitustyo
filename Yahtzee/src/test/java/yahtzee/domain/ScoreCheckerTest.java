
package yahtzee.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ScoreCheckerTest {
    
    public ScoreCheckerTest() {
    }
    
    ScoreChecker checker;
    Dice dice;
    
    @Test
    public void checkingValuesWorks() {
        dice.setAllDice(1);
        assertEquals(5, checker.checkOnes(dice));
        dice.setAllDice(2);
        assertEquals(5, checker.checkTwos(dice));
        dice.setAllDice(3);
        assertEquals(5, checker.checkThrees(dice));
        dice.setAllDice(4);
        assertEquals(5, checker.checkFours(dice));
        dice.setAllDice(5);
        assertEquals(5, checker.checkFives(dice));
        dice.setAllDice(6);
        assertEquals(5, checker.checkSixes(dice));
        assertEquals(0, checker.checkFives(dice));
    }    
    

    @Test
    public void straightTestsWork() {
        dice.setValueOfDie(0,1);
        dice.setValueOfDie(1,2);
        dice.setValueOfDie(2,3);
        dice.setValueOfDie(3,4);
        dice.setValueOfDie(4,5);
        assertTrue(checker.checkSmallStraight(dice));
        assertFalse(checker.checkLargeStraight(dice));
        dice.setValueOfDie(0,6);
        assertFalse(checker.checkSmallStraight(dice));
        assertTrue(checker.checkLargeStraight(dice));
    }
    
    @Test
    public void threeOfAKindChecksWork() {
        dice.setValueOfDie(0, 6);
        dice.setValueOfDie(1, 6);
        dice.setValueOfDie(2, 6);
        dice.setValueOfDie(3, 3);
        dice.setValueOfDie(4, 3);
        assertTrue(checker.checkThreeOfAKind(dice));
        assertEquals(18, checker.checkThreeOfAKindScore(dice));
        dice.setValueOfDie(0, 4);
        assertFalse(checker.checkThreeOfAKind(dice));
    }
    
    @Test
    public void fourOfAKindChecksWork() {
        dice.setValueOfDie(0, 6);
        dice.setValueOfDie(1, 6);
        dice.setValueOfDie(2, 6);
        dice.setValueOfDie(3, 6);
        dice.setValueOfDie(4, 3);
        assertTrue(checker.checkFourOfAKind(dice));
        assertEquals(24, checker.checkFourOfAKindScore(dice));
        assertEquals(12, checker.checkLargestPair(dice));
        assertEquals(12, checker.checkSecondLargestPair(dice));
        dice.setValueOfDie(0,5);
        assertFalse(checker.checkFourOfAKind(dice));
    }
    
    @Test
    public void fullHouseChecksWork() {
        dice.setValueOfDie(0, 6);
        dice.setValueOfDie(1, 6);
        dice.setValueOfDie(2, 6);
        dice.setValueOfDie(3, 3);
        dice.setValueOfDie(4, 3);
        assertTrue(checker.checkFullHouse(dice));
        assertEquals(6, checker.checkPairForFullHouse(dice));
        dice.setValueOfDie(0, 2);
        assertFalse(checker.checkFullHouse(dice));
    }
    
    @Test
    public void yahtzeeCheckWorks() {
        dice.setAllDice(1);
        assertTrue(checker.checkYahtzee(dice));
        dice.setAllDice(2);
        assertTrue(checker.checkYahtzee(dice));
        dice.setAllDice(3);
        assertTrue(checker.checkYahtzee(dice));
        dice.setAllDice(4);
        assertTrue(checker.checkYahtzee(dice));
        dice.setAllDice(5);
        assertTrue(checker.checkYahtzee(dice));
        dice.setAllDice(5);
        assertTrue(checker.checkYahtzee(dice));
        dice.setValueOfDie(0, 1);
        assertFalse(checker.checkYahtzee(dice));
        
    }
    
    @Test
    public void pairChecksWork() {
        dice.setValueOfDie(0, 6);
        dice.setValueOfDie(1, 6);
        dice.setValueOfDie(2, 5);
        dice.setValueOfDie(3, 5);
        dice.setValueOfDie(4, 3);
        assertEquals(12, checker.checkLargestPair(dice));
        assertEquals(10, checker.checkSecondLargestPair(dice));
        dice.setValueOfDie(1, 3);
        assertEquals(10, checker.checkLargestPair(dice));
        assertEquals(6, checker.checkSecondLargestPair(dice));
        dice.setValueOfDie(2, 3);
        assertEquals(6, checker.checkLargestPair(dice));
        dice.setValueOfDie(0, 2);
        dice.setValueOfDie(1, 3);
        dice.setValueOfDie(2, 4);
        dice.setValueOfDie(3, 1);
        dice.setValueOfDie(4, 1);
        assertEquals(2, checker.checkLargestPair(dice));
        assertEquals(0, checker.checkSecondLargestPair(dice));
        dice.setValueOfDie(4, 2);
        assertEquals(4, checker.checkLargestPair(dice));
        dice.setValueOfDie(3, 4);
        assertEquals(8, checker.checkLargestPair(dice));
        assertEquals(4, checker.checkSecondLargestPair(dice));
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        checker = new ScoreChecker();
        dice = new Dice();
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
