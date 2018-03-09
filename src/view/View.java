package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The main view
 * @author Nicolai Jaynes
 */
public class View implements Initializable {
    private Start start;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleRequestGame() {
        start.showChooseCategoryAndQuestions();
    }

    @FXML
    private void handleRequestHighScore() {
        start.showHighScore();
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    public void setMainApp(Start start) {
        this.start = start;
    }
}
