package model;

/**
 * A Question belongs to a category, has an id and content and a answer.
 * @author Patrik Larsson.
 */
public class Question {
  private final String textContent;
  private final Answer answer;
  private final long id;

  public Question(String textContent, Answer answer, long id) {
    this.textContent = textContent;
    this.answer = answer;
    this.id = id;
  }

  public String getTextContent() {
    return textContent;
  }

  public Answer getAnswer() {
    return answer;
  }

  public long getId() {
    return id;
  }
}
