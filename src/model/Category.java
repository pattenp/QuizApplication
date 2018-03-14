package model;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable {

  private Long id;

  private String name;

  public Category(String name, Date createdAt, Date updatedAt) {
    this.name = name;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Category() {

  }

  public Category(Long id) {
    this.id = id;
  }

  private Date createdAt;

  private Date updatedAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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


