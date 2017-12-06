package Management;

import Forum.Questions;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class QuestionManagerBean implements QuestionManagerLocal {

    @PersistenceContext
    private EntityManager em;

    public QuestionManagerBean() {
    }

    @Override
    public Questions getQuestionText(int id) {
        return em.find(Questions.class, id);
    }

    @Override
    public boolean saveQuestion(Questions q) {
        Questions existing = getQuestionText(q.getQuestionID());
        if (existing == null) {
            em.persist(q);
        } else {
            return false;
        }
        return true;
    }
}
