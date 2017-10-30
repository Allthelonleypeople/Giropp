package Management;

import users.Bruker;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class UserManagerBean implements UserManagerLocal {

    @PersistenceContext
    private EntityManager em;

    public UserManagerBean(){
    }

    @Override
    public Bruker getUser(String id) {
        return em.find(Bruker.class, id);
    }

    @Override
    public boolean saveUser(Bruker u){
        Bruker existing = getUser(u.getEmail().toLowerCase());
        if  (existing == null){
            em.persist(u);
        } else{
            return false;
        }
        return true;
    }
    
    @Override
    public boolean updateUser(Bruker u){
        Bruker existing = getUser(u.getEmail().toLowerCase());
        if  (existing == null){
            em.merge(u);
        } else{
            return false;
        }
        return true;
        }
    }
