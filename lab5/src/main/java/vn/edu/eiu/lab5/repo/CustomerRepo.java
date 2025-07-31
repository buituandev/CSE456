package vn.edu.eiu.lab5.repo;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import vn.edu.eiu.lab5.entity.Customer;
import vn.edu.eiu.lab5.infra.JpaUtil;

import java.util.List;
@Repository
public class CustomerRepo {
    private static EntityManager em;

    public void save(Customer c) {
        em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
    }

    public void update(Customer c) {
        em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Customer c) {
        em = JpaUtil.getEntityManager();
        if (!em.contains(c)) {
            c = em.find(Customer.class, c.getId());
        }
        em.getTransaction().begin();
        if (c != null) {
            em.remove(c);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Customer> findAll() {
        return JpaUtil.getEntityManager().createQuery("select c from Customer c", Customer.class).getResultList();
    }
}
