package view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.util.StringConverter;
import logic.Controller;
import model.Category;
import model.HighScore;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Nicolai Nicolai
 */
public class HighScoreController {

    @FXML
    private ComboBox<Category> comboBox;

    @FXML
    private Label lblPlayerOneName;

    @FXML
    private Label lblPlayerTwoName;

    @FXML
    private Label lblPlayerThreeName;

    @FXML
    private Label lblPlayerFourName;

    @FXML
    private Label lblPlayerFiveName;

    @FXML
    private Label lblPlayerOneScore;

    @FXML
    private Label lblPlayerTwoScore;

    @FXML
    private Label lblPlayerThreeScore;

    @FXML
    private Label lblPlayerFourScore;

    @FXML
    private Label lblPlayerFiveScore;

    private Controller controller;

    @FXML
    private void handleBack() {
        controller.showMainMenu();
    }

    @FXML
    private void handleGetHighScore() {
        List<HighScore> highScore = controller.getHighScore(comboBox.getSelectionModel().getSelectedItem().getName());

        highScore.sort((lhs, rhs) -> Integer.compare(rhs.getScore(), lhs.getScore()));

        lblPlayerOneName.setText(highScore.get(0).getName());
        lblPlayerTwoName.setText(highScore.get(1).getName());
        lblPlayerThreeName.setText(highScore.get(2).getName());
        lblPlayerFourName.setText(highScore.get(3).getName());
        lblPlayerFiveName.setText(highScore.get(4).getName());

        lblPlayerOneScore.setText(String.valueOf(highScore.get(0).getScore()));
        lblPlayerTwoScore.setText(String.valueOf(highScore.get(1).getScore()));
        lblPlayerThreeScore.setText(String.valueOf(highScore.get(2).getScore()));
        lblPlayerFourScore.setText(String.valueOf(highScore.get(3).getScore()));
        lblPlayerFiveScore.setText(String.valueOf(highScore.get(4).getScore()));
    }

    public void setMainApp(Controller controller) {
        this.controller = controller;
    }


    public void setCategories(List<Category> categories) {
        comboBox.setItems(FXCollections.observableArrayList(categories));
        comboBox.setConverter(new StringConverter<Category>() {
            @Override
            public String toString(Category object) {
                return object.getName();
            }

            @Override
            public Category fromString(String string) {
                return null;
            }
        });
    }

}
