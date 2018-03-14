package logic;


import repository.PlayerRepository;
import repository.QuestionRepository;
import view.View;

/**
 * @author Patrik Larsson.
 */
public class Controller {

  private PlayerRepository playerRepository;
  private QuestionRepository questionRepository;
  private View view;

  /**
   * Initializes the object with a playerRepository instance and a questionRepository instance.
   *
   * @param playerRepository   A Reference to a implementation of the PlayerRepository class.
   * @param questionRepository A Reference to a implementation of the QuestionRepository class.
   * @param view               A reference to a view instance.
   */
  public Controller(PlayerRepository playerRepository,
      QuestionRepository questionRepository, View view) {

    this.playerRepository = playerRepository;
    this.questionRepository = questionRepository;
    this.view = view;
  }
}
