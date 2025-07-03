package vn.edu.eiu.lab1;

import com.fasterxml.jackson.databind.ObjectMapper;
import vn.edu.eiu.lab1.entity.Course;
import vn.edu.eiu.lab1.entity.Student;

public class Main {
    public static void main(String[] args) {
        var student1 = new Student("STD001", "Mai", "Nguyen", 2007, 4.0);
        var student2 = new Student("STD002", "Minh", "Tran", 2006, 3.5);
        var student3 = new Student("STD003", "Thi", "Tran", 2007, 3.0);

        var course1 = new Course("CSE 456", "Advanced Java Programming", 4, 60);
        var course2 = new Course();
        course2.setIdCourse("CSE 303");
        course2.setName("Analysis and design of algorithms");
        course2.setCredits(4);
        course2.setHour(60);

//        System.out.println("The list of students: ");
//        System.out.println("Student 1: "+ student1);
//        System.out.println("Student 2: "+ student2);
//        System.out.println("Student 3: "+ student3);
//
//        System.out.println("The list of courses: ");
//        System.out.println("Course 1: "+ course1);
//        System.out.println("Course 2: "+ course2);

        //1. Map object to json
        ObjectMapper mapper = new ObjectMapper();
        try {
            var jsonStudent1 = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(student1);
            System.out.println(jsonStudent1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //2. Map JSON to Object
        var json = """
                {"id":"STD004","firstName":"Anh","lastName":"Tran","yearOfBirth":2005,"gpa":3.4}
                """;
        try {
            var student4 = mapper.readValue(json, Student.class);
            System.out.println("Student 4: " + student4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}