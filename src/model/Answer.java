package model;

import java.io.Serializable;
import java.util.Date;

public class Answer implements Serializable {

  private Long id;

  private String content;

  private Date createdAt;

  private Date updatedAt;

  public Answer() {
  }

  public Answer(Long id) {
    this.id = new Long(id);
  }

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
