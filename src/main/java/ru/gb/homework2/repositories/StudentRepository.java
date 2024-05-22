package ru.gb.homework2.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.gb.homework2.model.Student;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class StudentRepository {
    private final Map<Long, Student> studentList = new ConcurrentHashMap<>();
    private static AtomicLong counter = new AtomicLong(0L);

    @PostConstruct
    private void addStudentList() {
        studentList.put(counter.incrementAndGet(), new Student(counter.get(), "Artem", "Midle"));
        studentList.put(counter.incrementAndGet(), new Student(counter.get(), "Kris", "Midle"));
        studentList.put(counter.incrementAndGet(), new Student(counter.get(), "Ivan", "Senior"));
        studentList.put(counter.incrementAndGet(), new Student(counter.get(), "Javokhir", "Junior"));
        studentList.put(counter.incrementAndGet(), new Student(counter.get(), "Vika", "Midle"));
    }


    // Показать всех студентов
    public List<Student> getAllStudent() {
        return new ArrayList<>(studentList.values());
    }

    // Показать студета по id
    public Student findStidentById(Long id) {
        return studentList.get(id);
    }

    // Получить список студентов, чье имя содержит подстроку studentName
    public List<Student> getStudentListStudentName(String str) {
        return studentList.values().stream().filter(student -> student.getName().contains(str)).toList();
    }

    // Получить всех студентов группы
    public List<Student> getStudentListGroup(String groupname) {
        return studentList.values().stream().filter(student -> student.getGroupname().contains(groupname)).toList();
    }

    // Cоздать студента
    public Student createStudent(Student student) {
        if (student.getId() == null) {
            student.setId(counter.incrementAndGet());
        }
        studentList.put(student.getId(), student);
        return student;
    }

    // Удалить студента
    public void deleteStudent(Long id) {
        studentList.remove(id);
    }

    // Обновить данные студента
    public Student updateStudentById(Long id,  Student student) {
        Student updateStudent = studentList.get(id);
        if (updateStudent != null) {
            updateStudent.setName(student.getName());
            updateStudent.setGroupname(student.getGroupname());
        }
        return updateStudent;
    }
}
