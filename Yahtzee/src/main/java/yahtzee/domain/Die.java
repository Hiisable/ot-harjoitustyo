
package yahtzee.domain;

import java.util.Random;

/**
 * Luokka toteuttaa sovelluksessa käytettävät nopat.
 * 
 */
public class Die {
    
    final private int sides;
    public int value;
    public boolean selected;
    
    /**
     * Konstruktori, joka luo uuden 6-sivuisen noppaolion.
     * 
     */
    public Die() {
        sides = 6;
        value = 0;
        selected = false;
    }
    
    /**
     * Metodi "heittää noppaa" eli asettaa nopan arvoksi
     * satunnaisen kokonaisluvun väliltä 1-6.
     * 
     */
    public void rollDie() {
        if (!this.selected) {
            Random score = new Random();
            value = score.nextInt(sides) + 1;
        }
    }
    
    /**
     * Metodi asettaa nopan valituksi tai vapauttaa nopan riippuen
     * metodin kutsumishetkellä vallitsevasta arvosta.
     * 
     */
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
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public boolean getSelected() {
        return selected;
    }
    
}