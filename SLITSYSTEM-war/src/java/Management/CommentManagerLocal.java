package Management;

import Forum.Comments;
import javax.ejb.Local;

/**
 *
 * @author stiansimonsen
 */
@Local
public interface CommentManagerLocal {

    Comments getQuestionComment(int id);

    boolean saveComment(Comments c);
}
