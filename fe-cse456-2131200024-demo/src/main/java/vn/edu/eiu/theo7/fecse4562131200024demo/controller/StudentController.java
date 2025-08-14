package vn.edu.eiu.theo7.fecse4562131200024demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.edu.eiu.theo7.fecse4562131200024demo.model.Major;
import vn.edu.eiu.theo7.fecse4562131200024demo.model.Student;
import vn.edu.eiu.theo7.fecse4562131200024demo.service.MajorService;
import vn.edu.eiu.theo7.fecse4562131200024demo.service.StudentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Flow UI -- Controller (here) -- Service --Repo -- JDBC -- DB
 * Moi mot url thi can phai co mot ham xu ly
 * Doi voi form thi dung @PostMapping
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private MajorService majorService;

    //url localhost:8080/students --> return student-list.html
    /*
    Link nay co 2 cach request:
    1. Go truc tiep
    - Khi go truc tiep link /students neu ham xu ly co @RequestParam thi se bi loi null (npe) nen phai xu li
    bang 1 trong 2 cach: gan defaultvalue cho @RequestParam  
     */
    @GetMapping("students")
    public String students(@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword, Model model) {
        List<Student> studentList;
        if (keyword == null || keyword.isBlank()) {
            studentList = studentService.getAllStudents();
            model.addAttribute("studentList", studentList);
        } else {
            studentList = studentService.searchStudentsByName(keyword);
            model.addAttribute("studentList", studentList);
            model.addAttribute("keyword", keyword);
        }
        return "student-list";
    }

    @GetMapping("student/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("formMode", "edit");
        List<Major> majorList = majorService.getAllMajors();
        model.addAttribute("majorList", majorList);
        return "student-form";
    }

    @GetMapping("student/add")
    public String add(Model model) {
        List<Major> majorList = majorService.getAllMajors();
        model.addAttribute("majorList", majorList);
        model.addAttribute("formMode", "add");
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/student/form")
    public String saveStudent(
            @Valid @ModelAttribute("student") Student student,
            BindingResult bindingResult,
            Model model,
            @RequestParam(value = "formMode", required = false) String formMode
    ) {
        //Get info from form, if error back to form with a message
        if (bindingResult.hasErrors()) {
            model.addAttribute("formMode", formMode);
            model.addAttribute("majorList", majorService.getAllMajors());
            return "student-form";
        }
        
        /*
        If add new but id exist, return error and redirect to form with a message
        check if id is existed in db (need service)
        if id is existed, return error and redirect to form with a message
         */
        
        if(formMode.equals("add") && studentService.isIdExist(student.getId())){
            bindingResult.rejectValue("id", "error.idExist", "ID is existed");
            model.addAttribute("formMode", formMode);
            model.addAttribute("majorList", majorService.getAllMajors());
            return "student-form";
        }

        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") String id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            studentService.deleteStudentById(id);
        }
        return "redirect:/students";
    }

}
