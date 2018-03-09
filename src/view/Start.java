package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logic.Controller;
import model.Category;

import java.io.IOException;
import java.util.List;

/**
 * Starts the GUI
 * @author Nicolai Jaynes
 */
public class Start extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private Controller mainController;

    private int amountOfQuestions;

    private String category;

    private List<Category> categoryList;

    private int points;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Quiz Game");

        initRootLayout();

        showMainMenu();

        mainController = new Controller();

        categoryList = mainController.getCategories();
    }

    private void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Start.class
                    .getResource("RootLayout.fxml"));
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
            loader.setLocation(Start.class.getResource("View.fxml"));
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
            loader.setLocation(Start.class.getResource("ChooseCategoryAndQuestions.fxml"));
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
            loader.setLocation(Start.class.getResource("Game.fxml"));
            AnchorPane game = loader.load();

            // Set main menu into the center of root layout.
            rootLayout.setCenter(game);

            // Give the controller access to the main app.
            GameController controller = loader.getController();
            controller.setMainApp(this);
            controller.setAmountOfQuestions(amountOfQuestions);

            Category chosenCategory = null;

            for (Category aCategory : categoryList) {
                if (category.equals(aCategory.getName())) {
                    chosenCategory = aCategory;
                }
            }
            controller.setQuestionList(mainController.getQuestionsForGame(chosenCategory, amountOfQuestions));
            controller.initGUI();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showEndOfGame() {
        try {
            // Load choose category and questions menu
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Start.class.getResource("EndOfGameLayout.fxml"));
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
            loader.setLocation(Start.class.getResource("HighScore.fxml"));
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

    public void setAmountOfQuestions(int amountOfQuestions) {
        this.amountOfQuestions = amountOfQuestions;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getHighScore(Category category) {
        //Get high score for chosen category
        return 10;
    }
}
