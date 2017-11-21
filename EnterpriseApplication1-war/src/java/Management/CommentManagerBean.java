package Management;

import Forum.Comments;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CommentManagerBean implements CommentManagerLocal {

    @PersistenceContext
    private EntityManager em;

    public CommentManagerBean() {
    }

    @Override
    public Comments getQuestionComment(int id) {
        return em.find(Comments.class, id);
    }

    @Override
    public boolean saveComment(Comments c) {
        Comments existing = getQuestionComment(c.getCommentID());
        if (existing == null) {
            em.persist(c);
        } else {
            return false;
        }
        return true;
    }
}
