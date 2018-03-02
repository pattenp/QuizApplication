package api;

import java.util.List;
import model.Category;
import model.Player;
import model.Question;

public class GameApiServiceMock implements GameApiService {

  @Override
  public List<Question> requestGame(Category category, int nbrOfQuestions) {
    return null;
  }

  @Override
  public List<Player> requestHighScore() {
    return null;
  }

  @Override
  public List<Category> requestCategories() {
    return null;
  }

  @Override
  public void postScore(int score, Category category) {

  }
}
