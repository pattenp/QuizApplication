package api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import model.Answer;
import model.Category;
import model.HighScore;
import model.Question;

public class ApiServiceMock {

  private long current_answerID   = 0;
  private long currentCategoryID  = 0;
  private long currentHighscoreID = 0;
  private long currentQuestionID  = 0;

  private HashMap<Category, List<Question>>  questionMap  = new HashMap<>();
  private HashMap<Long, Category>            categoryMap  = new HashMap<>();
  private HashMap<Long, Answer>              answerMap    = new HashMap<>();
  private HashMap<Category, List<HighScore>> highscoreMap = new HashMap<>();

  private boolean shouldGive404Error = false;
  private boolean shouldGive409Error = false;
  //private boolean shouldGive404Error = false;
  //private boolean shouldGive404Error = false;

  public ApiServiceMock() {
    init();
  }

  public List<Category> getAllCategories() {
    List<Category> categories = new ArrayList<>();
    throwIfSet();
    Set<Long> keys = categoryMap.keySet();
    for (Long key : keys) {
      Category category = categoryMap.get(key);
      categories.add(category);
    }
    return categories;
  }

  public List<Question> getQuestionByCategoryName(String name, int limit) {
    throwIfSet();
    boolean        categoryFound = false;
    Category       categoryToUse = null;
    List<Category> categories    = getAllCategories();
    for (Category c : categories) {
      if (c.getName().equals(name)) {
        categoryFound = true;
        categoryToUse = c;
        break;
      }
    }
    if (!categoryFound) {
      // TODO Throw 404
    }
    List<Question> allQuestionsInCategory = questionMap.get(categoryToUse);
    if (limit == 0) {
      if (allQuestionsInCategory.size() < 10) {
        limit = allQuestionsInCategory.size();
      } else {
        limit = 10;
      }
      List<Question> questionsToUse = new ArrayList<>();
      for (int i = 0; i < limit; i++) {
        questionsToUse.add(allQuestionsInCategory.get(i));
      }
      return questionsToUse;
    } else if (limit <= 30) {
      if (allQuestionsInCategory.size() < limit) {
        limit = allQuestionsInCategory.size();
      }
      List<Question> questionsToUse = new ArrayList<>();
      for (int i = 0; i < limit; i++) {
        questionsToUse.add(allQuestionsInCategory.get(i));
      }
      return questionsToUse;
    }
    throw new IllegalArgumentException("Limit should not be larger than 30");
  }

  public AnswerWrapper getAnswerByQuestionId(Long questionId) throws Exception {
    throwIfSet();
    Set<Category> keys          = questionMap.keySet();
    boolean       questionFound = false;
    Question      question      = null;
    for (Category key : keys) {
      List<Question> questionsInCategory = questionMap.get(key);
      for (int i = 0; i < questionsInCategory.size(); i++) {
        if (questionsInCategory.get(i).getId() == questionId) {
          questionFound = true;
        }
      }
    }
    if (questionFound) {
      List<Answer> candidateAnswers   = question.getCandidateAnswers();
      List<Long>   candidateAnswersId = new ArrayList<>();
      int          correctAnswer      = -1;
      for (int i = 0; i < candidateAnswers.size(); i++) {
        candidateAnswersId.add(candidateAnswers.get(i).getId());
        if (candidateAnswers.get(i).getId() == question.getCorrectAnswer().getId()) {
          correctAnswer = i;
        }
      }
      AnswerWrapper wrapper = new AnswerWrapper(candidateAnswers, correctAnswer);
      return wrapper;
    }
    throw new Exception("404 question not found"); // TODO changed to custom exceptiom
  }

  public List<HighScore> getHighscoreByCategoryName(String categoryName) throws Exception {
    List<Category> categories    = getAllCategories();
    boolean        categoryFound = false;
    for (Category c : categories) {
      if (c.getName().equals(categoryName)) {
        categoryFound = true;
        return highscoreMap.get(c);
      }
    }
    throw new Exception("404 category not found"); // TODO Switch to custom businessexception.
  }

  private void throwIfSet() {

  }

