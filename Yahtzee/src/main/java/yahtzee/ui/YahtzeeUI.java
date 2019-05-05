
package yahtzee.ui;

import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import yahtzee.domain.Player;
import yahtzee.domain.YahtzeeController;

public class YahtzeeUI extends Application {
    
    private YahtzeeController yahtzeeController;   
    private Player playerOne;
    private Player playerTwo;
    private Scene playerSelect;
    private Scene onePlayerName;
    private Scene twoPlayersName;
    private Scene gameScene;
    private HBox dicePane;
    private Button newGame;
    private Label gameDialog;
    private ArrayList<ToggleButton> dieButtons;
    private ArrayList<Button> upperScoringButtons;
    private ArrayList<Button> lowerScoringButtons;
    private ArrayList<Label> player1Scores;
    private ArrayList<Label> player2Scores;

    @Override
    public void init() throws Exception {
        yahtzeeController = new YahtzeeController();
        playerOne = yahtzeeController.getPlayerOne();
        playerTwo = yahtzeeController.getPlayerTwo();
    }
    
    
    @Override
    public void start(Stage primaryStage) {
        
        //game scene
        
        VBox gamePane = new VBox(10);
        HBox scoringPane = new HBox (50);
        
        dieButtons = new ArrayList<> ();
        dicePane = new HBox (40);
        dicePane.setAlignment(Pos.CENTER);
        ToggleButton die1 = new ToggleButton("" + yahtzeeController.getDice().getValueOfDie(0) + "");
        die1.setOnAction(e-> {
            yahtzeeController.getDice().selectDie(0);
        });
        dieButtons.add(die1);
        ToggleButton die2 = new ToggleButton("" + yahtzeeController.getDice().getValueOfDie(1) + "");
        die2.setOnAction(e-> {
            yahtzeeController.getDice().selectDie(1);
        });
        dieButtons.add(die2);
        ToggleButton die3 = new ToggleButton("" + yahtzeeController.getDice().getValueOfDie(2) + "");
        die3.setOnAction(e-> {
            yahtzeeController.getDice().selectDie(2);
        });
        dieButtons.add(die3);
        ToggleButton die4 = new ToggleButton("" + yahtzeeController.getDice().getValueOfDie(3) + "");
        die4.setOnAction(e-> {
            yahtzeeController.getDice().selectDie(3);
        });
        dieButtons.add(die4);
        ToggleButton die5 = new ToggleButton("" + yahtzeeController.getDice().getValueOfDie(4) + "");
        die5.setOnAction(e-> {
            yahtzeeController.getDice().selectDie(4);
        });
        dieButtons.add(die5);
        dicePane.getChildren().addAll(die1, die2, die3, die4, die5);
        
        
        HBox rollPane = new HBox(10);
        Button rollButton = new Button("Roll Dice!");
        rollButton.setOnAction(e-> {
            yahtzeeController.roll();
            die1.setText("" + yahtzeeController.getDice().getValueOfDie(0) + "");
            die2.setText("" + yahtzeeController.getDice().getValueOfDie(1) + "");
            die3.setText("" + yahtzeeController.getDice().getValueOfDie(2) + "");
            die4.setText("" + yahtzeeController.getDice().getValueOfDie(3) + "");
            die5.setText("" + yahtzeeController.getDice().getValueOfDie(4) + "");
        });
        rollPane.setAlignment(Pos.CENTER);
        rollPane.getChildren().add(rollButton);
        
        HBox dialogPane = new HBox(10);
        gameDialog = new Label("");
        dialogPane.setAlignment(Pos.CENTER);
        dialogPane.getChildren().add(gameDialog);
        
        
        VBox scoringButtonPane = new VBox (10);
        scoringButtonPane.setPrefWidth(250);
        Label filler = new Label("");
        scoringButtonPane.getChildren().add(filler);
        upperScoringButtons = new ArrayList();
        lowerScoringButtons = new ArrayList();
        
        Button ones = new Button("Ones");
        ones.setOnAction(e-> {
                if (yahtzeeController.getCurrentPlayer().equals(playerOne) && !yahtzeeController.checkScoreStatus(0)) {
                    yahtzeeController.scoreOnes();
                    player1Scores.get(0).setText("" + playerOne.getOnes() + "");
                    scoreButtonEndSequence();
                } else if (yahtzeeController.getCurrentPlayer().equals(playerTwo) && !yahtzeeController.checkScoreStatus(0)) {
                    yahtzeeController.scoreOnes();
                    player2Scores.get(0).setText("" + playerTwo.getOnes() + "");
                    scoreButtonEndSequence();
                } else {
                    alreadyScored();
                }
        });
        upperScoringButtons.add(ones);
        Button twos = new Button("Twos");
        twos.setOnAction(e-> {       
                if (yahtzeeController.getCurrentPlayer().equals(playerOne) && !yahtzeeController.checkScoreStatus(1)) {
                    yahtzeeController.scoreTwos();
                    player1Scores.get(1).setText("" + playerOne.getTwos() + "");
                    scoreButtonEndSequence();
                } else if (yahtzeeController.getCurrentPlayer().equals(playerTwo) && !yahtzeeController.checkScoreStatus(1)) {
                    yahtzeeController.scoreTwos();
                    player2Scores.get(1).setText("" + playerTwo.getTwos() + "");
                    scoreButtonEndSequence();
                } else {
                    alreadyScored();
                }
        });
        upperScoringButtons.add(twos);
        Button threes = new Button("Threes");
        threes.setOnAction(e-> {
                if (yahtzeeController.getCurrentPlayer().equals(playerOne) && !yahtzeeController.checkScoreStatus(2)) {
                    yahtzeeController.scoreThrees();
                    player1Scores.get(2).setText("" + playerOne.getThrees() + "");
                    scoreButtonEndSequence();
                } else if (yahtzeeController.getCurrentPlayer().equals(playerTwo) && !yahtzeeController.checkScoreStatus(2)) {
                    yahtzeeController.scoreThrees();
                    player2Scores.get(2).setText("" + playerTwo.getThrees() + "");
                    scoreButtonEndSequence();
                } else {
                    alreadyScored();
                }
        });
        upperScoringButtons.add(threes);
        Button fours = new Button("Fours");
        fours.setOnAction(e-> {
                if (yahtzeeController.getCurrentPlayer().equals(playerOne) && !yahtzeeController.checkScoreStatus(3)) {
                    yahtzeeController.scoreFours();
                    player1Scores.get(3).setText("" + playerOne.getFours() + "");
                    scoreButtonEndSequence();
                } else if (yahtzeeController.getCurrentPlayer().equals(playerTwo) && !yahtzeeController.checkScoreStatus(3)) {
                    yahtzeeController.scoreFours();
                    player2Scores.get(3).setText("" + playerTwo.getFours() + "");
                    scoreButtonEndSequence();
                } else {
                    alreadyScored();
                }
        });
        upperScoringButtons.add(fours);
        Button fives = new Button("Fives");
        fives.setOnAction(e-> {    
                if (yahtzeeController.getCurrentPlayer().equals(playerOne) && !yahtzeeController.checkScoreStatus(4)) {
                    yahtzeeController.scoreFives();
                    player1Scores.get(4).setText("" + playerOne.getFives() + "");
                    scoreButtonEndSequence();
                } else if (yahtzeeController.getCurrentPlayer().equals(playerTwo) && !yahtzeeController.checkScoreStatus(4)) {
                    yahtzeeController.scoreFives();
                    player2Scores.get(4).setText("" + playerTwo.getFives() + "");
                    scoreButtonEndSequence();
                } else {
                    alreadyScored();
                }    
        });
        upperScoringButtons.add(fives);
        Button sixes = new Button("Sixes");
        sixes.setOnAction(e-> { 
                if (yahtzeeController.getCurrentPlayer().equals(playerOne) && !yahtzeeController.checkScoreStatus(5)) {
                    yahtzeeController.scoreSixes();
                    player1Scores.get(5).setText("" + playerOne.getSixes() + "");
                    scoreButtonEndSequence();
                } else if (yahtzeeController.getCurrentPlayer().equals(playerTwo) && !yahtzeeController.checkScoreStatus(5)) {
                    yahtzeeController.scoreSixes();
                    player2Scores.get(5).setText("" + playerTwo.getSixes() + "");
                    scoreButtonEndSequence();
                } else {
                    alreadyScored();
                }            
        });
        upperScoringButtons.add(sixes);
        
        Label bonus = new Label("Bonus");
        bonus.setMinWidth(scoringButtonPane.getPrefWidth());
        bonus.setPrefHeight(30);
        bonus.setBackground(new Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));
        bonus.setAlignment(Pos.CENTER);
        Label upperScore = new Label("Upper Score");
        upperScore.setMinWidth(scoringButtonPane.getPrefWidth());
        upperScore.setPrefHeight(30);
        upperScore.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
        upperScore.setAlignment(Pos.CENTER);
        
