
package yahtzee.domain;

/**
 * Luokka sisältää metodit varsinaisen yahtzee-pelin tapahtumien toteuttamiseen.
 */
public class YahtzeeController {
    
    public Dice dice;
    private Boolean twoPlayers;
    private Player currentPlayer;
    private Player playerOne;
    private Player playerTwo;
    public ScoreChecker scoreChecker;
    
    /**
     * Konstruktori luo uuden viisi noppaa sisältävän Dice-olion sekä pelaajille
     * omat olionsa ja pistesuorituksien tarkistamiseen käytettävän olion. 
     * Oletusasetuksena konstruktori asettaa pelimoodiksi yhden pelaajan
     * pelin ja aktiiviseksi pelaajaksi ensimmäisen pelaajan.
     */
    public YahtzeeController() {
        dice = new Dice();
        scoreChecker = new ScoreChecker();
        this.twoPlayers = false;
        this.playerOne = new Player();
        this.playerTwo = new Player();
        this.currentPlayer = this.playerOne;
    }
    
    /**
     * Metodi asettaa konstruktorissa luodulle playerOne-oliolle nimen.
     * 
     * @param name Oliolle asetettava nimi.
     */
    public void addPlayerOne(String name) {
        this.playerOne.setName(name);
    }
    
    /**
     * Metodi asettaa konstruktorissa luodulle playerTwo-oliolle nimen ja
     * aktivoi kahden pelaajan pelin.
     * 
     * @param name Oliolle asetettava nimi.
     */
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
    
    /**
     * Metodi palauttaa pelaaja-olion, jonka vuoro on käynnissä.
     * 
     * @return Aktiivinen pelaaja.
     */
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
    
    /**
     * Metodilla heitetään pelin noppia.
     * 
     * @see yahtzee.domain.Dice#rollDice()
     */
    public void roll() {
        if (this.currentPlayer.getRollCount() < 3) {
            dice.rollDice();
            this.currentPlayer.advanceRollCount();
        }
    }
    
    /**
     * Metodi asettaa aktiiviseksi pelaajaksi pelaajan, joka metodin
     * kutsumishetkellä ei ole aktiivinen.
     */
    public void changeTurn() {
        this.currentPlayer.advanceTurnCount();
        if (twoPlayers && this.currentPlayer.equals(this.playerOne)) {
            this.currentPlayer = this.playerTwo;
        } else {
            this.currentPlayer = this.playerOne;
        }
        this.currentPlayer.setRollCount(0);
    }
    
    /**
     * Metodi tarkistaa pelaajien käyttävien vuorojen määrän ja palauttaa
     * true mikäli maksimimäärä vuoroja on käytetty.
     * 
     * @return Pelin jatkumisen ehto.
     */
    public boolean checkGameState() {
        boolean gameOver = false;
        if (twoPlayers && this.playerTwo.getTurnCount() == 15 && this.playerOne.getTurnCount() == 15) {
            gameOver = true;
        } else if (!twoPlayers && this.playerOne.getTurnCount() == 15) {
            gameOver = true;
        }
        return gameOver;
    }
    
    public void newGame() {
        this.playerOne.clearAll();
        this.playerTwo.clearAll();
    }
    
    /**
     * Metodi asettaa aktiiviselle pelaajalle pistesuorituksen 
     * kategorialle: ykköset.
     * 
     * @see yahtzee.domain.Player#addScore(int, int, boolean)
     * @see yahtzee.domain.ScoreChecker#checkOnes(yahtzee.domain.Dice) 
     */
    public void scoreOnes() {
        int score = this.scoreChecker.checkOnes(dice);
        if (!this.getCurrentPlayer().checkIfScored(0)) {
            this.getCurrentPlayer().setOnes(score);
        }
        this.getCurrentPlayer().addScore(0, score, true);
    }
    
    /**
     * Metodi asettaa aktiiviselle pelaajalle pistesuorituksen 
     * kategorialle: kakkoset.
     * 
     * @see yahtzee.domain.Player#addScore(int, int, boolean)
     * @see yahtzee.domain.ScoreChecker#checkTwos(yahtzee.domain.Dice) 
     */
    public void scoreTwos() {
        int score = this.scoreChecker.checkTwos(dice) * 2;
        if (!this.getCurrentPlayer().checkIfScored(1)) {
            this.getCurrentPlayer().setTwos(score); 
        }
        this.getCurrentPlayer().addScore(1, score, true);
    }
    
    /**
     * Metodi asettaa aktiiviselle pelaajalle pistesuorituksen 
     * kategorialle: kolmoset.
     * 
     * @see yahtzee.domain.Player#addScore(int, int, boolean)
     * @see yahtzee.domain.ScoreChecker#checkThrees(yahtzee.domain.Dice) 
     */
    public void scoreThrees() {
        int score = this.scoreChecker.checkThrees(dice) * 3;
        if (!this.getCurrentPlayer().checkIfScored(2)) {
            this.getCurrentPlayer().setThrees(score);
        }
        this.getCurrentPlayer().addScore(2, score, true);
    }
    
