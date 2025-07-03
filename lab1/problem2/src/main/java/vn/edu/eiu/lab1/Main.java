package vn.edu.eiu.lab1;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection conn;
        //Sử dụng các class cung cấp sẵn có trong thư viên JDBC (có trong JAVA SDK)
        //JDBC sẽ tự động kết nối với MySQL JDBC Server (MySQL connector/java)
        try {
            String url = "jdbc:mysql://localhost:3306/cse456_q4_2025";
            var user = "root";
            var password = "admin123";

            //Đối với Java mới thì Driver sẽ được tự động dò tìm trong URL mà ko cần lệnh này.
            //Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database successfully");

            PreparedStatement pstmt = conn.prepareStatement("select * from Student");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                int yearOfBirth = rs.getInt("yob");
                double gpa = rs.getDouble("gpa");
//                System.out.println(id + "|" + firstName + "|" + lastName + "|" + yearOfBirth + "|" + gpa);
//                System.out.printf("\033[32m%s\033[0m|\033[34m%s\033[0m|\033[35m%s\033[0m|\033[33m%d\033[0m|\033[36m%.2f\033[0m%n", id, firstName, lastName, yearOfBirth, gpa);
                System.out.printf("|%4s|%-10s|%-10s|%4d|%4.2f|%n", id, firstName, lastName, yearOfBirth, gpa);
            }


            conn.close();
            System.out.print("Connection closed");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}