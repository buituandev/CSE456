package vn.edu.eiu.theo7.fecse4562131200024demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.edu.eiu.theo7.fecse4562131200024demo.model.Major;
import vn.edu.eiu.theo7.fecse4562131200024demo.model.Student;
import vn.edu.eiu.theo7.fecse4562131200024demo.service.MajorService;

@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    MajorService  majorService;
    @Override
    public void run(String... args) throws Exception {
        Major m1 = new Major("CSE - Ky thuat phan mem","Ky thuat phan mem");
        Major m2= new Major("CSO - Dien toan dam may","Dien toan dam may");
        Student s1 = new Student("S0001", "Nguyen Anh", 2000, 90);
        Student s2 = new Student("S0002", "Nguyen Binh", 2007, 80);
        Student s3 = new Student("S0003", "Tran Chau", 2001, 85);
        Student s4 = new Student("S0004", "Le Dung", 2002, 88);
        Student s5 = new Student("S0005", "Pham Em", 2003, 92);
        Student s6 = new Student("S0006", "Hoang Phu", 2004, 75);
        Student s7 = new Student("S0007", "Vu Gia", 2005, 78);
        m1.addStudent(s1);
        m1.addStudent(s2);
        m1.addStudent(s3);
        m1.addStudent(s4);
        m1.addStudent(s5);
        m2.addStudent(s6);
        m2.addStudent(s7);
        
        majorService.saveMajor(m1);
        majorService.saveMajor(m2);
    }
}
