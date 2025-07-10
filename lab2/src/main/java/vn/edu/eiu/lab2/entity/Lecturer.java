package vn.edu.eiu.lab2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "Lecturers")
public class Lecturer {
    @Id
    @Column(columnDefinition = "BIGINT", name = "ID")
    private Long id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Year_of_Birth", nullable = false)
    private int yob;
    
    @Column(name = "Salary")
    private double salary;
}
