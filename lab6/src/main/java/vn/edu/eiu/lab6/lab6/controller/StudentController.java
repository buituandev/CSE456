package vn.edu.eiu.lab6.lab6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.eiu.lab6.lab6.config.InitStudent;
import vn.edu.eiu.lab6.lab6.entity.Student;

import java.util.List;

/**
 * Xử lý và trả về kết quả là một trang web HTML.
 * Ứng với mỗi URL sẽ có một hàm xử lý tương ứng.
 */
@Controller
public class StudentController {

    private final InitStudent initStudent;

    @Autowired
    public StudentController(InitStudent initStudent) {
        this.initStudent = initStudent;
    }

    // Hiển thị trang index
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Hiển thị danh sách sinh viên cho URL /students
    @GetMapping("/students")
    public String students(Model model) {
        /*
         * Hàm được gọi khi user truy cập vào URL /students
         * Sau khi xử lý, trả về một view (template) để hiển thị kết quả
         * Nếu kèm theo data thì bỏ trong obj Model (attributeName, attributeValue)
         * Thymeleaf sẽ lấy data này thông qua tên attributeName
         * AttributeValue có thể là một đối tượng, một danh sách, một chuỗi, một số, một boolean, ...
         */
        List<Student> students = initStudent.getStudentList();
        model.addAttribute("students", students);
        return "student-list";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(Model model, @PathVariable int id) {
        /*
         * Các công việc cần làm:
         * - Hiển thị form có thông tin của sinh viên cần sửa
         * - Có nút Save để lưu thông tin mới
         * - Nút Cancel để quay lại trang danh sách sinh viên
         * Trả về trang student-edit.html có form chỉnh sửa student
         */
        for (var student : initStudent.getStudentList()) {
            if (student.getId() == id) {
                model.addAttribute("student", student);
                break;
            }
        }
        return "student-edit";
    }

    // Version1
//    @PostMapping("/students/edit")
//    public String saveStudent(@RequestParam("id") int id,
//                              @RequestParam("name") String name,
//                              @RequestParam("yob") int yob,
//                              @RequestParam("gpa") double gpa,
//                              Model model
//    ) {
//        // Lưu thông tin sinh viên vào database
//        // return "redirect:/students";
//        Student student = new Student(id, name, yob, gpa);
//        model.addAttribute("pmsg", "Save student successfully");
//        model.addAttribute("student", student);
//        return "result";
//    }

    /*
     * Khi xử lý form:
     * - Sau khi xử lý và trả về trang HTML, nhưng URL không thay đổi (vẫn là URL của action)
     * - Nếu bấm F5 thì sẽ gọi lại hàm xử lý form => lỗi resubmit form
     * - Trong trường hợp thêm mới data với key tự động tăng sẽ gây ra trùng dữ liệu
     */

//    // Version2: Dùng redirect để tránh lỗi form resubmit
//    @PostMapping("/students/edit")
//    public String saveStudent(@RequestParam("id") int id,
//                              @RequestParam("name") String name,
//                              @RequestParam("yob") int yob,
//                              @RequestParam("gpa") double gpa,
//                              RedirectAttributes redirectAttributes) {
//
//        // Lưu thông tin sinh viên vào database
//        Student student = new Student(id, name, yob, gpa);
//        redirectAttributes.addFlashAttribute("pmsg", "Save student successfully");
//        redirectAttributes.addFlashAttribute("student", student);
//
//        return "redirect:/students/edit/result"; // Chuyển sang đường link khác, không phải là HTML
//
//        /*
//         * Why model is not needed. Model is sent with HTML for Thymeleaf to render. But we
//         * are not rendering HTML, but redirecting to another URL.
//         */
//    }
//
//    @GetMapping("/students/edit/result")
//    public String saveStudentResult(Model model) {
//        return "result";
//        // Sẽ bị lỗi null vì không nhận được data từ model của bên @PostMapping saveStudent
//        // Xử lý bằng cách khi redirect bên saveStudent gửi kèm thêm gói hàng
//        // RedirectAttributes. This means this method has 2 types of request:
//        // 1. Its model
//        // 2. Its redirect (sent from saveStudent)
//    }

    /*
     * Version3: lay thong tin da sua redirect sang trang student-list
     *
     */
    @PostMapping("/students/edit")
    public String saveStudent(@RequestParam("id") int id,
                              @RequestParam("name") String name,
                              @RequestParam("yob") int yob,
                              @RequestParam("gpa") double gpa,
                              RedirectAttributes redirectAttributes) {

        // Lưu thông tin sinh viên vào database
        redirectAttributes.addFlashAttribute("pmsg", "Save student successfully");
        redirectAttributes.addFlashAttribute("pid", id);
        redirectAttributes.addFlashAttribute("pname", name);
        redirectAttributes.addFlashAttribute("pyob", yob);
        redirectAttributes.addFlashAttribute("pgpa", gpa);

        return "redirect:/students"; // Chuyển sang đường link khác, không phải là HTML
    }

}
