
package yahtzee.domain;

import java.util.ArrayList;
import java.util.Collections;

public class Dice {
    
    private final ArrayList<Die> dice;
    private final Die die1;
    private final Die die2;
    private final Die die3;
    private final Die die4;
    private final Die die5;
    
    public Dice() {
        die1 = new Die();
        die2 = new Die();
        die3 = new Die();
        die4 = new Die();
        die5 = new Die();
        dice = new ArrayList<>();
        Collections.addAll(dice, die1, die2, die3, die4, die5);
    }
    
    public void rollDice() {
        for (Die die: dice) {
            die.rollDie();
        }
    }
    
    public void setAllDice(int value) {
        for (Die die: dice) {
            die.setValue(value);
        }
    }
    
    public void selectDie(int index) {
        dice.get(index).setSelected();
    }
    
    public void setValueOfDie(int index, int value) {
        dice.get(index).setValue(value);
    }
    
    public int getValueOfDie(int index) {
        int value = dice.get(index).getValue();
        return value;
    }

    public boolean getSelectOfDie(int index) {
        boolean selected = dice.get(index).getSelected();
        return selected;
    }
    
}