        Button smallStraight = new Button("Small Straight");
        smallStraight.setOnAction(e-> {
                if (yahtzeeController.getCurrentPlayer().equals(playerOne) && !yahtzeeController.checkScoreStatus(6)) {
                    yahtzeeController.scoreSmallStraight();
                    player1Scores.get(8).setText("" + playerOne.getSmallStraight() + "");
                    scoreButtonEndSequence();
                } else if (yahtzeeController.getCurrentPlayer().equals(playerTwo) && !yahtzeeController.checkScoreStatus(6)) {
                    yahtzeeController.scoreSmallStraight();
                    player2Scores.get(8).setText("" + playerTwo.getSmallStraight() + "");
                    scoreButtonEndSequence();
                } else {
                    alreadyScored();
                }
        });
        lowerScoringButtons.add(smallStraight);
        Button largeStraight = new Button("Large Straight");
        largeStraight.setOnAction(e-> {
            if (yahtzeeController.getCurrentPlayer().equals(playerOne) && !yahtzeeController.checkScoreStatus(7)) {
                yahtzeeController.scoreLargeStraight();
                player1Scores.get(9).setText("" + playerOne.getLargeStraight() + "");
                scoreButtonEndSequence();
            } else if (yahtzeeController.getCurrentPlayer().equals(playerTwo) && !yahtzeeController.checkScoreStatus(7)) {
                yahtzeeController.scoreLargeStraight();
                player2Scores.get(9).setText("" + playerTwo.getLargeStraight() + "");
                scoreButtonEndSequence();
            } else {
                alreadyScored();
            }
        });
        lowerScoringButtons.add(largeStraight);
        Button twoOfAKind = new Button("Two of a Kind");
        twoOfAKind.setOnAction(e-> {
            if (yahtzeeController.getCurrentPlayer().equals(playerOne) && !yahtzeeController.checkScoreStatus(8)) {
                yahtzeeController.scoreTwoOfAKind();
                player1Scores.get(10).setText("" + playerOne.getPair() + "");
                scoreButtonEndSequence();
            } else if (yahtzeeController.getCurrentPlayer().equals(playerTwo) && !yahtzeeController.checkScoreStatus(8)) {
                yahtzeeController.scoreTwoOfAKind();
                player2Scores.get(10).setText("" + playerTwo.getPair() + "");
                scoreButtonEndSequence();
            } else {
                alreadyScored();
            }
        });
        lowerScoringButtons.add(twoOfAKind);
        Button twoPairs = new Button("Two Pairs");
        twoPairs.setOnAction(e-> {
            if (yahtzeeController.getCurrentPlayer().equals(playerOne) && !yahtzeeController.checkScoreStatus(9)) {
                yahtzeeController.scoreTwoPairs();
                player1Scores.get(11).setText("" + playerOne.getTwoPairs() + "");
                scoreButtonEndSequence();
            } else if (yahtzeeController.getCurrentPlayer().equals(playerTwo) && !yahtzeeController.checkScoreStatus(9)) {
                yahtzeeController.scoreTwoPairs();
                player2Scores.get(11).setText("" + playerTwo.getTwoPairs() + "");
                scoreButtonEndSequence();
            } else {
                alreadyScored();
            }
        });
        lowerScoringButtons.add(twoPairs);
        Button threeOfAKind = new Button("Three of a Kind");
        threeOfAKind.setOnAction(e-> {
            if (yahtzeeController.getCurrentPlayer().equals(playerOne) && !yahtzeeController.checkScoreStatus(10)) {
                yahtzeeController.scoreThreeOfAKind();
                player1Scores.get(12).setText("" + playerOne.getThreeOfAKind() + "");
                scoreButtonEndSequence();
            } else if (yahtzeeController.getCurrentPlayer().equals(playerTwo) && !yahtzeeController.checkScoreStatus(10)) {
                yahtzeeController.scoreThreeOfAKind();
                player2Scores.get(12).setText("" + playerTwo.getThreeOfAKind() + "");
                scoreButtonEndSequence();
            } else {
                alreadyScored();
            }
        });
        lowerScoringButtons.add(threeOfAKind);
        Button fourOfAKind = new Button("Four of a Kind");
        fourOfAKind.setOnAction(e-> {
            if (yahtzeeController.getCurrentPlayer().equals(playerOne) && !yahtzeeController.checkScoreStatus(11)) {
                yahtzeeController.scoreFourOfAKind();
                player1Scores.get(13).setText("" + playerOne.getFourOfAKind() + "");
                scoreButtonEndSequence();
            } else if (yahtzeeController.getCurrentPlayer().equals(playerTwo) && !yahtzeeController.checkScoreStatus(11)) {
                yahtzeeController.scoreFourOfAKind();
                player2Scores.get(13).setText("" + playerTwo.getFourOfAKind() + "");
                scoreButtonEndSequence();
            } else {
                alreadyScored();
            }
        });
        lowerScoringButtons.add(fourOfAKind);
        Button fullHouse = new Button("Full House");
        fullHouse.setOnAction(e-> {
            if (yahtzeeController.getCurrentPlayer().equals(playerOne) && !yahtzeeController.checkScoreStatus(12)) {
                yahtzeeController.scoreFullHouse();
                player1Scores.get(14).setText("" + playerOne.getFullHouse() + "");
                scoreButtonEndSequence();
            } else if (yahtzeeController.getCurrentPlayer().equals(playerTwo) && !yahtzeeController.checkScoreStatus(12)) {
                yahtzeeController.scoreFullHouse();
                player2Scores.get(14).setText("" + playerTwo.getFullHouse() + "");
                scoreButtonEndSequence();
            } else {
                alreadyScored();
            }
        });
        lowerScoringButtons.add(fullHouse);
        Button chance = new Button("Chance");
        chance.setOnAction(e-> {
            if (yahtzeeController.getCurrentPlayer().equals(playerOne) && !yahtzeeController.checkScoreStatus(13)) {
                yahtzeeController.scoreChance();
                player1Scores.get(15).setText("" + playerOne.getChance() + "");
                scoreButtonEndSequence();
            } else if (yahtzeeController.getCurrentPlayer().equals(playerTwo) && !yahtzeeController.checkScoreStatus(13)) {
                yahtzeeController.scoreChance();
                player2Scores.get(15).setText("" + playerTwo.getChance() + "");
                scoreButtonEndSequence();
            } else {
                alreadyScored();
            }
        });
        lowerScoringButtons.add(chance);
        Button yahtzee = new Button("Yahtzee");
        yahtzee.setOnAction(e-> {
            if (yahtzeeController.getCurrentPlayer().equals(playerOne) && !yahtzeeController.checkScoreStatus(14)) {
                yahtzeeController.scoreYahtzee();
                player1Scores.get(16).setText("" + playerOne.getYahtzee() + "");
                scoreButtonEndSequence();
            } else if (yahtzeeController.getCurrentPlayer().equals(playerTwo) && !yahtzeeController.checkScoreStatus(14)) {
                yahtzeeController.scoreYahtzee();
                player2Scores.get(16).setText("" + playerTwo.getYahtzee() + "");
                scoreButtonEndSequence();
            } else {
                alreadyScored();
            }
        });
        lowerScoringButtons.add(yahtzee);
        
