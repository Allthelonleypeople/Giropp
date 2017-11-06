
package Management;

import Module.ModuleOppgave;
import javax.ejb.Local;
/**
 *
 * @author sindrethompson
 */
@Local
public interface ModuleManagerLocal {
    ModuleOppgave getModuleOppgave(String id);
    boolean saveModuleOppgave(ModuleOppgave m);
    boolean updateModuleOppgave(ModuleOppgave m);
}
