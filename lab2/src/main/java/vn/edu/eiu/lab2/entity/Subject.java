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
@Table(name = "Subjects")
public class Subject {
    @Id
    @Column(name = "Code",columnDefinition = "CHAR(10)")
    private String code;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Description", columnDefinition = "NVARCHAR(255)")
    private String description;
    
    @Column(name = "Credits")
    private int credits;
    
    @Column(name = "Study_Hours")
    private int studyHours;
}
