package ru.gb.homework2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.homework2.model.Student;
import ru.gb.homework2.repositories.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudentService() {
        return repository.getAllStudent();
    }

    public Student findStudentByIdService(Long id) {
        return repository.findStidentById(id);
    }

    public List<Student> getStudentListStudentNameService(String str) {
        return repository.getStudentListStudentName(str);
    }

    public List<Student> getStudentListGroupService(String groupname) {
        return repository.getStudentListGroup(groupname);
    }

    public Student createStudentService(Student student) {
        return repository.createStudent(student);
    }

    public void deleteStudentService(Long id) {
        repository.deleteStudent(id);
    }

    public Student updateStudentByIdService(Long id,  Student student) {
        return repository.updateStudentById(id, student);
    }
}
