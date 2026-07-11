package com.ssit.Studentdemo.controller;

import com.ssit.Studentdemo.dao.StudentDAO;
import com.ssit.Studentdemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentDAO studentDAO;

    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student) {
        return studentDAO.save(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentDAO.findById(id).orElse(null);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentDAO.save(student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentDAO.deleteById(id);
        return "Student Deleted Successfully";
    }
}