  private void init() {

    // Create Answers from 0-100
    for (int i = 0; i < 101; i++) {
      createAnswer(String.valueOf(i));
    }

    // Create Category Addiotion and Subtraction
    createCategory("Addition");
    createCategory("Subtraction");

    // Create 15 Addition questions
    Question question = null;
    question = createQuestion("Vad är 1 + 1", categoryMap.get(0L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 2L);
    question = createQuestion("Vad är 1 + 2", categoryMap.get(0L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 3L);
    question = createQuestion("Vad är 1 + 3", categoryMap.get(0L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 4L);
    question = createQuestion("Vad är 1 + 4", categoryMap.get(0L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 5L);
    question = createQuestion("Vad är 1 + 5", categoryMap.get(0L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 6L);
    question = createQuestion("Vad är 1 + 6", categoryMap.get(0L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 7L);
    question = createQuestion("Vad är 1 + 7", categoryMap.get(0L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 8L);
    question = createQuestion("Vad är 1 + 8", categoryMap.get(0L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 9L);
    question = createQuestion("Vad är 1 + 9", categoryMap.get(0L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 10L);
    question = createQuestion("Vad är 1 + 10", categoryMap.get(0L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 11L);
    question = createQuestion("Vad är 1 + 11", categoryMap.get(0L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 12L);
    question = createQuestion("Vad är 1 + 12", categoryMap.get(0L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 13L);
    question = createQuestion("Vad är 1 + 13", categoryMap.get(0L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 14L);
    question = createQuestion("Vad är 1 + 14", categoryMap.get(0L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 15L);
    question = createQuestion("Vad är 1 + 15", categoryMap.get(0L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 16L);

    // Create 15 Subtraction QUestions
    question = createQuestion("Vad är 15 - 1", categoryMap.get(1L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 14L);
    question = createQuestion("Vad är 14 - 1", categoryMap.get(1L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 13L);
    question = createQuestion("Vad är 13 - 1", categoryMap.get(1L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 12L);
    question = createQuestion("Vad är 12 - 1", categoryMap.get(1L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 11L);
    question = createQuestion("Vad är 11 - 1", categoryMap.get(1L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 10L);
    question = createQuestion("Vad är 10 - 1", categoryMap.get(1L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 9L);
    question = createQuestion("Vad är 9 - 1", categoryMap.get(1L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 8L);
    question = createQuestion("Vad är 8 - 1", categoryMap.get(1L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 7L);
    question = createQuestion("Vad är 7 - 1", categoryMap.get(1L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 6L);
    question = createQuestion("Vad är 6 - 1", categoryMap.get(1L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 5L);
    question = createQuestion("Vad är 5 - 1", categoryMap.get(1L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 4L);
    question = createQuestion("Vad är 4 - 1", categoryMap.get(1L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 3L);
    question = createQuestion("Vad är 3 - 1", categoryMap.get(1L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 2L);
    question = createQuestion("Vad är 2 - 1", categoryMap.get(1L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 1L);
    question = createQuestion("Vad är 1 - 1", categoryMap.get(1L));
    setCandidateAnswersIdAndCorrectAnswerId(question, 0L);

    // Create Highscore
    createHighScore("Patrik", categoryMap.get(0L), 3);
    createHighScore("Nico", categoryMap.get(0L), 5);
    createHighScore("Dainel", categoryMap.get(1L), 4);
  }

  private void setCandidateAnswersIdAndCorrectAnswerId(Question question, Long correctAnswerId) {
    List<Answer> candidateAnswers = new ArrayList<>(4);
    Answer       candidate1       = answerMap.get(99L);
    Answer       candidate2       = answerMap.get(98L);
    Answer       candidate3       = answerMap.get(97L);
    Answer       correctCandidate = answerMap.get(correctAnswerId);
    candidateAnswers.add(candidate1);
    candidateAnswers.add(candidate2);
    candidateAnswers.add(candidate3);
    candidateAnswers.add(correctCandidate);
    question.setCandidateAnswers(candidateAnswers);
    question.setCorrectAnswer(correctCandidate);
  }

  private void createCategory(String name) {
    Category category = new Category();
    category.setName(name);
    category.setId(currentCategoryID++);
    categoryMap.put(category.getId(), category);
    ArrayList<Question> arrayList = new ArrayList<>();
    questionMap.put(category, arrayList);
    highscoreMap.put(category, new ArrayList<HighScore>());
  }

  private Question createQuestion(String content, Category category) {
    Question question = new Question();
    question.setId(currentQuestionID++);
    question.setContent(content);
    addQuestion(question, category.getId());
    return question;
  }

  private void addQuestion(Question question, long categoryId) {
    List<Question> questionList = questionMap.get(categoryMap.get(categoryId));
    questionList.add(question);
  }

  private void createAnswer(String content) {
    Answer answer = new Answer();
    answer.setContent(content);
    answer.setId(current_answerID++);
    answerMap.put(answer.getId(), answer);
  }

  private void createHighScore(String name, Category category, int score) {
    HighScore highscore = new HighScore();
    highscore.setCategory(category);
    highscore.setId(currentHighscoreID++);
    highscore.setScore(score);
    highscore.setName(name);
    addHighScore(highscore, category);
  }

  private void addHighScore(HighScore score, Category category) {
    highscoreMap.get(category).add(score);
  }
}
