package api;

import java.util.List;
import model.Question;

public class QuestionResponse {
  private List<Question> questions;
  private boolean last;

  public QuestionResponse(List<Question> questions, boolean last) {
    this.questions = questions;
    this.last = last;
  }

  public List<Question> getQuestions() {
    return questions;
  }

  public boolean isLast() {
    return last;
  }
}
