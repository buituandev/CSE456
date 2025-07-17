package vn.edu.eiu.lab3.service;

import vn.edu.eiu.lab3.entity.Student;
import vn.edu.eiu.lab3.repository.StudentRepo;

import java.util.List;

public class StudentService {
    public void createStudent(Student student) {
        StudentRepo.save(student);
    }

    public void updateStudent(Student student) {
        StudentRepo.update(student);
    }

    public void deleteStudent(Student student) {
        StudentRepo.remove(student);
    }

    public Student getStudentById(long studentId) {
        return StudentRepo.findById(studentId);
    }

    public List<Student> getAllStudents() {
        return StudentRepo.findAll();
    }

    public List<Student> findStudentsByName(String name) {
        return StudentRepo.findByName(name);
    }

}
