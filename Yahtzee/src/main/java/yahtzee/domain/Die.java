
package yahtzee.domain;

import java.util.Random;


public class Die {
    
    final private int sides;
    public int value;
    public boolean selected;
    
    
    public Die() {
        sides = 6;
        value = 0;
        selected = false;
    }
    
    public void rollDie() {
        if (!this.selected) {
            Random score = new Random();
            value = score.nextInt(sides) + 1;
        }
    }
    
    public void setSelected() {
        if (!selected) {
            this.selected = true;
        } else {
            this.selected = false;
        }
    }

    public int getValue() {
        return value;
    }
    
    public boolean getSelected() {
        return selected;
    }
    
}