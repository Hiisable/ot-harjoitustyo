
package yahtzee.domain;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Yahtzee-pelissä käytetään viittä noppaa ja tämä luokka
 * toteuttaa viiden nopan yhtäaikaisen hallinnoinnin.
 * 
 */
public class Dice {
    
    private final ArrayList<Die> dice;
    private final Die die1;
    private final Die die2;
    private final Die die3;
    private final Die die4;
    private final Die die5;
    
    /**
     * Konstruktori luo viisi uutta noppaa ja lisää ne uuteen
     * taulukkolistaan.
     * 
     */
    public Dice() {
        die1 = new Die();
        die2 = new Die();
        die3 = new Die();
        die4 = new Die();
        die5 = new Die();
        dice = new ArrayList<>();
        Collections.addAll(dice, die1, die2, die3, die4, die5);
    }
    
    /**
     * Metodi asettaa taulukon nopille uuden satunnaisen silmäluvun.
     * 
     * @see yahtzee.domain.Die#rollDie()
     * 
     */
    public void rollDice() {
        for (Die die: dice) {
            die.rollDie();
        }
    }
    
    /**
     * Metodi asettaa listan jokaiselle nopille halutun arvon.
     * 
     * @param value Haluttu silmäluvun arvo.
     */
    public void setAllDice(int value) {
        for (Die die: dice) {
            die.setValue(value);
        }
    }
    
    /**
     * Metodi asettaa listan tietyn nopan valituksi tai vapauttaa sen.
     * 
     * @param index Halutun nopan sijainti listassa.
     * @see yahtzee.domain.Die#setSelected()
     * 
     */
    public void selectDie(int index) {
        dice.get(index).setSelected();
    }
    
    /**
     * Metodi asettaa listan tietyn nopan arvoksi määritetyn silmäluvun arvon.
     * 
     * @param index Halutun nopan sijainti listalla.
     * @param value Asetettava silmäluvun arvo.
     * 
     */
    public void setValueOfDie(int index, int value) {
        dice.get(index).setValue(value);
    }
    
    /**
     * Metodi palauttaa tietyn nopan silmäluvun arvon.
     * 
     * @param index Halutun nopan sijainti listalla.
     * @return Nopan silmäluvun arvo.
     */
    public int getValueOfDie(int index) {
        int value = dice.get(index).getValue();
        return value;
    }
    
    /**
     * Metodi palauttaa tietyn nopan arvon, jonka perusteella noppa on joko valittu tai ei.
     * 
     * @param index Halutun nopan sijainti listalla.
     * @return Valinnan arvo.
     */
    public boolean getSelectOfDie(int index) {
        boolean selected = dice.get(index).getSelected();
        return selected;
    }
    
    public ArrayList<Die> getDice() {
        return this.dice;
    }
    
}
