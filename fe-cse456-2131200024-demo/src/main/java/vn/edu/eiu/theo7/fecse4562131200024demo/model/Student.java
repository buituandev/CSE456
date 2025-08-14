package vn.edu.eiu.theo7.fecse4562131200024demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_Student")
public class Student {
    @Id
    @Column(name = "Id", columnDefinition = "CHAR(5)")
    @Size(min = 5, max = 5, message = "Id must be 5 characters long")
    @NotBlank(message = "Id must not be blank")
    private String id;
    
    @Column(name = "Name", nullable = false, columnDefinition = "NVARCHAR(100)")
    @NotNull(message = "Name must not be null")
    @Size(min = 5, max = 100, message = "Name must be between 5 and 100 characters long")
    @Pattern(
            regexp = "^(\\p{Lu}\\p{Ll}+\\s\\p{Lu}\\p{Ll}+)+$"
            , message = "Each words must start with an uppercase letter"
    )
    private String name;
    
    @Column(name = "YearOfBirth", nullable = false)
    @Min(value = 2000, message = "Yob must be least 2000")
    @Max(value = 2007, message = "Yob must be most 2007")
    private int yob;
    
    @ManyToOne()
    @JoinColumn(name = "majorId")
    private Major major;
    
    @Min(value = 0, message = "GPA must be least 0")
    @Max(value = 100, message = "GPA must be most 100")
    @Column(name = "GPA")
    private double gpa;

    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
    }
}
