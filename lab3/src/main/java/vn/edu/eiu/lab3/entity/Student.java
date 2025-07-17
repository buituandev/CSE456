package vn.edu.eiu.lab3.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_Student")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StudentId", nullable = false)
    private long id;

    @Column(name = "FullName", nullable = false, columnDefinition = "NVARCHAR(50)")
    private String fullName;

    @Enumerated
    @Column(name = "Gender")
    private Gender gender;

    @Column(name = "Dob")
    private LocalDate dateOfBirth;

    @Column(name = "EnrollmentYear")
    private int enrollmentYear;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MajorId")
    private Major major;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SchoolId", nullable = false)
    private School school;

    public Student(String fullName, Gender gender, LocalDate dateOfBirth, int enrollmentYear) {
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.enrollmentYear = enrollmentYear;
    }

    public void setMajor(Major major) {
        this.major = major;
        if (major != null) {
            major.getSchool().addStudent(this);
        }
    }
}
