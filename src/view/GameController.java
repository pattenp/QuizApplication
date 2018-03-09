package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import model.Category;
import model.Question;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author Nicolai Jaynes
 */
public class GameController implements Initializable {

    private int amountOfQuestions;
    private int currentQuestion;
    private int points;
    private int correctAlternative;
    private List<Question> questionList;

    private Category category;

    @FXML
    ToggleGroup btnGroup;

    @FXML
    Label lblCurQuestion;

    @FXML
    Label lblPoints;

    @FXML
    TextArea textArea;

    @FXML
    RadioButton answerOne;

    @FXML
    RadioButton answerTwo;

    @FXML
    RadioButton answerThree;

    @FXML
    RadioButton answerFour;

    private Start mainApp;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentQuestion = 1;
        points = 0;

    }

    @FXML
    public void handleAnswer() {
        checkIfCorrect();
        if(currentQuestion == amountOfQuestions) {
            //Alert the user that the game is completed
            //Open end of game screen
            mainApp.setPoints(points);
            mainApp.showEndOfGame();
        } else {
            currentQuestion++;
            lblCurQuestion.setText("Current Question: " + currentQuestion + "/" + amountOfQuestions);
            textArea.setText(questionList.get(currentQuestion - 1).getTextContent());
        }
    }

    private void checkIfCorrect() {
        //If correct
        points++;
        lblPoints.setText("Points: " + points);
        //If wrong do nothing

        //Alert the user if answer is correct or wrong
    }

    public void setAmountOfQuestions(int amountOfQuestions) {
        this.amountOfQuestions = amountOfQuestions;
    }

    public void setCorrectAlternative(int correctAlternative) {
        this.correctAlternative = correctAlternative;
    }

    public void setMainApp(Start mainApp) {
        this.mainApp = mainApp;
    }

    public void setQuestionList(List<Question> questionsForGame) {
        questionList = questionsForGame;
    }

    public void initGUI() {
        textArea.setEditable(false);
        lblCurQuestion.setText("Current Question: " + currentQuestion + "/" + amountOfQuestions);
        lblPoints.setText("Points: " + points);
        textArea.setText(questionList.get(0).getTextContent());
    }
}
