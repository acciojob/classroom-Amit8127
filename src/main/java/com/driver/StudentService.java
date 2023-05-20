package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
    private StudentRepository studentRepository = new StudentRepository();
    private Map<String, Teacher> teachers = new HashMap<>();
    private Map<String, List<String>> studentTeacherPairs = new HashMap<>();

    public void addStudent(Student student) {
        studentRepository.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        List<String> students = studentTeacherPairs.computeIfAbsent(teacher, key -> new ArrayList<>());
        students.add(student);
    }

    public Student getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    public Teacher getTeacherByName(String name) {
        return teachers.get(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return studentTeacherPairs.getOrDefault(teacher, new ArrayList<>());
    }

    public List<String> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public void deleteTeacherByName(String teacher) {
        teachers.remove(teacher);
    }

    public void deleteAllTeachers() {
        teachers.clear();
        studentTeacherPairs.clear();
    }
}
