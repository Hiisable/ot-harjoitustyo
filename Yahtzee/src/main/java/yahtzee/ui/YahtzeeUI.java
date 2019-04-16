
package yahtzee.ui;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        
        VBox gamePane = new VBox(10);
        HBox scoringPane = new HBox (50);
        
        HBox dicePane = new HBox (40);
        dicePane.setAlignment(Pos.CENTER);
        ToggleButton die1 = new ToggleButton("" + yahtzeeController.getDice().getValueOfDie(0) + "");
        ToggleButton die2 = new ToggleButton("" + yahtzeeController.getDice().getValueOfDie(1) + "");
        ToggleButton die3 = new ToggleButton("" + yahtzeeController.getDice().getValueOfDie(2) + "");
        ToggleButton die4 = new ToggleButton("" + yahtzeeController.getDice().getValueOfDie(3) + "");
        ToggleButton die5 = new ToggleButton("" + yahtzeeController.getDice().getValueOfDie(4) + "");
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
        
        VBox scoringButtonPane = new VBox (10);
        scoringButtonPane.setPrefWidth(250);
        Label filler = new Label("");
        scoringButtonPane.getChildren().add(filler);
        upperScoringButtons = new ArrayList();
        lowerScoringButtons = new ArrayList();
        
        Button ones = new Button("Ones");
        ones.setOnAction(e-> {
                yahtzeeController.scoreOnes();
                player1Scores.get(0).setText("" + yahtzeeController.scoreChecker.checkOnes(yahtzeeController.getDice()) + "");
                updatePlayerOneTotals();
        });
        upperScoringButtons.add(ones);
        Button twos = new Button("Twos");
        twos.setOnAction(e-> {       
                yahtzeeController.scoreTwos();
                player1Scores.get(1).setText("" + yahtzeeController.scoreChecker.checkTwos(yahtzeeController.getDice()) * 2 + "");
                updatePlayerOneTotals();             
        });
        upperScoringButtons.add(twos);
        Button threes = new Button("Threes");
        threes.setOnAction(e-> {
                yahtzeeController.scoreThrees(); 
                player1Scores.get(2).setText("" + yahtzeeController.scoreChecker.checkThrees(yahtzeeController.getDice()) * 3 + "");
                updatePlayerOneTotals();  
        });
        upperScoringButtons.add(threes);
        Button fours = new Button("Fours");
        fours.setOnAction(e-> {
                yahtzeeController.scoreFours();
                player1Scores.get(3).setText("" + yahtzeeController.scoreChecker.checkFours(yahtzeeController.getDice()) * 4 + "");
                updatePlayerOneTotals(); 
        });
        upperScoringButtons.add(fours);
        Button fives = new Button("Fives");
        fives.setOnAction(e-> {    
                yahtzeeController.scoreFives(); 
                player1Scores.get(4).setText("" + yahtzeeController.scoreChecker.checkFives(yahtzeeController.getDice()) * 5 + "");                 
                updatePlayerOneTotals();    
        });
        upperScoringButtons.add(fives);
        Button sixes = new Button("Sixes");
        sixes.setOnAction(e-> {
                yahtzeeController.scoreSixes(); 
                player1Scores.get(5).setText("" + yahtzeeController.scoreChecker.checkSixes(yahtzeeController.getDice()) * 6 + ""); 
                updatePlayerOneTotals();            
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
                yahtzeeController.scoreSmallStraight();
                player1Scores.get(8).setText("" + playerOne.getSmallStraight() + "");
                updatePlayerOneTotals();
        });
        lowerScoringButtons.add(smallStraight);
        Button largeStraight = new Button("Large Straight");
        largeStraight.setOnAction(e-> {
            yahtzeeController.scoreLargeStraight();
            player1Scores.get(9).setText("" + playerOne.getLargeStraight() + "");
            updatePlayerOneTotals();
        });
        lowerScoringButtons.add(largeStraight);
        Button twoOfAKind = new Button("Two of a Kind");
        twoOfAKind.setOnAction(e-> {
            yahtzeeController.scoreTwoOfAKind();
            player1Scores.get(10).setText("" + playerOne.getPair() + "");
            updatePlayerOneTotals();
        });
        lowerScoringButtons.add(twoOfAKind);
        Button twoPairs = new Button("Two Pairs");
        twoPairs.setOnAction(e-> {
            yahtzeeController.scoreTwoPairs();
            player1Scores.get(11).setText("" + playerOne.getTwoPairs() + "");
            updatePlayerOneTotals();
        });
        lowerScoringButtons.add(twoPairs);
        Button threeOfAKind = new Button("Three of a Kind");
        threeOfAKind.setOnAction(e-> {
            yahtzeeController.scoreThreeOfAKind();
            player1Scores.get(12).setText("" + playerOne.getThreeOfAKind() + "");
            updatePlayerOneTotals();
        });
        lowerScoringButtons.add(threeOfAKind);
        Button fourOfAKind = new Button("Four of a Kind");
        fourOfAKind.setOnAction(e-> {
            yahtzeeController.scoreFourOfAKind();
            player1Scores.get(13).setText("" + playerOne.getFourOfAKind() + "");
            updatePlayerOneTotals();
        });
        lowerScoringButtons.add(fourOfAKind);
        Button fullHouse = new Button("Full House");
        fullHouse.setOnAction(e-> {
            yahtzeeController.scoreFullHouse();
            player1Scores.get(14).setText("" + playerOne.getFullHouse() + "");
            updatePlayerOneTotals();
        });
        lowerScoringButtons.add(fullHouse);
        Button chance = new Button("Chance");
        chance.setOnAction(e-> {
            yahtzeeController.scoreChance();
            player1Scores.get(15).setText("" + playerOne.getChance() + "");
            updatePlayerOneTotals();
        });
        lowerScoringButtons.add(chance);
        Button yahtzee = new Button("Yahtzee");
        yahtzee.setOnAction(e-> {
            yahtzeeController.scoreYahtzee();
            player1Scores.get(16).setText("" + playerOne.getYahtzee() + "");
            updatePlayerOneTotals();
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

        
        gamePane.getChildren().addAll(dicePane, rollPane, scoringPane);
        gamePane.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        
        gameScene = new Scene(gamePane, 1000, 900);
        
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
            scoringPane.getChildren().remove(player2ScorePane);
            primaryStage.setScene(gameScene);
        });
        onePlayerPane.getChildren().addAll(playerNameInput, addPlayer, onePlayerGameStart);
        
        onePlayerName = new Scene(onePlayerPane, 300, 250);
        
        VBox twoPlayersPane = new VBox (20);
        twoPlayersPane.setAlignment(Pos.CENTER);
        TextField player1NameInput = new TextField();
        player1NameInput.setMaxWidth(200);
        Button addPlayer1 = new Button("Add Player 1");
        addPlayer1.setOnAction(e-> {
            String nameOne = player1NameInput.getText();
            yahtzeeController.addPlayerOne(nameOne);
            playerName.setText(yahtzeeController.getPlayerOneName());
        });
        TextField player2NameInput = new TextField();
        player2NameInput.setMaxWidth(200);
        Button addPlayer2 = new Button("Add Player 2");
        addPlayer2.setOnAction(e-> {
            String nameTwo = player2NameInput.getText();
            yahtzeeController.addPlayerTwo(nameTwo);
            player2Name.setText(yahtzeeController.getPlayerTwoName());
        });
        Button twoPlayerGameStart = new Button("Start Game!");
        twoPlayerGameStart.setOnAction(e-> {
            primaryStage.setScene(gameScene);
        });
        twoPlayersPane.getChildren().addAll(player1NameInput, addPlayer1, player2NameInput, addPlayer2, twoPlayerGameStart);
        
        twoPlayersName = new Scene(twoPlayersPane, 300, 300);
        
        
        
        primaryStage.show();
    }
    
    public void updatePlayerOneTotals() {
        player1Scores.get(6).setText("" + playerOne.getBonus() + "");
        player1Scores.get(7).setText("" + playerOne.getUpperScore() + ""); 
        player1Scores.get(17).setText("" + playerOne.getScore() + "");  
    }
   
    
    @Override
    public void stop() {
        System.out.println("Closing Yahtzee application, thanks for playing.");
    }
    
        public static void main(String[] args) {
        launch(args);
    }
}


