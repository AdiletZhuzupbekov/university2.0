package kg.megacom.university.services;

import kg.megacom.university.models.Student;

public interface StudentService {
    void addStudent(String name, String sureName, String studentGroup);

    Iterable<Student> findAll();
}
