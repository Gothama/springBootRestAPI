package com.example.demo;
import com.example.demo.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    public StudentRepository studentRepository;

    @GetMapping(value = "/all")
    public List<com.example.demo.model.Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @PostMapping(value="/create")
    public String createStudent(@RequestBody Student student){
        Student insertStudent = studentRepository.insert(student);
        return "Student Created" + insertStudent.getName();
    }

    @DeleteMapping(value="/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentRepository.deleteById(id);
        return "Student Deleted " + id;
    }



}

