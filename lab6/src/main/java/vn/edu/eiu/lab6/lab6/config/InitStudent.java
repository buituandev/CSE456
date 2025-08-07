package vn.edu.eiu.lab6.lab6.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;
import vn.edu.eiu.lab6.lab6.entity.Student;

import java.util.ArrayList;
import java.util.List;
@Getter
@Component
public class InitStudent {
    private List<Student> studentList;

    @PostConstruct
    public void init() {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "Nguyen Van A", 2000, 90));
        studentList.add(new Student(2, "Tran Thi B", 2001, 85));
        studentList.add(new Student(3, "Le Van C", 2002, 88));
        studentList.add(new Student(4, "Pham Thi D", 2000, 92));
        studentList.add(new Student(5, "Hoang Van E", 2003, 80));
        studentList.add(new Student(6, "Vu Thi F", 2001, 95));
        studentList.add(new Student(7, "Do Van G", 2002, 78));
        studentList.add(new Student(8, "Bui Thi H", 2003, 83));
        studentList.add(new Student(9, "Ngo Van I", 2000, 87));
        studentList.add(new Student(10, "Dang Thi J", 2001, 91));
        studentList.add(new Student(11, "Trinh Van K", 2002, 89));
        System.out.println("Initialize list successful");
    }
}
