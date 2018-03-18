package api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import model.Category;
import model.HighScore;
import model.Question;

public interface ApiService {

  List<Category> getAllCategories() throws IOException;

  List<Question> getQuestionsByCategoryName(String name, int limit)
      throws IOException, URISyntaxException;

  AnswerWrapper getAnswerByQuestionId(Long questionId) throws Exception;

  List<HighScore> getHighscoreByCategoryName(String categoryName) throws Exception;
}