    /**
     * Metodi asettaa aktiiviselle pelaajalle pistesuorituksen 
     * kategorialle: neloset.
     * 
     * @see yahtzee.domain.Player#addScore(int, int, boolean)
     * @see yahtzee.domain.ScoreChecker#checkFours(yahtzee.domain.Dice) 
     */
    public void scoreFours() {
        int score = this.scoreChecker.checkFours(dice) * 4;
        if (!this.getCurrentPlayer().checkIfScored(3)) {
            this.getCurrentPlayer().setFours(score);
        }
        this.getCurrentPlayer().addScore(3, score, true);
    }
    
    /**
     * Metodi asettaa aktiiviselle pelaajalle pistesuorituksen 
     * kategorialle: viitoset.
     * 
     * @see yahtzee.domain.Player#addScore(int, int, boolean)
     * @see yahtzee.domain.ScoreChecker#checkFives(yahtzee.domain.Dice) 
     */
    public void scoreFives() {
        int score = this.scoreChecker.checkFives(dice) * 5;
        if (!this.getCurrentPlayer().checkIfScored(4)) {
            this.getCurrentPlayer().setFives(score);
        }
        this.getCurrentPlayer().addScore(4, score, true);
    }
    
    /**
     * Metodi asettaa aktiiviselle pelaajalle pistesuorituksen 
     * kategorialle: kuutoset.
     * 
     * @see yahtzee.domain.Player#addScore(int, int, boolean)
     * @see yahtzee.domain.ScoreChecker#checkSixes(yahtzee.domain.Dice) 
     */
    public void scoreSixes() {
        int score = this.scoreChecker.checkSixes(dice) * 6;
        if (!this.getCurrentPlayer().checkIfScored(5)) {
            this.getCurrentPlayer().setSixes(score);
        }
        this.getCurrentPlayer().addScore(5, score, true);
    }
    
    /**
     * Metodi asettaa aktiiviselle pelaajalle pistesuorituksen 
     * kategorialle: yahtzee.
     * 
     * @see yahtzee.domain.Player#addScore(int, int, boolean)
     * @see yahtzee.domain.ScoreChecker#checkYahtzee(yahtzee.domain.Dice) 
     */
    public void scoreYahtzee() {
        int score = 0;
        if (this.scoreChecker.checkYahtzee(dice)) {
            score = 50;
        }
        if (!this.getCurrentPlayer().checkIfScored(14)) {
            this.getCurrentPlayer().setYahtzee(score);
        }
        this.getCurrentPlayer().addScore(14, score, false);
    }
    
    /**
     * Metodi asettaa aktiiviselle pelaajalle pistesuorituksen 
     * kategorialle: pieni suora.
     * 
     * @see yahtzee.domain.Player#addScore(int, int, boolean)
     * @see yahtzee.domain.ScoreChecker#checkSmallStraight(yahtzee.domain.Dice) 
     */
    public void scoreSmallStraight() {
        int score = 0;
        if (this.scoreChecker.checkSmallStraight(dice)) {
            score = 15;
        }
        if (!this.getCurrentPlayer().checkIfScored(6)) {
            this.getCurrentPlayer().setSmallStraight(score);
        }
        this.getCurrentPlayer().addScore(6, score, false);
    }
    
    /**
     * Metodi asettaa aktiiviselle pelaajalle pistesuorituksen 
     * kategorialle: suuri suora.
     * 
     * @see yahtzee.domain.Player#addScore(int, int, boolean)
     * @see yahtzee.domain.ScoreChecker#checkLargeStraight(yahtzee.domain.Dice) 
     */
    public void scoreLargeStraight() {
        int score = 0;
        if (this.scoreChecker.checkLargeStraight(dice)) {
            score = 20;
        }
        if (!this.getCurrentPlayer().checkIfScored(7)) {
            this.getCurrentPlayer().setLargeStraight(score);
        }
        this.getCurrentPlayer().addScore(7, score, false);
    }
    
    /**
     * Metodi asettaa aktiiviselle pelaajalle pistesuorituksen 
     * kategorialle: pari.
     * 
     * @see yahtzee.domain.Player#addScore(int, int, boolean)
     * @see yahtzee.domain.ScoreChecker#checkLargestPair(yahtzee.domain.Dice) 
     */
    public void scoreTwoOfAKind() {
        int score = this.scoreChecker.checkLargestPair(dice);
        if (!this.getCurrentPlayer().checkIfScored(8)) {
            this.getCurrentPlayer().setPair(score);
        }
        this.getCurrentPlayer().addScore(8, score, false);
    }
    
