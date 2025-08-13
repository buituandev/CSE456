package vn.edu.eiu.lab6.lab6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.eiu.lab6.lab6.config.InitMajor;
import vn.edu.eiu.lab6.lab6.entity.Major;

import java.util.List;

@Controller
public class MajorController {

    private final InitMajor initMajor;

    @Autowired
    public MajorController(InitMajor initMajor) {
        this.initMajor = initMajor;
    }

    // Display list of majors
    @GetMapping("/majors")
    public String majors(Model model) {
        List<Major> majors = initMajor.getMajorList();
        model.addAttribute("majors", majors);
        return "major-list";
    }

    // Show edit form for a specific major
    @GetMapping("/majors/edit/{id}")
    public String editMajor(Model model, @PathVariable int id) {
        for (var major : initMajor.getMajorList()) {
            if (major.getId() == id) {
                model.addAttribute("major", major);
                break;
            }
        }
        return "major-edit";
    }

    // Save edited major
    @PostMapping("/majors/edit")
    public String saveMajor(@RequestParam("id") int id,
                           @RequestParam("name") String name,
                           @RequestParam("description") String description,
                           RedirectAttributes redirectAttributes) {

        // Update major in the list
        for (var major : initMajor.getMajorList()) {
            if (major.getId() == id) {
                major.setName(name);
                major.setDescription(description);
                break;
            }
        }

        redirectAttributes.addFlashAttribute("pmsg", "Save major successfully");
        redirectAttributes.addFlashAttribute("pid", id);
        redirectAttributes.addFlashAttribute("pname", name);
        redirectAttributes.addFlashAttribute("pdescription", description);

        return "redirect:/majors";
    }

    // Show create form
    @GetMapping("/majors/new")
    public String showCreateForm(Model model) {
        model.addAttribute("major", new Major());
        return "major-create";
    }

    // Create new major
    @PostMapping("/majors/new")
    public String createMajor(@ModelAttribute Major major) {
        initMajor.getMajorList().add(major);
        return "redirect:/majors";
    }

    // Delete major
    @PostMapping("/majors/delete/{id}")
    public String deleteMajor(@PathVariable int id) {
        Major major = null;
        for (var m : initMajor.getMajorList()) {
            if (m.getId() == id) {
                major = m;
                break;
            }
        }

        if (major != null) {
            initMajor.getMajorList().remove(major);
        }
        return "redirect:/majors";
    }
}
