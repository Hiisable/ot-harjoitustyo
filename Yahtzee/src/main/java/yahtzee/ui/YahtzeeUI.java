
package yahtzee.ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class YahtzeeUI extends Application {
    
    private Scene playerSelect;
    private Scene onePlayerName;
    private Scene twoPlayersName;

    @Override
    public void start(Stage primaryStage) {
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
        onePlayerPane.getChildren().addAll(playerNameInput, addPlayer);
        
        onePlayerName = new Scene(onePlayerPane, 300, 250);
        
        VBox twoPlayersPane = new VBox (20);
        twoPlayersPane.setAlignment(Pos.CENTER);
        TextField player1NameInput = new TextField();
        player1NameInput.setMaxWidth(200);
        Button addPlayer1 = new Button("Add Player 1");
        TextField player2NameInput = new TextField();
        player2NameInput.setMaxWidth(200);
        Button addPlayer2 = new Button("Add Player 2");
        twoPlayersPane.getChildren().addAll(player1NameInput, addPlayer1, player2NameInput, addPlayer2);
        
        twoPlayersName = new Scene(twoPlayersPane, 300, 250);
        
        
        
        primaryStage.show();
    }
    
    @Override
    public void stop() {
        System.out.println("Closing Yahtzee application, thanks for playing.");
    }
    
        public static void main(String[] args) {
        launch(args);
    }
}


