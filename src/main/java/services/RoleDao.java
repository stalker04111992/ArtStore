package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@LocalBean
@Stateless
public class RoleDao
{
    @PersistenceContext(unitName = "Art")
    private EntityManager em;

    /*public void save(Role role)
    {
        em.persist(role);
    }*/

    public List find(int id) {
        return em.createQuery(
                "SELECT c FROM roles c WHERE c.userId = :id")
                .setParameter("id", id)
                .getResultList();
    }

}
