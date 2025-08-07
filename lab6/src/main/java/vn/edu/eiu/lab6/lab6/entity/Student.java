package vn.edu.eiu.lab6.lab6.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
//Neu table co key tu dong thi phai them mot constructor day du tham so nhung bo tham so key di
public class Student {
    //Neu id la key tu tang thi khong co trong constructor full tham so. Va nen dung kieu wrapper class long
    private int id;
    private String name;
    private int yob;
    private double gpa;
}
