package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import model.Answer;
import model.Category;
import model.HighScore;
import model.Question;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * An implementation of the ApiService interface. This implementation fetches data from a restful api. The method calls
 * on this class should be called on a different thread than the ui since these methods can be long running.
 *
 * @author Patrik Larsson
 */
public class ApiServiceImpl implements ApiService {

  /**
   * Returns all categories in a list from the api. The list can be empty if there are no categories defined.
   *
   * @return A List with all of the available categories.
   */
  @Override public List<Category> getAllCategories() throws IOException {
    URL url = new URL("http://localhost:8080/api/1/category/");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    ArrayList<Category> categories = new ArrayList<Category>();
    connection.setRequestMethod("GET");

    int respCode = connection.getResponseCode();
    if (respCode == HttpURLConnection.HTTP_OK) {
      BufferedReader buffReader =
          new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();

      while ((inputLine = buffReader.readLine()) != null) {
        response.append(inputLine);
      }
      JSONArray arr = new JSONArray(response.toString());
      System.out.println("stop");

      for (int i = 0; i < arr.length(); i++) {
        JSONObject obj = arr.getJSONObject(i);
        Category category = new Category();
        category.setName(obj.getString("name"));
        category.setId(obj.getLong("id"));
        categories.add(category);
      }
    } else {
      // TODO Throw Exception.
    }
    return categories;
  }

  /**
   * Returns all questions of a given category.
   *
   * @param name A String with the name of the category
   * @param limit A int with the number of questions. If 0 10 questions should be returned. At max 30 questions can be
   * returned.
   * @return A List with questions.
   */
  @Override public List<Question> getQuestionsByCategoryName(String name, int limit)
      throws IOException, URISyntaxException {
    //  URL               url        = new URL("http://localhost:8080/api/1/question?categoryName=" + name);
    URI uri = new URI("http://localhost:8080/api/1/question?categoryName=Matte+A");
    URL newURL = uri.toURL();
    URL url = new URL("http://localhost:8080/api/1/question?categoryName=Matte" + "\u00A0A");
    HttpURLConnection connection = (HttpURLConnection) newURL.openConnection();
    connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
    List<Question> questions = new ArrayList<>();
    connection.setRequestMethod("GET");
    int respCode = connection.getResponseCode();
    if (respCode == HttpURLConnection.HTTP_OK) {
      BufferedReader buffReader =
          new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();

      while ((inputLine = buffReader.readLine()) != null) {
        response.append(inputLine);
      }

      JSONArray arr = new JSONArray(response.toString());
      for (int i = 0; i < arr.length(); i++) {
        JSONObject obj = arr.getJSONObject(i);
        Question question = new Question();
        question.setId(obj.getLong("id"));
        question.setContent(obj.getString("content"));
        // Fetch as array
        JSONArray candAns = obj.getJSONArray("candidateAnswers");
        List<Answer> candidateAnswers = new ArrayList<>();
        for (int j = 0; j < candAns.length(); j++) {
          Answer candidateAnswer = new Answer();
          candidateAnswer.setId(candAns.getJSONObject(j).getLong("id"));
        }
        question.setCandidateAnswers(candidateAnswers);
        Answer correctAnswer = new Answer();
        JSONObject jsonCorrectAnswer = obj.getJSONObject("correctAnswer");
        correctAnswer.setId(jsonCorrectAnswer.getLong("id"));
        correctAnswer.setContent(jsonCorrectAnswer.getString("content"));
        question.setCorrectAnswer(correctAnswer);
        questions.add(question);
      }
    } else {
      // TODO Throw new Exception.
    }
    return questions;
  }

  /**
   * Returns a AnswerWrapper which contains a list with all candidate answers and a index with the correct answer.
   *
   * @param questionId A Long with the id of the question to get the answers from.
   * @return A answerwrapper instance.
   * @throws Exception Throws a exception if the http request returns 404 status code.
   */
  @Override public AnswerWrapper getAnswerByQuestionId(Long questionId) throws Exception {
    String strURL = "http://localhost:8080/api/1/answer?id=" + questionId;
    URI uri = new URI(strURL);
    URL url = uri.toURL();
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    int respCode = connection.getResponseCode();
    if (respCode == HttpURLConnection.HTTP_OK) {
      BufferedReader buffReader =
          new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();

      while ((inputLine = buffReader.readLine()) != null) {
        response.append(inputLine);
      }

      JSONObject jsonObj = new JSONObject(response.toString());
      JSONArray jsonArr = jsonObj.getJSONArray("candidateAnswers");
      List<Answer> candidateAnswers = new ArrayList<Answer>();

      for (int i = 0; i < jsonArr.length(); i++) {
        JSONObject nextJSON = jsonArr.getJSONObject(i);
        Answer answer = new Answer();
        answer.setId(nextJSON.getLong("id"));
        answer.setContent(nextJSON.getString("content"));
        candidateAnswers.add(answer);
      }

      int correctIndex = jsonObj.getInt("correctAnswer");
      AnswerWrapper wrapper = new AnswerWrapper(candidateAnswers, correctIndex);
      return wrapper;
    } else {
      throw new Exception("Answers not found");
    }
  }

  /**
   * Returns a list with highscores for a given category from the api.
   *
   * @param categoryName A String with the name of the categoy.
   * @return A list with highscores for a given category.
   * @throws Exception Throws a exception if the httprequest returns with status code 404.
   */
  @Override public List<HighScore> getHighscoreByCategoryName(String categoryName)
      throws Exception {
    List<HighScore> highScores = new ArrayList<HighScore>();
    String strUrl = "http://localhost:8080/api/1/highscore?category=" + categoryName;
    URI uri = new URI(strUrl);
    URL url = uri.toURL();
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");

    int respCode = connection.getResponseCode();
    if (respCode == HttpURLConnection.HTTP_OK) {
      BufferedReader buffReader =
          new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();

      while ((inputLine = buffReader.readLine()) != null) {
        response.append(inputLine);
      }

      JSONArray jsonArr = new JSONArray(response.toString());
      for (int i = 0; i < jsonArr.length(); i++) {
        JSONObject nextJSON = jsonArr.getJSONObject(i);
        HighScore highScore = new HighScore();
        highScore.setId(nextJSON.getLong("id"));
        highScore.setName(nextJSON.getString("name"));
        highScore.setScore(nextJSON.getInt("score"));

        JSONObject jsonCategory = nextJSON.getJSONObject("category");
        Category category = new Category();
        category.setId(jsonCategory.getLong("id"));
        category.setName(jsonCategory.getString("name"));

        highScore.setCategory(category);
        highScores.add(highScore);
      }
      return highScores;
    } else {
      throw new Exception("404 not found");
    }
  }
}