        Label totalScore = new Label("Total Score");
        totalScore.setMinWidth(scoringButtonPane.getPrefWidth());
        totalScore.setPrefHeight(30);
        totalScore.setBackground(new Background(new BackgroundFill(Color.DARKORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
        totalScore.setAlignment(Pos.CENTER);
        
        for(Button button: upperScoringButtons) {
            button.setMinWidth(scoringButtonPane.getPrefWidth());
            button.setPrefHeight(30);
            scoringButtonPane.getChildren().add(button);
        }
        
        scoringButtonPane.getChildren().addAll(bonus, upperScore);
        
        for(Button button: lowerScoringButtons) {
            button.setMinWidth(scoringButtonPane.getPrefWidth());
            button.setPrefHeight(30);
            scoringButtonPane.getChildren().add(button);
        }
        
        scoringButtonPane.getChildren().add(totalScore);
        
        VBox player1ScorePane = new VBox(10);
        player1ScorePane.setPrefWidth(250);
        player1Scores = new ArrayList();   
        Label playerName = new Label("Player 1");
        if(yahtzeeController.getPlayerOneName()!=null) {
            playerName.setText(yahtzeeController.getPlayerOneName());
        }
        playerName.setMinWidth(player1ScorePane.getPrefWidth());
        playerName.setAlignment(Pos.CENTER);
        player1ScorePane.getChildren().add(playerName);
        for(int i = 0; i < 18; i++) {
            Label label = new Label("-");
            label.setMinWidth(player1ScorePane.getPrefWidth());
            label.setPrefHeight(31);
            label.setAlignment(Pos.CENTER);
            label.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            player1Scores.add(label);
            player1ScorePane.getChildren().add(label);
        }
        
        VBox player2ScorePane = new VBox(10);
        player2ScorePane.setPrefWidth(250);
        player2Scores = new ArrayList();
        Label player2Name = new Label("Player 2");
        if(yahtzeeController.getPlayerTwoName()!=null) {
            player2Name.setText(yahtzeeController.getPlayerTwoName());
        }
        player2Name.setMinWidth(player2ScorePane.getPrefWidth());
        player2Name.setAlignment(Pos.CENTER);
        player2ScorePane.getChildren().add(player2Name);
        for(int i=0; i<18; i++) {
            Label label = new Label("-");
            label.setMinWidth(player2ScorePane.getPrefWidth());
            label.setPrefHeight(31);
            label.setAlignment(Pos.CENTER);
            label.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            player2Scores.add(label);
            player2ScorePane.getChildren().add(label);
        }
        
        scoringPane.setAlignment(Pos.CENTER);
        scoringPane.getChildren().addAll(scoringButtonPane, player1ScorePane, player2ScorePane);
        
        HBox newGamePane = new HBox (10);
        newGame = new Button ("New Game");
        newGame.setOnAction(e-> {
            yahtzeeController.newGame();
            resetPlayerScores();
            primaryStage.setScene(playerSelect);
            scoringPane.getChildren().clear();
            scoringPane.getChildren().addAll(scoringButtonPane, player1ScorePane, player2ScorePane);
            gamePane.getChildren().clear();
            gamePane.getChildren().addAll(dicePane, rollPane, dialogPane, scoringPane, newGamePane);
        });
        newGamePane.setAlignment(Pos.CENTER);
        newGamePane.getChildren().add(newGame);

        
        gamePane.getChildren().addAll(dicePane, rollPane, dialogPane, scoringPane, newGamePane);
        gamePane.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        
        gameScene = new Scene(gamePane, 1000, 900);
        
        // player selection scene
        
        VBox playerPane = new VBox(40);
        playerPane.setAlignment(Pos.CENTER);
        Button onePlayer = new Button("One Player Game");
        onePlayer.setOnAction(e-> {
            primaryStage.setScene(onePlayerName);
        });
        Button twoPlayers = new Button ("Two Player Game");
        twoPlayers.setOnAction(e-> {
            primaryStage.setScene(twoPlayersName);
        });
        
        playerPane.getChildren().addAll(onePlayer, twoPlayers);
        
        playerSelect = new Scene(playerPane, 300, 250);
        primaryStage.setScene(playerSelect);
        
        // one player creation scene
        
        VBox onePlayerPane = new VBox (20);
        onePlayerPane.setAlignment(Pos.CENTER);
        TextField playerNameInput = new TextField();
        playerNameInput.setMaxWidth(200);
        Button addPlayer = new Button ("Add Player");
        addPlayer.setOnAction(e->{
            String name = playerNameInput.getText();
            yahtzeeController.addPlayerOne(name);
            playerName.setText(yahtzeeController.getPlayerOneName());
        });
        Button onePlayerGameStart = new Button("Start Game!");
        onePlayerGameStart.setOnAction(e-> {
            gameDialog.setText(yahtzeeController.getPlayerOneName() + ", roll the Dice!");
            scoringPane.getChildren().remove(player2ScorePane);
            primaryStage.setScene(gameScene);
        });
        onePlayerPane.getChildren().addAll(playerNameInput, addPlayer, onePlayerGameStart);
        
        onePlayerName = new Scene(onePlayerPane, 300, 250);
        
        // two players creation scene
        
        VBox twoPlayersPane = new VBox (20);
        twoPlayersPane.setAlignment(Pos.CENTER);
        TextField player1NameInput = new TextField("");
        player1NameInput.setMaxWidth(200);
        Button addPlayer1 = new Button("Add Player 1");
        addPlayer1.setOnAction(e-> {
            String nameOne = player1NameInput.getText();
            yahtzeeController.addPlayerOne(nameOne);
            playerName.setText(yahtzeeController.getPlayerOneName());
        });
        TextField player2NameInput = new TextField("");
        player2NameInput.setMaxWidth(200);
        Button addPlayer2 = new Button("Add Player 2");
        addPlayer2.setOnAction(e-> {
            String nameTwo = player2NameInput.getText();
            yahtzeeController.addPlayerTwo(nameTwo);
            player2Name.setText(yahtzeeController.getPlayerTwoName());
        });
        Button twoPlayerGameStart = new Button("Start Game!");
        twoPlayerGameStart.setOnAction(e-> {
            if (player2NameInput.getText().isEmpty()) {
                yahtzeeController.addPlayerTwo("Player 2");
            }
            gameDialog.setText(yahtzeeController.getPlayerOneName() + ", roll the Dice!");
            primaryStage.setScene(gameScene);
        });
        twoPlayersPane.getChildren().addAll(player1NameInput, addPlayer1, player2NameInput, addPlayer2, twoPlayerGameStart);
        
        twoPlayersName = new Scene(twoPlayersPane, 300, 300);
        
        
        
        primaryStage.show();
    }
    
    /**
     * Metodi päivittää pelaajien pistesaldot käyttöliittymässä ja resetoi nopat.
     */
    public void updateTotals() {
        player1Scores.get(6).setText("" + playerOne.getBonus() + "");
        player1Scores.get(7).setText("" + playerOne.getUpperScore() + ""); 
        player1Scores.get(17).setText("" + playerOne.getScore() + "");
        player2Scores.get(6).setText("" + playerTwo.getBonus() + "");
        player2Scores.get(7).setText("" + playerTwo.getUpperScore() + ""); 
        player2Scores.get(17).setText("" + playerTwo.getScore() + "");
        yahtzeeController.dice.setAllDice(0);
        resetDice();
    }
    
    /**
     * Metodi asettaa kaikkien noppien valintastatukseksi "ei valitun" laukaisemalla
     * valittuja noppia vastaavan napin toiminnon.
     */
    public void resetDice() {
        int i = 0;
        for (ToggleButton button : dieButtons) {
            if (button.isSelected()) {
                button.fire();
            }
            button.setText("" + yahtzeeController.getDice().getValueOfDie(i) + "");
            i++;
        }
    }
    
    /**
     * Metodi asettaa käyttöliittymässä näkyvät pelaajien psitesuoritukset niiden
     * pelin alun oletusarvoiksi, jolloin suoritusta ei vielä ole tehty.
     */
    public void resetPlayerScores() {       
        for(Label label : player1Scores) {
            label.setText("-");
        }
        for (Label label : player2Scores) {
            label.setText("-");
        }
    }
    
    /**
     * Metodi asettaa käyttöliittymässä näkyvään dialogilabeliin tekstin, joka huomauttaa
     * jo tehdystä pistesuorituksesta.
     */
    public void alreadyScored() {
        gameDialog.setText("Already scored, choose a different category.");
    }
    
    /**
     * Metodi asettaa kyttöliittymän dialogilabelin tekstin ilmoittamaan aktiivisen pelaajan
     * vuoron.
     */
    public void turnDialog() {
        gameDialog.setText(yahtzeeController.getCurrentPlayer().getName() + ", your turn!");
    }
    
    /**
     * Metodi suorittaa pistesuoritusnappien lopussa tapahtuvat toiminnot.
     */
    public void scoreButtonEndSequence() {
        yahtzeeController.changeTurn();
        turnDialog();
        updateTotals();
        if (yahtzeeController.checkGameState()) {
            gameOver();
        }
    }
    
    /**
     * Metodi näyttää pelin lopuksi varoitusdialogina pelin voittajan tai tasapelin ja kysyy aloitetaanko
     * uusi peli. Jos ei valita uutta peliä, ohjelma suljetaan.
     */
    public void gameOver() {
        Alert gameOver = new Alert(AlertType.WARNING,"", ButtonType.YES, ButtonType.NO);
        gameOver.setTitle("Game Over!");
        if (yahtzeeController.getWinner() != null) {
            String winner = yahtzeeController.getWinner().getName(); 
            gameOver.setHeaderText(winner + " wins, congratulations!");
        } else {
            gameOver.setHeaderText("The game is a draw!");
        }
        gameOver.setContentText("Game over. Start new game?");
        
        Optional <ButtonType> result = gameOver.showAndWait();
        if (result.get() == ButtonType.YES) {
            newGame.fire();
        } else {
            System.exit(0);
        }       
    }
    
    @Override
    public void stop() {
        System.out.println("Closing Yahtzee application, thanks for playing.");
    }
    
        public static void main(String[] args) {
        launch(args);
    }
}


