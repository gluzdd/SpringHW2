package ru.gb.homework2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.homework2.model.Student;
import ru.gb.homework2.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Student>> showAll() {
        return new ResponseEntity<>(service.getAllStudentService(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> showStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findStudentByIdService(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudentByName(@RequestParam String name) {
        return new ResponseEntity<>(service.getStudentListStudentNameService(name), HttpStatus.OK);
    }

    @GetMapping("/group/{groupname}")
    public ResponseEntity<List<Student>> showStudentByGroupname(@PathVariable String groupname) {
        return new ResponseEntity<>(service.getStudentListGroupService(groupname), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> addCreateStudent(@RequestBody Student student) {
        return new ResponseEntity<>(service.createStudentService(student), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeStudent(@PathVariable Long id) {
        service.deleteStudentService(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return new ResponseEntity<>(service.updateStudentByIdService(id, student), HttpStatus.OK);
    }

}
