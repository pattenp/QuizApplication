package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import logic.Controller;
import model.Answer;
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
    private String correctAlternative;
    private List<Question> questionList;
    private List<Answer> candidateAnswers;
    private Controller controller;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentQuestion = 1;
        points = 0;
    }

    @FXML
    public void handleAnswer() {
        RadioButton rb = (RadioButton) btnGroup.getSelectedToggle();
        String selectedAnswer = rb.getText();
        checkIfCorrect(selectedAnswer);
        if(currentQuestion == amountOfQuestions) {
            //Alert the user that the game is completed
            //Open end of game screen
            controller.setPoints(points);
            controller.showEndOfGame();
        } else {
            currentQuestion++;
            Question newQuestion = questionList.get(currentQuestion - 1);
            lblCurQuestion.setText("Current Question: " + currentQuestion + "/" + amountOfQuestions);
            textArea.setText(newQuestion.getContent());
            candidateAnswers = newQuestion.getCandidateAnswers();
            setAlternatives(candidateAnswers.get(0).getContent(), candidateAnswers.get(1).getContent(),
                    candidateAnswers.get(2).getContent(), candidateAnswers.get(3).getContent());
            setCorrectAlternative(newQuestion.getCorrectAnswer().getContent());
        }
    }

    private void checkIfCorrect(String choice) {
        //If correct
        if(choice.equals(correctAlternative)) {
            points++;
            lblPoints.setText("Points: " + points);
        }

        //Alert the user if answer is correct or wrong

    }

    public void setAmountOfQuestions(int amountOfQuestions) {
        this.amountOfQuestions = amountOfQuestions;
    }

    public void setCorrectAlternative(String correctAlternative) {
        this.correctAlternative = correctAlternative;
    }

    public void setAlternatives(String answer1, String answer2, String answer3, String answer4) {
        answerOne.setText(answer1);
        answerTwo.setText(answer2);
        answerThree.setText(answer3);
        answerFour.setText(answer4);
    }

    public void setInitialAlternatives() {
        Question question = questionList.get(currentQuestion - 1);

        candidateAnswers = question.getCandidateAnswers();
        setAlternatives(candidateAnswers.get(0).getContent(), candidateAnswers.get(1).getContent(),
                candidateAnswers.get(2).getContent(), candidateAnswers.get(3).getContent());
        setCorrectAlternative(question.getCorrectAnswer().getContent());
    }

    public void setMainApp(Controller controller) {
        this.controller = controller;
    }

    public void setQuestionList(List<Question> questionsForGame) {
        questionList = questionsForGame;
    }

    public void initGUI() {
        textArea.setEditable(false);
        lblCurQuestion.setText("Current Question: " + currentQuestion + "/" + amountOfQuestions);
        lblPoints.setText("Points: " + points);
        textArea.setText(questionList.get(0).getContent());
    }
}
