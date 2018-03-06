package api;

public class HighscoreResponse {

  private String name;
  private int score;
  private String category;

  public HighscoreResponse(String name, int score, String category) {
    this.name = name;
    this.score = score;
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public String getCategory() {
    return category;
  }
}
