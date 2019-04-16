
package yahtzee.domain;

import java.util.ArrayList;

public class Player {
    
    private String name;
    private ArrayList<Boolean> scoreTracker;
    private ArrayList<Integer> scoreArray;
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
    
    
    public Player() {
        totalScore = 0;
        upperScore = 0;
        bonus = 0;
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
    
    public void addScoreToCheckArray(int index) {
        this.scoreTracker.set(index, true);
    }
    
    public Boolean checkIfScored(int index) {
        return this.scoreTracker.get(index);
    }
    
    public int getSpecificScore(int index) {
        int score = this.scoreArray.get(index);
        return score;
    }
    
    public void addScoreToScoreArray(int index, int score) {
        scoreArray.set(index, score);
    }
    
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
    
    public void addBonus() {
        this.bonus = 35;
    }
    
    public int getBonus() {
        return this.bonus;
    }
    
    public String getName() {
        return name;
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
