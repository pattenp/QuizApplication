package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class EndOfGameController implements Initializable {

    @FXML
    Label lblScore;

    private int points;

    private Start start;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void handleMainMenu() {
        start.showMainMenu();
    }

    @FXML
    public void handleSendHighScore() {
        //Send high score
    }

    public void setLblScore() {
        lblScore.setText("Your final score is " + points + " points" );
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setMainApp(Start start) {
        this.start = start;
    }
}
