
package yahtzee.domain;

import java.util.ArrayList;

public class Player {
    
    private String name;
    private ArrayList<Boolean> scoreTracker;
    private ArrayList<Integer> scoreArray;
    private int totalScore;
    private int upperScore;
    private int bonus;
    
    public Player(String name) {
        this.name = name;
        totalScore = 0;
        upperScore = 0;
        bonus = 0;
        scoreTracker = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Boolean score = false;
            scoreTracker.add(score);
        }
        scoreArray = new ArrayList<>(15);
    }
    
    public Boolean addScoreToCheckArray(int index) {
        if (!this.scoreTracker.get(index)) {
            this.scoreTracker.set(index, true);
            return true;
        } else {
            return false;
        }
    }
    
    public void addScoreToScoreArray(int index, int score) {
        if (scoreArray.get(index) != null) {
            scoreArray.set(index, score);
        }
    }
    
    public void addScore(int index, int score, boolean upper) {
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
    
    public void addBonus() {
        this.bonus = 35;
    }
    
    public int getBonus() {
        return this.bonus;
    }
    
    public String getName() {
        return name;
    }
    
    public int getScore() {
        return totalScore;
    }
    
    public int getUpperScore() {
        return upperScore;
    }
            
    
}
