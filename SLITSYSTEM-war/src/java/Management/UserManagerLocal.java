
package Management;

import users.Bruker;
import javax.ejb.Local;
/**
 *
 * @author sindrethompson
 */
@Local
public interface UserManagerLocal {
    Bruker getUser(String id);
    boolean saveUser(Bruker u);
    boolean updateUser(Bruker u);
}
