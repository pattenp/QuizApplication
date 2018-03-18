package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.util.StringConverter;
import logic.Controller;
import model.Category;
import model.Question;

import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author Nicolai Jaynes
 */
public class CategoryAndQuestionsController implements Initializable {

    @FXML
    private ComboBox<Category> comboBox;

    @FXML
    private ToggleGroup amtOfQuestionsGroup;

    @FXML
    private TextField tfName;


    private Controller controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleContinue() {
        String playerName = tfName.getText();
        String category = comboBox.getSelectionModel().getSelectedItem().getName();
        System.out.println(comboBox.getSelectionModel().getSelectedItem().getName());
        RadioButton questionsBtn = (RadioButton) amtOfQuestionsGroup.getSelectedToggle();
        int nbrOfQuestions = Integer.parseInt(questionsBtn.getText());

        controller.setAmountOfQuestions(nbrOfQuestions);
        controller.setCategory(category);
        controller.setPlayerName(playerName);
        controller.startGame();
    }

    @FXML
    private void handleBack() {
        controller.showMainMenu();
    }

//    public void setMainApp(Start start) {
//        this.start = start;
//    }

    public void setMainApp(Controller controller) {
        this.controller = controller;
    }

    public void setCategories(List<Category> categories) {
        comboBox.setItems(FXCollections.observableArrayList(categories));
        comboBox.setConverter(new StringConverter<Category>() {
            @Override
            public String toString(Category category) {
                return category.getName();
            }

            @Override
            public Category fromString(String string) {
                return null;
            }
        });
    }
}
