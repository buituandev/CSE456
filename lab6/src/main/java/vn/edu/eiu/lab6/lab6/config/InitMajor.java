package vn.edu.eiu.lab6.lab6.config;

import lombok.Getter;
import org.springframework.stereotype.Component;
import vn.edu.eiu.lab6.lab6.entity.Major;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class InitMajor {
    private List<Major> majorList;

    @PostConstruct
    public void init() {
        majorList = new ArrayList<>();
        majorList.add(new Major(1, "Computer Science", "Study of algorithms, programming, and computational systems"));
        majorList.add(new Major(2, "Information Technology", "Application of computers and technology to solve business problems"));
        majorList.add(new Major(3, "Software Engineering", "Design and development of software systems"));
        majorList.add(new Major(4, "Data Science", "Extraction of insights from data using scientific methods"));
        majorList.add(new Major(5, "Cybersecurity", "Protection of digital systems from cyber threats"));
        majorList.add(new Major(6, "Artificial Intelligence", "Development of intelligent machines and algorithms"));
        majorList.add(new Major(7, "Web Development", "Creation and maintenance of websites and web applications"));
        majorList.add(new Major(8, "Mobile Development", "Development of applications for mobile devices"));
        System.out.println("Initialize major list successful");
    }
}
