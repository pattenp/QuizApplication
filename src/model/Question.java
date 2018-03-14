package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Question implements Serializable {

  public Question() {

  }

  private Long id;

  private String content;

  private Answer correctAnswer;

  private List<Answer> candiateAnswers;

  private List<Category> categories;

  private Date createdAt;

  private Date updatedAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Answer getCorrectAnswer() {
    return correctAnswer;
  }

  public void setCorrectAnswer(Answer correctAnswer) {
    this.correctAnswer = correctAnswer;
  }

  public List<Answer> getCandiateAnswers() {
    return candiateAnswers;
  }

  public void setCandiateAnswers(List<Answer> candiateAnswers) {
    this.candiateAnswers = candiateAnswers;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
}
