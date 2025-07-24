package vn.edu.eiu.lab3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_School")
public class School {
    @Id
    @Column(name = "SchoolId", nullable = false, columnDefinition = "CHAR(3)")
    private String schoolId;

    @Column(name = "SchoolName", nullable = false, columnDefinition = "VARCHAR(100)")
    private String schoolName;

    @Column(name = "Location", columnDefinition = "VARCHAR(100)")
    private String location;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "school")
    private List<Student> students = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "school")
    private List<Major> majors = new ArrayList<>();

    public School(String schoolId, String schoolName, String location) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.location = location;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setSchool(this);
    }

    public void addMajor(Major major) {
        majors.add(major);
        major.setSchool(this);
    }
}
