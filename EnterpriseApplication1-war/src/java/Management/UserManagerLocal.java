
package Management;

import users.User;
import javax.ejb.Local;
/**
 *
 * @author sindrethompson
 */
@Local
public interface UserManagerLocal {
    User getUser(String id);
    boolean saveUser(User u);
    boolean updateUser(User u);
}
