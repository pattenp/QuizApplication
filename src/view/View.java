package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import logic.Controller;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The main view
 * @author Nicolai Jaynes
 */
public class View implements Initializable {
    private Controller controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleRequestGame() {
        controller.showChooseCategoryAndQuestions();
    }

    @FXML
    private void handleRequestHighScore() {
        controller.showHighScore();
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    public void setMainApp(Controller controller) {
        this.controller = controller;
    }
}
