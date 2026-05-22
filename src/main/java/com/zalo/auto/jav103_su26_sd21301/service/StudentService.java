package com.zalo.auto.jav103_su26_sd21301.service;

import com.zalo.auto.jav103_su26_sd21301.entity.Student;
import com.zalo.auto.jav103_su26_sd21301.repository.StudentRepository;

import java.util.List;

public class StudentService {

    private StudentRepository studentRepository = new StudentRepository();

    public List<Student> getStudent() {
        return StudentRepository.getStudent();
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public Student getStudentById(Long id) {
        return StudentRepository.getStudentById(id);
    }

    public void updateStudent(Student student) {
        studentRepository.updateStudent(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }
}
