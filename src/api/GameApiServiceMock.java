package api;

import api.RequestResponse.ResponseCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Category;
import model.Player;
import model.Question;

public class GameApiServiceMock implements GameApiService {

  private final Map<Category, List<Question>> questionMap = new HashMap<>();
  private final List<Player> players = new ArrayList<>();
  private final List<Category> categories = new ArrayList<>();

  // TODO Insert Booleans here to set if should throw exception.
  private boolean authorized = true;

  @Override
  public QuestionResponse requestGame(Category category, int nbrOfQuestions) throws Exception {
    List<Question> questions = questionMap.get(category);
    boolean last = false;
    if (questions == null) {
      throw new Exception("404 no questions with " + category + " found");
    }
    if(!authorized) {
      throw new Exception("401 unanthorized");
    }
    last = (nbrOfQuestions - questions.size()) <= 0; // TODO Check this requirement again.
    return new QuestionResponse(questions, last);
  }

  @Override
  public QuestionResponse requestGame(Category category) throws Exception {
    return requestGame(category, 10);
  }

  @Override
  public HighscoreResponse requestHighScore() {

  }

  @Override
  public RequestResponse requestCategories() {

  }

  @Override
  public RequestResponse postScore(int score, Category category) {

  }
}
