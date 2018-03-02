package api;

import java.util.List;
import model.Category;
import model.Player;
import model.Question;

/**
 * Methods for communicating with the Api. The user should be authenticated to do all of the requests except for the
 * authentication method.
 *
 * @author Patrik Larsson
 */
public interface GameApiService {

  /**
   * Returns a list with question. The length of the list will be the value of nbrOfQuestions if there are that many
   * questions. If not it will be the number of questions available.
   *
   * @param category A reference to a category.
   * @return A List of questions.
   */
  List<Question> requestGame(Category category, int nbrOfQuestions);

  /**
   * Returns a list of players with the highest score.
   *
   * @return A List with most 10 players that have the highest score.
   */
  List<Player> requestHighScore();

  /**
   * Returns a list with all the categories in the api.
   *
   * @return All categorys that are available from the api.
   */
  List<Category> requestCategorys();


  /**
   * Posts the score of the player. If the player already have a score it should update the current score.
   *
   * @param score    The score of the player.
   * @param category The category the score was acquired in.
   */
  void postScore(int score, Category category);
}
