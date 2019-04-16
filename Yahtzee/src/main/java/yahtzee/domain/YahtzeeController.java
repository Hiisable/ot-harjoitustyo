
package yahtzee.domain;

import java.util.ArrayList;

public class YahtzeeController {
    
    public Dice dice;
    private Boolean twoPlayers;
    private Player currentPlayer;
    private Player playerOne;
    private Player playerTwo;
    public ScoreChecker scoreChecker;
    
    public YahtzeeController() {
        dice = new Dice();
        scoreChecker = new ScoreChecker();
        this.twoPlayers = false;
        this.playerOne = new Player();
        this.playerTwo = new Player();
        this.currentPlayer = this.playerOne;
    }
    
    public void addPlayerOne(String name) {
        this.playerOne.setName(name);
    }
    
    public void addPlayerTwo(String name) {
        this.playerTwo.setName(name);
        this.twoPlayers = true;
    }
    
    public String getPlayerOneName() {
        return this.playerOne.getName();
    }
    
    public String getPlayerTwoName() {
        return this.playerTwo.getName();
    }
    
    public Player getPlayerOne() {
        return this.playerOne;
    }
    
    public Player getPlayerTwo() {
        return this.playerTwo;
    }
    
    public Player getCurrentPlayer() {
        if (this.currentPlayer.equals(this.playerOne)) {
            return playerOne;
        } else {
            return this.playerTwo;
        }
    }
    
    public Dice getDice() {
        return this.dice;
    }
    
    public void roll() {
        dice.rollDice();
    }
    
    public void changeTurn() {
        if (twoPlayers && this.currentPlayer.equals(this.playerOne)) {
            this.currentPlayer = this.playerTwo;
        } else {
            this.currentPlayer = this.playerOne;
        } 
    }
    
    public void scoreOnes() {
        int score = this.scoreChecker.checkOnes(dice);
        getCurrentPlayer().addScore(0, score, true);
        this.getCurrentPlayer().setOnes(score);
    }
    
    public void scoreTwos() {
        int score = this.scoreChecker.checkTwos(dice) * 2;
        this.getCurrentPlayer().addScore(1, score, true);
        this.getCurrentPlayer().setTwos(score);
    }
    
    public void scoreThrees() {
        int score = this.scoreChecker.checkThrees(dice) * 3;
        this.getCurrentPlayer().addScore(2, score, true);
        this.getCurrentPlayer().setThrees(score);
    }
    
    public void scoreFours() {
        int score = this.scoreChecker.checkFours(dice) * 4;
        this.getCurrentPlayer().addScore(3, score, true);
        this.getCurrentPlayer().setFours(score);
    }
    
    public void scoreFives() {
        int score = this.scoreChecker.checkFives(dice) * 5;
        this.getCurrentPlayer().addScore(4, score, true);
        this.getCurrentPlayer().setFives(score);
    }
    
    public void scoreSixes() {
        int score = this.scoreChecker.checkSixes(dice) * 6;
        this.getCurrentPlayer().addScore(5, score, true);
        this.getCurrentPlayer().setSixes(score);
    }
    
    public void scoreYahtzee() {
        int score = 0;
        if (this.scoreChecker.checkYahtzee(dice)) {
            score = 50;
        }
        this.getCurrentPlayer().addScore(14, score, false);
        this.getCurrentPlayer().setYahtzee(score);
    }
    
    public void scoreSmallStraight() {
        int score = 0;
        if (this.scoreChecker.checkSmallStraight(dice)) {
            score = 15;
        }
        this.getCurrentPlayer().addScore(6, score, false);
        this.getCurrentPlayer().setSmallStraight(score);
    }
       
    public void scoreLargeStraight() {
        int score = 0;
        if (this.scoreChecker.checkLargeStraight(dice)) {
            score = 20;
        }
        this.getCurrentPlayer().addScore(7, score, false);
        this.getCurrentPlayer().setLargeStraight(score);
    }
    
    public void scoreTwoOfAKind() {
        int score = this.scoreChecker.checkLargestPair(dice);
        this.getCurrentPlayer().addScore(8, score, false);
        this.getCurrentPlayer().setPair(score);
    }
    
    public void scoreTwoPairs() {
        int score = 0;
        if (this.scoreChecker.checkTwoPairs(dice)) {
            int largestPair = this.scoreChecker.checkLargestPair(dice);
            int smallerPair = this.scoreChecker.checkSecondLargestPair(dice);
            score = largestPair + smallerPair;
        }
        this.getCurrentPlayer().addScore(9, score, false);
        this.getCurrentPlayer().setTwoPairs(score);
    }
    
    public void scoreThreeOfAKind() {
        int score = 0;
        if (this.scoreChecker.checkThreeOfAKind(dice)) {
            score = this.scoreChecker.checkThreeOfAKindScore(dice);
        }
        this.getCurrentPlayer().addScore(10, score, false);
        this.getCurrentPlayer().setThreeOfAKind(score);
    }
    
    public void scoreFourOfAKind() {
        int score = 0;
        if (this.scoreChecker.checkFourOfAKind(dice)) {
            score = this.scoreChecker.checkFourOfAKindScore(dice);
        }
        this.getCurrentPlayer().addScore(11, score, false);
        this.getCurrentPlayer().setFourOfAKind(score);
    }
    
    public void scoreFullHouse() {
        int score = 0;
        if (this.scoreChecker.checkFullHouse(dice)) {
            int threeOfAKind = this.scoreChecker.checkThreeOfAKindScore(dice);
            int pair = this.scoreChecker.checkPairForFullHouse(dice);
            score = threeOfAKind + pair;
        }
        this.getCurrentPlayer().addScore(12, score, false);
        this.getCurrentPlayer().setFullHouse(score);
    }
    
    public void scoreChance() {
        int score = 0;
        int ones = this.scoreChecker.checkOnes(dice);
        int twos = this.scoreChecker.checkTwos(dice) * 2;
        int threes = this.scoreChecker.checkThrees(dice) * 3;
        int fours = this.scoreChecker.checkFours(dice) * 4;
        int fives = this.scoreChecker.checkFives(dice) * 5;
        int sixes = this.scoreChecker.checkSixes(dice) * 6;
        score = ones + twos + threes + fours + fives + sixes;
        this.getCurrentPlayer().addScore(13, score, false);
        this.getCurrentPlayer().setChance(score);
    }
            
    
}
