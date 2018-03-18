package api;

import java.util.List;
import model.Answer;

public class AnswerWrapper {
  List<Answer> candidateAnswersId;
  int        correctAnswerIndex;

  public AnswerWrapper(List<Answer> candidateAnswersId, int correctAnswerIndex) {
    this.candidateAnswersId = candidateAnswersId;
    this.correctAnswerIndex = correctAnswerIndex;
  }

  public void setCandidateAnswersId(List<Answer> candidateAnswersId) {
    this.candidateAnswersId = candidateAnswersId;
  }

  public void setCorrectAnswerIndex(int correctAnswerIndex) {
    this.correctAnswerIndex = correctAnswerIndex;
  }
}
