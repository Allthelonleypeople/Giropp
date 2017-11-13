package Management;

//import Module.Module;
import Module.ModuleOppgave;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class ModuleManagerBean implements ModuleManagerLocal {

    @PersistenceContext
    private EntityManager em;

    public ModuleManagerBean(){
    }

    @Override
    public ModuleOppgave getModuleOppgave(int id) {
        return em.find(ModuleOppgave.class, id);
    }

    @Override
    public boolean saveModuleOppgave(ModuleOppgave m){
        ModuleOppgave existing = getModuleOppgave(m.getModuleOppgaveID());
        if  (existing == null){
            em.persist(m);
        } else{
            return false;
        }
        return true;
    }
}
    
  