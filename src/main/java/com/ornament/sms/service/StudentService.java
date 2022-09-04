/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ornament.sms.service;

import com.ornament.sms.entity.Student;
import java.util.List;

/**
 *
 * @author manqo
 */
public interface StudentService {

    List<Student> getAllStudents();

    Student createStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student student);
    
    void deleteStudent(Long id);
}
