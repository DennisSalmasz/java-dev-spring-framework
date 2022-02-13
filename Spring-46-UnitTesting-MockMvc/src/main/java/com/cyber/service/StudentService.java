package com.cyber.service;

import com.cyber.entity.Student;
import com.cyber.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent_data(){
        return studentRepository.findAll();
    }

}
