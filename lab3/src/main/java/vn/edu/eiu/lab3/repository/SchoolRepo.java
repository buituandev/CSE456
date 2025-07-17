package vn.edu.eiu.lab3.repository;

import jakarta.persistence.EntityManager;
import vn.edu.eiu.lab3.entity.School;
import vn.edu.eiu.lab3.infra.JpaUtil;

import java.util.List;

public class SchoolRepo {
    public static void save(School school) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(school);
        em.getTransaction().commit();
        em.close();
    }

    public static void update(School school) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(school);
        em.getTransaction().commit();
        em.close();
    }

    public static void remove(School school) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(school)) {
            school = em.find(School.class, school.getSchoolId());
        }
        if (school != null) {
            em.remove(school);
        }
        em.getTransaction().commit();
        em.close();
    }

    public static School findById(String schoolId) {
        EntityManager em = JpaUtil.getEntityManager();
        School school = em.find(School.class, schoolId);
        em.close();
        return school;
    }

    public static List<School> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        List<School> schools = em.createQuery("SELECT s FROM School s", School.class).getResultList();
        em.close();
        return schools;
    }

    public static List<School> findByName(String schoolName) {
        EntityManager em = JpaUtil.getEntityManager();
        var schools = em.createQuery("SELECT s FROM School s WHERE s.schoolName LIKE :name", School.class)
                .setParameter("name", "%" + schoolName + "%")
                .getResultList();
        em.close();
        return schools;
    }
}
