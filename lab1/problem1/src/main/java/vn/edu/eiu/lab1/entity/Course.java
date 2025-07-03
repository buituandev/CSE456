package vn.edu.eiu.lab1.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@Data
public class Course {
    private String idCourse;
    private String name;
    private int credits;
    private double hour;
}