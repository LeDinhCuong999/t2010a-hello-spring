package com.aptech.t2010a.hellospring.controller;

import com.aptech.t2010a.hellospring.entity.Student;
import com.aptech.t2010a.hellospring.repository.StudentRepository;
import com.aptech.t2010a.hellospring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * http://localhost:8080/api/v1/students    | GET      | return list student
 * http://localhost:8080/api/v1/students    | POST     | create new student
 * http://localhost:8080/api/v1/students/1  | DELETE   | remove student
 * http://localhost:8080/api/v1/students/1  | GET   | find student by id
 * http://localhost:8080/api/v1/students/1  | PUT   | update student
 *
 **/
@RestController
@RequestMapping(path = "api/v1/students")

public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Student>> getList(@RequestParam(defaultValue = "1") int page){
        return ResponseEntity.ok(studentService.findAll());
    }

    @RequestMapping(path = "{id}",method = RequestMethod.GET)
    public ResponseEntity<?> fillById(@PathVariable String id){
        Optional<Student> optionalStudent = studentService.findById(id);
        if (!optionalStudent.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalStudent.get());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Student> save(@RequestBody Student student){
        return ResponseEntity.ok(studentService.save(student));
    }

    @RequestMapping(path = "{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@PathVariable String id){
        Optional<Student> optionalStudent = studentService.findById(id);
        if (!optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            studentService.deleteById(id);
        }
        return ResponseEntity.ok().build();
    }

    @RequestMapping(path = "{id}",method = RequestMethod.PUT)
    public ResponseEntity<Student> update(@PathVariable String id, @RequestBody Student student){
        Optional<Student> optionalStudent = studentService.findById(id);
        if (!optionalStudent.isPresent()){
            ResponseEntity.badRequest().build();
        }
        Student exitStudent = optionalStudent.get();
        exitStudent.setFullName(student.getFullName());
        exitStudent.setPhone(student.getPhone());
        exitStudent.setEmail(student.getEmail());
        exitStudent.setAddress(student.getAddress());
        exitStudent.setNote(student.getNote());
        exitStudent.setDob(student.getDob());
        exitStudent.setStatus(student.getStatus());
        return ResponseEntity.ok(studentService.save(exitStudent));
    }
}
