package vn.edu.eiu.theo7.fecse4562131200024demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.theo7.fecse4562131200024demo.model.Student;
import vn.edu.eiu.theo7.fecse4562131200024demo.repo.StudentRepo;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    
    public void saveStudent(Student student) {
        studentRepo.save(student);
    }
    
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
    
    public Student getStudentById(String id) {
        return studentRepo.findById(id).orElseThrow();
    }
    
    public void deleteStudentById(String id) {
        studentRepo.deleteById(id);
    }
    
    public List<Student> searchStudentsByName(String keyword) {
        return studentRepo.searchAllByNameContainingIgnoreCase(keyword);
    }
    
    // Method to check id exists or not
    public boolean isIdExist(String id) {
        return studentRepo.existsById(id);
    }
}
