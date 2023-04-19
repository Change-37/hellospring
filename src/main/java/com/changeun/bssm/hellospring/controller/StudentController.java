package com.changeun.bssm.hellospring.controller;

import com.changeun.bssm.hellospring.domain.Student;
import com.changeun.bssm.hellospring.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/students")
    public String studentList(Model model){
        List<Student> students =  service.findStudents();
        model.addAttribute("students", students);
        return "students/studentList";
    }

    @GetMapping("/student/{id}/input")
    public String updateForm(@PathVariable("id") Long id, Model model){
        Student student = service.findById(id);
        model.addAttribute("form", student);
        return "students/updateStudentsForm";
    }

    @PostMapping("/students/{id}/input")
    public String updateScore(@PathVariable("id") Long id, @ModelAttribute("form") Student form){
        Student updateStudent = new Student();
        updateStudent.setId(form.getId());
        updateStudent.setName(form.getName());
        updateStudent.setScore(form.getScore());

        service.updateStudent(updateStudent);

        return "redirect:/students";
    }
}
