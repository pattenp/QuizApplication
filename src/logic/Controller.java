package logic;

import api.ApiServiceMock;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Category;
import model.HighScore;
import model.Question;
import repository.PlayerRepository;
import repository.QuestionRepository;
import view.CategoryAndQuestionsController;
import view.EndOfGameController;
import view.GameController;
import view.HighScoreController;
import view.Start;
import view.View;

import java.io.IOException;
import java.util.List;

/**
 * @author Patrik Larsson.
 */
public class Controller extends Application {

  private ApiServiceMock apiServiceMock;

  private Stage primaryStage;

  private BorderPane rootLayout;

  private int amountOfQuestions;
  private int points;

  private String playerName;
  private String category;

  private List<Category> categoryList;

  @Override
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    this.primaryStage.setTitle("Quiz Game");

    initRootLayout();
    showMainMenu();

    apiServiceMock = new ApiServiceMock();
    categoryList = getCategories();
  }

  private void initRootLayout() {
    try {
      // Load root layout from fxml file.
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(Start.class
              .getResource("../view/RootLayout.fxml"));
      rootLayout = loader.load();

      // Show the scene containing the root layout.
      Scene scene = new Scene(rootLayout);
      primaryStage.setScene(scene);

      primaryStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public void showMainMenu() {
    try {
      // Load main menu
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(Start.class.getResource("../view/View.fxml"));
      AnchorPane mainMenu = loader.load();

      // Set main menu into the center of root layout.
      rootLayout.setCenter(mainMenu);

      // Give the controller access to the main app.
      View controller = loader.getController();
      controller.setMainApp(this);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void showChooseCategoryAndQuestions() {
    try {
      // Load choose category and questions menu
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(Start.class.getResource("../view/ChooseCategoryAndQuestions.fxml"));
      AnchorPane categoryAndQuestions = loader.load();

      // Set main menu into the center of root layout.
      rootLayout.setCenter(categoryAndQuestions);

      // Give the controller access to the main app.
      CategoryAndQuestionsController controller = loader.getController();
      controller.setMainApp(this);
      controller.setCategories(categoryList);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void startGame() {
    try {
      // Load choose category and questions menu
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(Start.class.getResource("../view/Game.fxml"));
      AnchorPane game = loader.load();

      // Set main menu into the center of root layout.
      rootLayout.setCenter(game);

      // Give the controller access to the main app.
      GameController controller = loader.getController();
      controller.setMainApp(this);
      controller.setAmountOfQuestions(amountOfQuestions);

      controller.setQuestionList(getQuestionsForGame(category, amountOfQuestions));
      controller.setInitialAlternatives();
      controller.initGUI();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void showEndOfGame() {
    try {
      // Load choose category and questions menu
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(Start.class.getResource("../view/EndOfGameLayout.fxml"));
      AnchorPane endOfGame = loader.load();

      // Set main menu into the center of root layout.
      rootLayout.setCenter(endOfGame);

      // Give the controller access to the main app.
      EndOfGameController controller = loader.getController();
      controller.setPoints(points);
      controller.setLblScore();
      controller.setMainApp(this);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void showHighScore() {
    try {
      // Load choose category and questions menu
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(Start.class.getResource("../view/HighScore.fxml"));
      AnchorPane highScore = loader.load();

      // Set main menu into the center of root layout.
      rootLayout.setCenter(highScore);

      // Give the controller access to the main app.
      HighScoreController controller = loader.getController();
      controller.setMainApp(this);
      controller.setCategories(categoryList);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private List<Category> getCategories() {
    return apiServiceMock.getAllCategories();
  }

  private List<Question> getQuestionsForGame(String chosenCategory, int amountOfQuestions) {
    return apiServiceMock.getQuestionByCategoryName(chosenCategory, amountOfQuestions);
  }

  public void setAmountOfQuestions(int amountOfQuestions) {
    this.amountOfQuestions = amountOfQuestions;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  public List<HighScore> getHighScore(String category) {
    List<HighScore> highScore = null;
    try {
      highScore = apiServiceMock.getHighscoreByCategoryName(category);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return highScore;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public void sendHighScore() {

  }
}
