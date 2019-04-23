
package yahtzee.domain;

import java.util.ArrayList;
/**
 * Luokka kuvaa sovellusta pelaavaa käyttäjää ja sisällyttää 
 * muuuttujiinsa käyttäjän saamat pisteet ja nimen.
 */

public class Player {
    
    private String name;
    private ArrayList<Boolean> scoreTracker;
    private ArrayList<Integer> scoreArray;
    private int turnCount;
    private int rollCount;
    private int totalScore;
    private int upperScore;
    private int bonus;
    private int ones;
    private int twos;
    private int threes;
    private int fours;
    private int fives;
    private int sixes;
    private int smallStraight;
    private int largeStraight;
    private int pair;
    private int threeOfAKind;
    private int twoPairs;
    private int fourOfAKind;
    private int fullHouse;
    private int chance;
    private int yahtzee;
    
    /**
     * Konstruktori, jolla luodaan uusi Player-olio. Konstruktori asettaa uudelle oliolle 
     * oletusarvot ja luo kaksi erillistä listaa pisteiden kirjaamista varten.
     * 
     */
    public Player() {
        totalScore = 0;
        upperScore = 0;
        bonus = 0;
        turnCount = 1;
        rollCount = 0;
        scoreTracker = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Boolean score = false;
            scoreTracker.add(score);
        }
        scoreArray = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            int score = 0;
            scoreArray.add(score);
        }
    }
    
    /**
     * Metodilla lisätään listaan pistekategoria kirjatuksi.
     * 
     * @param index Pistekategoria, joka kirjataan suoritetuksi.
     */
    public void addScoreToCheckArray(int index) {
        this.scoreTracker.set(index, true);
    }
    
    /**
     * Metodi kertoo onko kysytylle pistekategorialle jo merkitty pisteet.
     * 
     * @param index Parametri, jonka perusteella listasta haetaan indeksin arvo.
     * @return Haettu boolean-arvo, joka kertoo onko pistesuoritus kirjattu vai ei.
     */
    public boolean checkIfScored(int index) {
        return this.scoreTracker.get(index);
    }
    
    /**
     * Metodi palauttaa tietyn pistekategorian pistesuorituksen.
     * 
     * @param index Haluttu pistekategoria.
     * @return Haetun pistekategorian pisteet.
     */
    public int getSpecificScore(int index) {
        int score = this.scoreArray.get(index);
        return score;
    }
    
    /**
     * Metodi lisää pistesuorituslistaan paremetrinä kerrottuun
     * kategoriaan pistesuorituksen.
     * 
     * @param index Pistesuorituksen kategoria.
     * @param score Pistesuorituksen pisteet.
     */
    public void addScoreToScoreArray(int index, int score) {
        scoreArray.set(index, score);
    }
    
    /**
     * Metodi lisää pelaajalle pistesuorituksen kokonaisuutena, eli lisää
     * suorituksen pisteet oikeaan kategoriaan ja lisää tarkistuslistaan merkinnän
     * pistesuorituksesta.
     * 
     * @param index Merkityn suorituksen kategoria.
     * @param score Suorituksen pisteet.
     * @param upper Kertoo mikäli pistesuoritus kuuluu yahtzee-pelin yläosion pisteisiin.
     */
    public void addScore(int index, int score, boolean upper) {
        if (!this.checkIfScored(index)) {                   
            this.addScoreToCheckArray(index);
            this.addScoreToScoreArray(index, score);
            if (upper) {
                this.upperScore = upperScore + score;
                if (upperScore >= 63) {
                    this.addBonus();
                }
                this.totalScore = totalScore + score;
            } else {
                this.totalScore = totalScore + score;
            }
        }
    }
    
    /**
     * Metodi asettaa muuttujat niiden aloitusarvoiksi uutta peliä varten.
     */
    public void clearAll() {
        for (int i = 0; i < 15; i++) {
            this.scoreTracker.set(i, false);
        }
        for (int i = 0; i < 15; i++) {
            this.scoreArray.set(i, 0);
        }
        setOnes(0);
        setTwos(0);
        setThrees(0);
        setFours(0);
        setFives(0);
        setSixes(0);
        this.bonus = 0;
        this.upperScore = 0;
        setSmallStraight(0);
        setLargeStraight(0);
        setPair(0);
        setTwoPairs(0);
        setThreeOfAKind(0);
        setFourOfAKind(0);
        setFullHouse(0);
        setChance(0);
        setYahtzee(0);
        this.totalScore = 0;
        this.turnCount = 1;
        this.rollCount = 0;
    }
    
    /**
     * Metodi kasvattaa pelaajan käyttämien vuorojen määrää;
     */
    public void advanceTurnCount() {
        this.turnCount++;
    }
    
    public void setTurnCount(int turn) {
        this.turnCount = turn;
    }
    
    public int getTurnCount() {
        return this.turnCount;
    }
    
    /**
     * Metodi kasvattaa pelaajan nopanheittojen määrää.
     */
    public void advanceRollCount() {
        this.rollCount++;
    }
    
    public void setRollCount(int count) {
        this.rollCount = count;
    }
    
    public int getRollCount() {
        return this.rollCount;
    }
    
    /**
     * Metodi lisää pelaajalle bonuspisteet.
     */
    public void addBonus() {
        this.bonus = 35;
    }
    
    public int getBonus() {
        return this.bonus;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getScore() {
        return totalScore;
    }
    
    public int getUpperScore() {
        return upperScore;
    }
    
    public int getOnes() {
        return ones;
    }
    
    public void setOnes(int score) {
        this.ones = score;
    }
            
    public int getTwos() {
        return twos;
    }
    
    public void setTwos(int score) {
        this.twos = score;
    }
    
    public int getThrees() {
        return threes;
    }
    
    public void setThrees(int score) {
        this.threes = score;
    }
    
    public int getFours() {
        return fours;    
    }
    
    public void setFours(int score) {
        this.fours = score;
    }
    
    public int getFives() {
        return fives;
    }
    
    public void setFives(int score) {
        this.fives = score;
    }
    
    public int getSixes() {
        return sixes;
    }
    
    public void setSixes(int score) {
        this.sixes = score;
    }
    
    public int getPair() {
        return pair;
    }
    
    public void setPair(int score) {
        this.pair = score;
    }
    
    public int getThreeOfAKind() {
        return threeOfAKind;
    }
    
    public void setThreeOfAKind(int score) {
        this.threeOfAKind = score;
    }
    
    public int getTwoPairs() {
        return twoPairs;
    }
    
    public void setTwoPairs(int score) {
        this.twoPairs = score;
    }
    
    public int getFourOfAKind() {
        return fourOfAKind;
    }
    
    public void setFourOfAKind(int score) {
        this.fourOfAKind = score;
    }
    
    public int getFullHouse() {
        return fullHouse;
    }
    
    public void setFullHouse(int score) {
        this.fullHouse = score;
    }
    
    public int getChance() {
        return chance;
    }
    
    public void setChance(int score) {
        this.chance = score;
    }
    
    public int getYahtzee() {
        return yahtzee;
    }
    
    public void setYahtzee(int score) {
        this.yahtzee = score;
    }
    
    public int getSmallStraight() {
        return smallStraight;
    }
    
    public void setSmallStraight(int score) {
        this.smallStraight = score;
    }
    
    public int getLargeStraight() {
        return largeStraight;
    }
    
    public void setLargeStraight(int score) {
        this.largeStraight = score;
    }
    
}
