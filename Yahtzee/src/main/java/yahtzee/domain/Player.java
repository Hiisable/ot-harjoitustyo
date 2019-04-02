
package yahtzee.domain;

public class Player {
    
    private String name;
    private int totalScore;
    private int upperScore;
    private int bonus;
    
    public Player(String name) {
        this.name = name;
        totalScore = 0;
        upperScore = 0;
        bonus = 0;
    }
    
    public void addScore(int score, boolean upper) {
        if (upper) {
            this.upperScore = upperScore + score;
            this.totalScore = totalScore + score;
        } else {
            this.totalScore = totalScore + score;
        }
    }
    
    public void addBonus () {
        this.bonus = 35;
    }
    
    public String getName() {
        return name;
    }
    
    public int getScore () {
        return totalScore;
    }
    
    public int getUpperScore () {
        return upperScore;
    }
            
    
}
