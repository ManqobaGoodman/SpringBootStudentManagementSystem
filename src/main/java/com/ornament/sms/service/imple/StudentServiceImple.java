/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ornament.sms.service.imple;

import com.ornament.sms.entity.Student;
import com.ornament.sms.repository.StudentRepository;
import com.ornament.sms.service.StudentService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author manqo
 */
@Service
public class StudentServiceImple implements StudentService{
    
    private StudentRepository studentRepository;

    public StudentServiceImple(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return  studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    
}
