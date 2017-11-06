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
    public ModuleOppgave getModuleOppgave(String id) {
        return em.find(ModuleOppgave.class, id);
    }

    @Override
    public boolean saveModuleOppgave(ModuleOppgave m){
        ModuleOppgave existing = getModuleOppgave(m.getNavn());
        if  (existing == null){
            em.persist(m);
        } else{
            return false;
        }
        return true;
    }
    
    @Override
    public boolean updateModuleOppgave(ModuleOppgave m){
        ModuleOppgave existing = getModuleOppgave(m.getNavn());
        if  (existing == null){
            em.merge(m);
        } else{
            return false;
        }
        return true;
        }
    }
