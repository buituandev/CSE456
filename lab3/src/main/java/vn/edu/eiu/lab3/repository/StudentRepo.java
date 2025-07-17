package vn.edu.eiu.lab3.repository;

import jakarta.persistence.EntityManager;
import vn.edu.eiu.lab3.entity.Student;
import vn.edu.eiu.lab3.infra.JpaUtil;

import java.util.List;

public class StudentRepo {
    public static void save(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    public static void update(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }

    public static void remove(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(student)) {
            student = em.find(Student.class, student.getId());
        }
        if (student != null) {
            em.remove(student);
        }
        em.getTransaction().commit();
        em.close();
    }

    public static Student findById(long studentId) {
        EntityManager em = JpaUtil.getEntityManager();
        Student student = em.find(Student.class, studentId);
        em.close();
        return student;
    }

    public static List<Student> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Student> students = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        em.close();
        return students;
    }

    public static List<Student> findByName(String studentName) {
        EntityManager em = JpaUtil.getEntityManager();
        var students = em.createQuery("SELECT s FROM Student s WHERE s.fullName LIKE :name", Student.class)
                .setParameter("name", "%" + studentName + "%")
                .getResultList();
        em.close();
        return students;
    }
}
