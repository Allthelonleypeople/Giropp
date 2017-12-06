
package Module;

import Module.ModuleOppgave;
import javax.ejb.Local;
/**
 *
 * @author sindrethompson
 */
@Local
public interface ModuleManagerLocal {
    ModuleOppgave getModuleOppgave(int id);
    boolean saveModuleOppgave(ModuleOppgave m);
}
