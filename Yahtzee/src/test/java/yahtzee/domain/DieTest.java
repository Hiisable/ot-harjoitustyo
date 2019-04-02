
package yahtzee.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DieTest {
    
    Die die;
    
    public DieTest() {
    }
    
        @Before
    public void setUp() {
        die = new Die();
    }
    
    
    @Test
    public void rollingGivesRightValue() {
        int value = die.rollDie();
        assertEquals(value, die.getValue());
    }
    
    @Test
    public void selectingWorksWhenSelected() {
        die.setSelected();
        assertTrue(die.getSelected());
    }
    
    @Test
    public void selectingWorksWhenNotSelected() {
        die.setSelected();
        die.setSelected();
        assertFalse(die.getSelected());
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
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
