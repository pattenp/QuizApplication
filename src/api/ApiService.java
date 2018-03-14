package api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import model.Category;
import model.HighScore;
import model.Question;

public interface ApiService {

  List<Category> getAllCategories() throws IOException;

  List<Question> getQuestionByCategoryName(String name, int limit);

  AnswerWrapper getAnswerByQuestionId(Long questionId) throws Exception;

  List<HighScore> getHighscoreByCategoryName(String categoryName) throws Exception;
}
