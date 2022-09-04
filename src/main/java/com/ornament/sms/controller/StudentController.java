/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ornament.sms.controller;

import com.ornament.sms.entity.Student;
import com.ornament.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author manqo
 */

@Controller
public class StudentController {
    private StudentService service;

    public StudentController(StudentService service) {
        super();
        this.service = service;
    }
    
    @GetMapping("/students")
    public String listStudent(Model model){
        model.addAttribute("students", service.getAllStudents());
        return "students";
    }
    
    @GetMapping("/students/new")
    public String createStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }
    
    @PostMapping("/student")
    public  String createStudent(@ModelAttribute("student") Student student){
        service.createStudent(student);
        return "redirect:/students";
    }
    
    @GetMapping("/student/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", service.getStudentById(id));
        return "edit_student";
    }
    
    @PostMapping("/student/{id}")
    public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student){
        Student existingStudent = service.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        
        service.updateStudent(existingStudent);
        return "redirect:/students";
    }
    
    @GetMapping("/student/{id}")
    public String deleteStudent(@PathVariable Long id){
        service.deleteStudent(id);
        return "redirect:/students";
    }
}
