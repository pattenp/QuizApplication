package view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.util.StringConverter;
import model.Category;

import java.util.List;

/**
 * @author Nicolai Nicolai
 */
public class HighScoreController {

    @FXML
    private ComboBox<Category> comboBox;

    @FXML
    private Label lblHighScore;

    private Start start;

    @FXML
    private void handleBack() {
        start.showMainMenu();
    }

    @FXML
    private void handleGetHighScore() {
        int highScore = start.getHighScore(comboBox.getSelectionModel().getSelectedItem());
        lblHighScore.setText("The high score is: " + highScore);
    }

    public void setMainApp(Start start) {
        this.start = start;
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