    /**
     * Metodi asettaa aktiiviselle pelaajalle pistesuorituksen 
     * kategorialle: kaksi paria.
     * 
     * @see yahtzee.domain.Player#addScore(int, int, boolean)
     * @see yahtzee.domain.ScoreChecker#checkLargestPair(yahtzee.domain.Dice) 
     * @see yahtzee.domain.ScoreChecker#checkSecondLargestPair(yahtzee.domain.Dice) 
     */
    public void scoreTwoPairs() {
        int score = 0;
        if (this.scoreChecker.checkTwoPairs(dice)) {
            int largestPair = this.scoreChecker.checkLargestPair(dice);
            int smallerPair = this.scoreChecker.checkSecondLargestPair(dice);
            score = largestPair + smallerPair;
        }
        if (!this.getCurrentPlayer().checkIfScored(9)) {
            this.getCurrentPlayer().setTwoPairs(score);
        }
        this.getCurrentPlayer().addScore(9, score, false);        
    }
    
    /**
     * Metodi asettaa aktiiviselle pelaajalle pistesuorituksen 
     * kategorialle: kolme samaa.
     * 
     * @see yahtzee.domain.Player#addScore(int, int, boolean)
     * @see yahtzee.domain.ScoreChecker#checkThreeOfAKindScore(yahtzee.domain.Dice) 
     */
    public void scoreThreeOfAKind() {
        int score = 0;
        if (this.scoreChecker.checkThreeOfAKind(dice)) {
            score = this.scoreChecker.checkThreeOfAKindScore(dice);
        }
        if (!this.getCurrentPlayer().checkIfScored(10)) {
            this.getCurrentPlayer().setThreeOfAKind(score);
        }
        this.getCurrentPlayer().addScore(10, score, false);
    }
    
    /**
     * Metodi asettaa aktiiviselle pelaajalle pistesuorituksen 
     * kategorialle: neljä samaa.
     * 
     * @see yahtzee.domain.Player#addScore(int, int, boolean)
     * @see yahtzee.domain.ScoreChecker#checkFourOfAKind(yahtzee.domain.Dice) 
     * @see yahtzee.domain.ScoreChecker#checkFourOfAKindScore(yahtzee.domain.Dice) 
     */
    public void scoreFourOfAKind() {
        int score = 0;
        if (this.scoreChecker.checkFourOfAKind(dice)) {
            score = this.scoreChecker.checkFourOfAKindScore(dice);
        }
        if (!this.getCurrentPlayer().checkIfScored(11)) {
            this.getCurrentPlayer().setFourOfAKind(score);
        }
        this.getCurrentPlayer().addScore(11, score, false);
    }
    
    /**
     * Metodi asettaa aktiiviselle pelaajalle pistesuorituksen 
     * kategorialle: täyskäsi.
     * 
     * @see yahtzee.domain.Player#addScore(int, int, boolean)
     * @see yahtzee.domain.ScoreChecker#checkFullHouse(yahtzee.domain.Dice)
     * @see yahtzee.domain.ScoreChecker#checkThreeOfAKindScore(yahtzee.domain.Dice) 
     * @see yahtzee.domain.ScoreChecker#checkPairForFullHouse(yahtzee.domain.Dice) 
     */
    public void scoreFullHouse() {
        int score = 0;
        if (this.scoreChecker.checkFullHouse(dice)) {
            int threeOfAKind = this.scoreChecker.checkThreeOfAKindScore(dice);
            int pair = this.scoreChecker.checkPairForFullHouse(dice);
            score = threeOfAKind + pair;
        }
        if (!this.getCurrentPlayer().checkIfScored(12)) {
            this.getCurrentPlayer().setFullHouse(score);
        }
        this.getCurrentPlayer().addScore(12, score, false);
    }
    
    /**
     * Metodi asettaa aktiiviselle pelaajalle pistesuorituksen 
     * kategorialle: sattuma.
     * 
     * @see yahtzee.domain.Player#addScore(int, int, boolean) 
     */
    public void scoreChance() {
        int score = 0;
        int ones = this.scoreChecker.checkOnes(dice);
        int twos = this.scoreChecker.checkTwos(dice) * 2;
        int threes = this.scoreChecker.checkThrees(dice) * 3;
        int fours = this.scoreChecker.checkFours(dice) * 4;
        int fives = this.scoreChecker.checkFives(dice) * 5;
        int sixes = this.scoreChecker.checkSixes(dice) * 6;
        score = ones + twos + threes + fours + fives + sixes;
        if (!this.getCurrentPlayer().checkIfScored(13)) {
            this.getCurrentPlayer().setChance(score);
        }
        this.getCurrentPlayer().addScore(13, score, false);
    }
            
    
}
