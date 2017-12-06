package Management;

import Forum.Questions;
import javax.ejb.Local;

/**
 *
 * @author stiansimonsen
 */
@Local
public interface QuestionManagerLocal {

    Questions getQuestionText(int id);

    boolean saveQuestion(Questions q);
}
