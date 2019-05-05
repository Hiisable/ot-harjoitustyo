
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
        dice.setValueOfDie(0, 1);
        dice.setValueOfDie(1, 2);
        dice.setValueOfDie(2, 3);
        dice.setValueOfDie(3, 4);
        dice.setValueOfDie(4, 5);
        assertTrue(checker.checkSmallStraight(dice));
        assertFalse(checker.checkLargeStraight(dice));
        dice.setValueOfDie(0, 6);
        assertFalse(checker.checkSmallStraight(dice));
        assertTrue(checker.checkLargeStraight(dice));
        dice.setValueOfDie(0, 5);
        assertFalse(checker.checkLargeStraight(dice));
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
        dice.setAllDice(1);
        assertTrue(checker.checkThreeOfAKind(dice));
        assertEquals(3, checker.checkThreeOfAKindScore(dice));
        dice.setAllDice(2);
        dice.setValueOfDie(0, 3);
        assertTrue(checker.checkThreeOfAKind(dice));
        assertEquals(6, checker.checkThreeOfAKindScore(dice));
        dice.setValueOfDie(1, 3);
        dice.setValueOfDie(2, 3);
        assertEquals(9, checker.checkThreeOfAKindScore(dice));
        dice.setValueOfDie(3, 3);
        assertEquals(9, checker.checkThreeOfAKindScore(dice));
        dice.setAllDice(4);
        dice.setValueOfDie(0, 5);
        dice.setValueOfDie(1, 6);
        assertTrue(checker.checkThreeOfAKind(dice));
        assertEquals(12, checker.checkThreeOfAKindScore(dice));
        dice.setValueOfDie(3, 5);
        dice.setValueOfDie(4, 5);
        assertTrue(checker.checkThreeOfAKind(dice));
        assertEquals(15, checker.checkThreeOfAKindScore(dice));
        dice.setValueOfDie(3, 1);
        assertFalse(checker.checkThreeOfAKind(dice));
        assertEquals(0, checker.checkThreeOfAKindScore(dice));
        
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
        dice.setAllDice(4);
        assertEquals(16, checker.checkFourOfAKindScore(dice));
        dice.setAllDice(3);
        assertEquals(12, checker.checkFourOfAKindScore(dice));
        dice.setAllDice(2);
        assertEquals(8, checker.checkFourOfAKindScore(dice));
        dice.setAllDice(1);
        assertEquals(4, checker.checkFourOfAKindScore(dice));
        dice.setValueOfDie(0, 6);
        dice.setValueOfDie(1, 6);
        assertFalse(checker.checkFourOfAKind(dice));
        dice.setAllDice(5);
        dice.setValueOfDie(0, 6);
        assertEquals(20, checker.checkFourOfAKindScore(dice));       
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
        dice.setValueOfDie(0, 3);
        assertTrue(checker.checkFullHouse(dice));
        assertEquals(12, checker.checkPairForFullHouse(dice));
        dice.setValueOfDie(1, 5);
        dice.setValueOfDie(2, 5);
        assertEquals(10, checker.checkPairForFullHouse(dice));
        dice.setValueOfDie(1, 2);
        dice.setValueOfDie(0, 4);
        dice.setValueOfDie(3, 4);
        assertEquals(8, checker.checkPairForFullHouse(dice));
        assertFalse(checker.checkFullHouse(dice));
        dice.setValueOfDie(0, 2);
        assertEquals(4, checker.checkPairForFullHouse(dice));
        dice.setAllDice(6);
        dice.setValueOfDie(0, 1);
        dice.setValueOfDie(1, 1);
        assertEquals(2, checker.checkPairForFullHouse(dice));
    }
    
    @Test
    public void checkPairWorks() {
        dice.setAllDice(1);
        assertTrue(checker.checkPair(dice));
        dice.setValueOfDie(0, 2);
        dice.setValueOfDie(1, 2);
        dice.setValueOfDie(2, 2);
        dice.setValueOfDie(3, 3);
        assertTrue(checker.checkPair(dice));
        dice.setValueOfDie(0, 4);
        dice.setValueOfDie(1, 5);
        assertFalse(checker.checkPair(dice));
        dice.setValueOfDie(0, 5);
        assertTrue(checker.checkPair(dice));
        dice.setAllDice(6);
        assertTrue(checker.checkPair(dice)); 
        dice.setAllDice(4);
        assertTrue(checker.checkPair(dice)); 
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
    
    @Test
    public void checkingTwoPairsWorks() {
        for (int i = 1; i <= 6; i++) {
            dice.setAllDice(i);
            assertTrue(checker.checkTwoPairs(dice));
            if (i < 6) {
                dice.setValueOfDie(0, i + 1);
                dice.setValueOfDie(1, i + 1);
                assertTrue(checker.checkTwoPairs(dice));
                if (i < 5) {
                    dice.setValueOfDie(0, i + 2);
                    assertFalse(checker.checkTwoPairs(dice));
                    dice.setValueOfDie(1, i + 2);
                    assertTrue(checker.checkTwoPairs(dice));
                } if (i < 4) {
                    dice.setValueOfDie(0, i + 3);
                    dice.setValueOfDie(1, i + 3);
                    assertTrue(checker.checkTwoPairs(dice));
                } if (i < 3)  {
                    dice.setValueOfDie(0, i + 4);
                    dice.setValueOfDie(1, i + 4);
                    assertTrue(checker.checkTwoPairs(dice));
                } if (i < 2) {
                    dice.setValueOfDie(0, i + 5);
                    dice.setValueOfDie(1, i + 5);
                    assertTrue(checker.checkTwoPairs(dice));
                }         
            }
        }
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
