package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import model.Category;
import model.HighScore;
import model.Question;

/**
 * An implementation of the ApiService interface. This implementation fetches data from a restful api. The method calls
 * on this class should be called on a different thread than the ui since theese methods can be long running.
 *
 * @author Patrik Larsson
 */
public class ApiServiceImpl implements ApiService {

  /**
   * Returns all categories in a list from the api. The list can be empty if there are no categories defined.
   *
   * @return A List with all of the available categories.
   */
  @Override
  public List<Category> getAllCategories() throws IOException {
    URL               url        = new URL("http://localhost:8080/api/1/category/");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    connection.setRequestMethod("GET");

    int respCode = connection.getResponseCode();
    if (respCode == HttpURLConnection.HTTP_OK) {
      BufferedReader buffReader = new BufferedReader(
          new InputStreamReader(
              connection.getInputStream())
      );
      String       inputLine;
      StringBuffer response = new StringBuffer();

      while ((inputLine = buffReader.readLine()) != null) {
        response.append(inputLine);
      }
      JSONObject jsonObject = new JSONObject();
    }


  }

  /**
   * Returns all questions of a given category.
   *
   * @param name  A String with the name of the category
   * @param limit A int with the number of questions. If 0 10 questions should be returned. At max 30 questions can be
   *              returned.
   * @return A List with questions.
   */
  @Override
  public List<Question> getQuestionByCategoryName(String name, int limit) {
    return null;
  }

  /**
   * Returns a AnswerWrapper which contains a list with all candidate answers and a index with the correct answer.
   *
   * @param questionId A Long with the id of the question to get the answers from.
   * @return A answerwrapper instance.
   * @throws Exception Throws a exception if the http request returns 404 status code.
   */
  @Override
  public AnswerWrapper getAnswerByQuestionId(Long questionId) throws Exception {
    return null;
  }

  /**
   * Returns a list with highscores for a given category from the api.
   *
   * @param categoryName A String with the name of the categoy.
   * @return A list with highscores for a given category.
   * @throws Exception Throws a exception if the httprequest returns with status code 404.
   */
  @Override
  public List<HighScore> getHighscoreByCategoryName(String categoryName) throws Exception {
    return null;
  }
}
