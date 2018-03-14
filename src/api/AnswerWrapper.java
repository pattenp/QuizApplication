package api;

import java.util.List;

public class AnswerWrapper {
  List<Long> candidateAnswersId;
  int        correctAnswerIndex;

  public AnswerWrapper(List<Long> candidateAnswersId, int correctAnswerIndex) {
    this.candidateAnswersId = candidateAnswersId;
    this.correctAnswerIndex = correctAnswerIndex;
  }

  public void setCandidateAnswersId(List<Long> candidateAnswersId) {
    this.candidateAnswersId = candidateAnswersId;
  }

  public void setCorrectAnswerIndex(int correctAnswerIndex) {
    this.correctAnswerIndex = correctAnswerIndex;
  }
}
