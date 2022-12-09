package com.ltp.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class GradeController {

    List<Grade> grades = new ArrayList<>();

    @GetMapping("/")
    public String gradeForm(Model model, @RequestParam(required = false) final String id) {
        Integer index = GradeService.getGrade(this.grades, id);

        model.addAttribute("grade", Objects.nonNull(index) ? grades.get(index) : new Grade());

        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitGrade(Grade grade) {
        Integer index = GradeService.getGrade(this.grades, grade.getId());

        if (Objects.nonNull(index)) {
            this.grades.set(index, grade);
            return "redirect:/grades";
        } else {
            this.grades.add(grade);
            return "redirect:/";
        }
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", grades);
        return "grades";
    }
}
