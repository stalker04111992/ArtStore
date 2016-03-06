package services;


import entities.User;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@LocalBean
public class UserDao
{
    @PersistenceContext(unitName = "Art")
    private EntityManager em;

    public void save(User user)
    {
        em.persist(user);
    }

    public User findByUsername(String username)
    {
        List users = em.createQuery(
                "SELECT c FROM users c WHERE c.username = :username")
                .setParameter("username", username)
                .getResultList();

        return users.size() > 0 ?  (User)users.get(0) : null;
    }

    public List findAll() {
        return em.createQuery("select u from users u").getResultList();
    }

}
