package kg.megacom.university.services.impl;

import kg.megacom.university.models.Role;
import kg.megacom.university.models.Student;
import kg.megacom.university.repos.StudentRepo;
import kg.megacom.university.services.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public void addStudent(String name, String sureName, String studentGroup) {
        Student student = new Student();
        student.setName(name);
        student.setSureName(sureName);
        student.setStudentGroup(studentGroup);
        student.setRole(Role.STUDENT);
        studentRepo.save(student);
    }

    @Override
    public Iterable<Student> findAll() {
        return studentRepo.findAll();
    }
}
