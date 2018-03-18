package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import logic.Controller;

import java.net.URL;
import java.util.ResourceBundle;

public class EndOfGameController implements Initializable {

    @FXML
    Label lblScore;

    private int points;

    private Controller controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void handleMainMenu() {
        controller.showMainMenu();
    }

    @FXML
    public void handleSendHighScore() {
        //Alert, do you want to send your high score?
        //If yes
        controller.sendHighScore();
    }

    public void setLblScore() {
        lblScore.setText("Your final score is " + points + " points" );
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setMainApp(Controller controller) {
        this.controller = controller;
    }
}
