package vn.edu.eiu.lab2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    @Id
    @Column(name = "ID",columnDefinition = "CHAR(10)")
    private String id;
    
    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;
    
    @Column(name = "Year_of_Birth", nullable = false)
    private int yob;
    
    @Column(name = "Gpa")
    private double gpa;
}
