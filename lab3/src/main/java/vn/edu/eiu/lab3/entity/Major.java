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
@Table(name = "tbl_Major")
public class Major {
    @Id
    @Column(name = "MajorId", nullable = false, columnDefinition = "CHAR(4)")
    private String majorId;

    @Column(name = "MajorName", columnDefinition = "NVARCHAR(100)")
    private String majorName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SchoolId")
    private School school;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "major")
    private List<Student> students = new ArrayList<>();

    public Major(String majorId, String majorName) {
        this.majorId = majorId;
        this.majorName = majorName;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setMajor(this);
    }
}
