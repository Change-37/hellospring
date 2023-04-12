package com.changeun.bssm.hellospring.controller;

import com.changeun.bssm.hellospring.domain.Student;
import com.changeun.bssm.hellospring.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students/new")
    public String createForm() {
        return "students/createStudentsForm";
    }

    @PostMapping("/students/new")
    public String create(StudentForm form){
        Student student = new Student();
        student.setId(form.getId());
        student.setName(form.getName());

        service.edit(student);

        return "redirect:/";
    }
}
