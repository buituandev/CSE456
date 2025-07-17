package vn.edu.eiu.lab3;

import vn.edu.eiu.lab3.entity.Gender;
import vn.edu.eiu.lab3.entity.Major;
import vn.edu.eiu.lab3.entity.School;
import vn.edu.eiu.lab3.entity.Student;
import vn.edu.eiu.lab3.service.MajorService;
import vn.edu.eiu.lab3.service.SchoolService;
import vn.edu.eiu.lab3.service.StudentService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        School sc1 = new School("EIU", "Eastern International University", "Binh Duong");
        School sc2 = new School("HCM", "Ho Chi Minh City University", "Ho Chi Minh City");
        School sc3 = new School("HUE", "Hue University", "Thua Thien Hue");

        Major cseMajor = new Major("CSE", "Computer Science and Engineering");
        Major ebsMajor = new Major("EBS", "Business Administration and Economics");
        Major meMajor = new Major("ME", "Mechanical Engineering");

        Student s1 = new Student("Nguyen Van A", Gender.MALE, LocalDate.parse("2000-01-02"), 2020);
        Student s2 = new Student("Tran Thi B", Gender.FEMALE, LocalDate.parse("2001-01-05"), 2021);
        Student s3 = new Student("Le Van C", Gender.MALE, LocalDate.parse("2002-01-07"), 2022);
        Student s4 = new Student("Tran Van T", Gender.OTHER, LocalDate.parse("2001-01-10"), 2021);

        sc1.addMajor(cseMajor);
        sc2.addMajor(ebsMajor);
        sc3.addMajor(meMajor);

        cseMajor.addStudent(s1);
        ebsMajor.addStudent(s2);
        meMajor.addStudent(s3);
        meMajor.addStudent(s4);

        SchoolService schoolService = new SchoolService();
        schoolService.createSchool(sc1);
        schoolService.createSchool(sc2);
        schoolService.createSchool(sc3);

        MajorService majorService = new MajorService();

        StudentService studentService = new StudentService();

        Student updateS1 = studentService.findStudentsByName(s1.getFullName()).getFirst();
        sc1.setLocation("Ho Chi Minh City");
        cseMajor.setMajorName("Ky thuat phan mem");
        updateS1.setMajor(ebsMajor);

        schoolService.updateSchool(sc1);
        majorService.updateMajor(cseMajor);
        studentService.updateStudent(updateS1);

        Student deletes1 = studentService.findStudentsByName(s1.getFullName()).getFirst();
        studentService.deleteStudent(deletes1);
        majorService.deleteMajor(cseMajor);
        schoolService.deleteSchool(sc1);

        System.out.println("All Schools:");
        schoolService.getAllSchools().forEach(System.out::println);

        System.out.println("All Majors:");
        majorService.getAllMajors().forEach(System.out::println);

        System.out.println("All Students:");
        studentService.getAllStudents().forEach(System.out::println);
    }
}