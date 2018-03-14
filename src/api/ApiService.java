package api;

import java.util.List;
import model.Category;
import model.HighScore;
import model.Question;

public interface ApiService {

  List<Category> getAllCategories();

  List<Question> getQuestionByCategoryName(String name, int limit);

  AnswerWrapper getAnswerByQuestionId(Long questionId) throws Exception;

  List<HighScore> getHighscoreByCategoryName(String categoryName) throws Exception;
}
