package vn.edu.eiu.lab2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import vn.edu.eiu.lab2.entity.Lecturer;
import vn.edu.eiu.lab2.entity.Student;
import vn.edu.eiu.lab2.entity.Subject;

import java.util.List;

public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1-mysql-masterapp");

    public static void main(String[] args) {
//        insertStudent();
//        getStudentById();
//        getAllStudents();
//        getStudentByGpa();
//        updateBirthYearById();
//        updateGPAById();
//        getStudentByConditions("Nguyen Van", 3.8);
//        deleteStudentById();
        insertLecturer();
        insertSubject();
    }

    // Delete (DML: Data Manipulation Language) - Xóa sinh viên theo ID
    public static void deleteStudentById() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, "CSE2025002");
        entityManager.remove(student); // Xóa sinh viên
        System.out.println("Deleted student: " + student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    //Tìm kiếm sinh viên theo nhiều điều kiện (sinh viên co ten pName, pGpa)
    public static void getStudentByConditions(String Name, double Gpa) {
        EntityManager entityManager = emf.createEntityManager();
        List<Student> students = entityManager.createQuery("SELECT s FROM Student s WHERE s.name LIKE :pName or s.gpa> :pGPA", Student.class)
                .setParameter("pName", "%" + Name + "%")
                .setParameter("pGPA", Gpa)
                .getResultList();
        System.out.println("List of students with name like " + Name + " or GPA > " + Gpa + ":");
        students.forEach(System.out::println);
        entityManager.close();
    }

    //Update based on conditions


    // Update (DML: Data Manipulation Language) - Cập nhật thông tin sinh viên
    public static void updateGPAById() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        // Tìm kiếm sinh viên theo ID
        Student student = entityManager.find(Student.class, "CSE2025002");
        // Cập nhật gpa sinh viên
        student.setGpa(3.8);
        entityManager.getTransaction().commit();
        System.out.println("Updated student: " + student);

        entityManager.close();
    }

    public static void updateBirthYearById() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        // Tìm kiếm sinh viên theo ID
        Student student = entityManager.find(Student.class, "CSE2025002");
        // Cập nhật năm sinh của sinh viên
        student.setYob(2009);
        entityManager.getTransaction().commit();
        System.out.println("Updated student: " + student);

        entityManager.close();
    }

    public static void getStudentByGpa() {
        EntityManager entityManager = emf.createEntityManager();
        List<Student> students = entityManager.createQuery("SELECT s FROM Student s WHERE s.gpa > 3.5", Student.class).getResultList();
        System.out.println("List of students with GPA > 3.5:");
        students.forEach(System.out::println);
        entityManager.close();
    }

    public static void getAllStudents() {
        /*
         * Khi viết truy vấn select thì có thể dùng các loại cú pháp sau:
         *  SQL native query: SELECT * FROM Students
         *  HQL được chỉnh sửa bới Hibernate
         *  JPQL dược chỉnh sửa bởi JPA lệnh truy vấn theo kiểu OOP
         */
        EntityManager em = emf.createEntityManager();
        List<Student> students = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        System.out.println("List of students:");
        for (Student student : students) {
            System.out.println(student);
        }
        em.close();
    }

    public static void getStudentById() {
        /*
         *The EntityManagerFactory (EMF) is a heavyweight,
         * thread-safe object designed to manage the configuration and connection to the database.
         * It is expensive to create and should be instantiated once per application
         */
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, "CSE2025002");
        if (student != null) {
            System.out.println("Student found: " + student);
        }
        em.close();
    }

    public static void insertStudent() {
        // Tạo một EntityManager để quản lý các thực thể
        EntityManager em = emf.createEntityManager();

        // Tạo một đối tượng Student để lưu vào cơ sở dữ liệu
        Student std1 = new Student("CSE2025002", "Nguyen Van D", 2000, 3.5);
        Student std2 = new Student("CSE2025003", "Nguyen Van B", 2003, 4);
        Student std3 = new Student("CSE2025004", "Nguyen Van C", 2004, 3.7);
        /* Khi thuc thi cac cau lenh sql dang DML (Data Manipulation Language) co lam
         *thay doi du lieu thuc thi bat buoc phai dat trong 1 transaction
         *de dam bao tinh ACID (Atomicity, Consistency, Isolation, Durability): Một là thực thi
         *câu lệnh từ đầu đến cuối, còn ngược lại không làm gì cả, rollback
         * */
        em.getTransaction().begin();
        em.persist(std1); // Ghi xuống database nhưng chưa thực hiện ghi
        em.persist(std2);
        em.persist(std3);
        em.getTransaction().commit(); // Thực hiện ghi xuống database nếu không thành công thì 
        // sẽ rollback lại toàn bộ các thay đổi
        em.close(); // Đóng kết nối
    }

    public static void insertLecturer() {
        EntityManager em = emf.createEntityManager();

        Lecturer lecturer = new Lecturer(1L, "Tran Van A", 1980, 50000);
        Lecturer lecturer2 = new Lecturer(2L, "Le Van B", 1985, 60000);
        Lecturer lecturer3 = new Lecturer(3L, "Le Thi C", 1990, 55000);

        em.getTransaction().begin();
        em.persist(lecturer);
        em.persist(lecturer2);
        em.persist(lecturer3);
        em.getTransaction().commit();
        em.close();
    }

    public static void insertSubject() {
        EntityManager em = emf.createEntityManager();

        Subject subject1 = new Subject("CSE101", "Introduction to Computer Science", "Basic concepts of computer science", 3, 40);
        Subject subject2 = new Subject("CSE102", "Data Structures", "Fundamentals of data structures", 4, 60);
        Subject subject3 = new Subject("CSE103", "Algorithms", "Introduction to algorithms and complexity", 3, 50);

        em.getTransaction().begin();
        em.persist(subject1);
        em.persist(subject2);
        em.persist(subject3);
        em.getTransaction().commit();
        em.close();
    }
}