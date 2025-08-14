package vn.edu.eiu.theo7.fecse4562131200024demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_Major")
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;
    
    @Column(name = "Name", nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;
    
    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "major")
    private List<Student> studentList = new ArrayList<>();
    
    public void addStudent(Student student) {
        studentList.add(student);
        student.setMajor(this);
    }
    
    public void removeStudent(Student student) {
        studentList.remove(student);
        student.setMajor(null);
    }
    
    public Major(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
