package model;

/**
 * A answer has textContent, an id, and isAnswerTo a question.
 * @author Patrik Larsson
 */
public class Answer {
  private final String textContent;
  private final long id;
  private final long isAnswerTo;

  public Answer(String textContent, long id, long isAnswerTo) {
    this.textContent = textContent;
    this.id = id;
    this.isAnswerTo = isAnswerTo;
  }

  public String getTextContent() {
    return textContent;
  }

  public long getId() {
    return id;
  }

  public long getIsAnswerTo() {
    return isAnswerTo;
  }
}
